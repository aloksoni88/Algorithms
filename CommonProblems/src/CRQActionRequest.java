import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CRQActionRequest {

	public static void main(String[] args) throws Exception {
		String request = null;
		// Create name value pairs
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		// For first CRQ call, answer and questionid will not be required
		/*params.add(new BasicNameValuePair("answer", "BANK OF INDIA TEST" + ":"
				+ "APR-2016"));
		params.add(new BasicNameValuePair("questionId", "1"));*/
		params.add(new BasicNameValuePair("clientName", "CLICBRICS_FM"));
		params.add(new BasicNameValuePair("stgOneHitId", "1584271"));
		params.add(new BasicNameValuePair("stgTwoHitId", "1543953"));
		// Get JSON string from name value pair list
		request = getQuery(params);
		System.out.println("request :" + request);

		Map questionMap = generateQuestionForConsumer(request,
				"3C97C0B05BE2236CFFCCDE1A549BADD8");
		
	}

	/**
	 * Parse JSON string from Response and populate key value pair in map
	 * 
	 */
	private static Map parseJson(String json) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, Map.class);
	}

	/**
	 * Extract JSON string from Response
	 * 
	 */
	private static String print(HttpURLConnection conn) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());
		JsonObject jsonObject = new JsonObject();
		Object obj = new JSONParser().parse(response.toString());
		parseCRQJsonResponse(obj);
		return response.toString();
	}
	
	private static void parseCRQJsonResponse(Object obj){
		JSONParser parser = new JSONParser();
		try {
			
			// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
			JSONObject jObj = (JSONObject) obj;
 
			JSONObject jsonObj = (JSONObject) jObj.get("questionToCustomer");
			System.out.println(jsonObj);
			HashMap<String, ArrayList<String>> map = new HashMap<>();
			String question = (String) jsonObj.get("question");
			String[] queArr = question.split("\\?");
			
			JSONArray arr1 = (JSONArray) jsonObj.get("optionsSet1");
			ArrayList question1List = new ArrayList<>();
			for(int i=0; i<arr1.size(); i++){
				question1List.add((String) arr1.get(i));
			}
			
			JSONArray arr2 = (JSONArray) jsonObj.get("optionsSet2");
			ArrayList question2List = new ArrayList<>();
			for(int i=0; i<arr2.size(); i++){
				question2List.add((String) arr2.get(i));
			}
			map.put(queArr[1], question2List);
			
			long questionId = (Long) jsonObj.get("qid");
			
			long stgOneId = (long) jObj.get("stgOneHitId");
			long stgTwoId = (long) jObj.get("stgTwoHitId");
			
			System.out.println(stgOneId + ", " + stgTwoId);
			
			System.out.println(map);
			System.out.println(questionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * Encode all values and convert name value pair into JSON string
	 * (key=value&key=value&.....)
	 * 
	 */
	private static String getQuery(List<NameValuePair> params)
			throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;

		for (NameValuePair pair : params) {
			if (first)
				first = false;
			else
				result.append("&");

			result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
		}

		return result.toString();
	}

	/**
	 * Call CRQ action with JSON string and session Id
	 * 
	 */
	private static Map generateQuestionForConsumer(String request,
			String jsessionId) throws Exception {

		String url = "https://cbv2cpu.uat.experian.in:16443/ECV-P2/content/generateQuestionForConsumer.action";
		// String url =
		// "http://localhost:9022/ECV-P2/content/generateQuestionForConsumer.action";

		System.out.println("Call url : " + url);

		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty(
				"User-Agent",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:40.0) Gecko/20100101 Firefox/40.0");
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("Cookie", "JSESSIONID=" + jsessionId);
		OutputStream os = conn.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,
				"UTF-8"));
		writer.write(request);
		writer.flush();
		writer.close();
		os.close();
		int status = conn.getResponseCode();
		if (status == HttpURLConnection.HTTP_OK) {

			return parseJson(print(conn));
		}
		return null;
	}
}
