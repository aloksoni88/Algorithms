import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TestMarkedAction {
	
	public static void main(String[] args) {
		invokeMaskedAction();
	}
	/**
	 * Create name value pair for key-values and call single action with JSON string
	 *
	 * CLIENT_NAME, VOUCHER_CODE, MOBILE_NUMBER, EMAIL_ID, meta data flags and test case details needs to be set as required
	 * 
	 */
	private static void invokeMaskedAction(){
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("stgOneHitId", "1587961"));
		params.add(new BasicNameValuePair("stgTwoHitId", "1547616"));
		params.add(new BasicNameValuePair("clientName", "CLICBRICS_FM"));
		String request;
		try {
			request = getQuery(params);
			System.out.println("request being printed "+request);
			maskedRequest(request);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * Create encoded JSON string from name value pairs (key=value&key=value&.....)
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
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
	 * Call to single action url with json string
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String maskedRequest(String params) throws Exception {
		try {

			String url = "https://cbv2cpu.uat.experian.in:16443/ECV-P2/content/generateMaskedDeliveryData.action";
//			 String url = "http://localhost:9022/ECV-P2/content/singleAction.action";

			System.out.println("Call url : " + url);

			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("POST");	
		
			
			OutputStream os = conn.getOutputStream();
			os.write(params.getBytes());
			os.flush();
			os.close();

			int status = conn.getResponseCode();

			if (status == HttpURLConnection.HTTP_OK) {

				String response = print(conn);
				System.out.println("Response ");
				Object obj = new JSONParser().parse(response);
				if(response != null){
					JSONObject jsonObj = (JSONObject) obj;
					String responseJson = (String) jsonObj.get("responseJson");
					String stageOneId = jsonObj.get("stgOneHitId")+"";
					String stageTwoId = jsonObj.get("stgTwoHitId") + "";
					
					
					JSONArray maskedEmailADDRArr =  (JSONArray)jsonObj.get("maskedEmailADDR");
					String maskedEmailADDR = (String) maskedEmailADDRArr.get(0);
					
					JSONArray maskMobilenoArr =  (JSONArray)jsonObj.get("maskMobileno");
					String maskMobileno = (String) maskMobilenoArr.get(0);			
					
					
					System.out.println(responseJson);
					System.out.println(stageOneId);
					System.out.println(stageTwoId);
					System.out.println(maskedEmailADDR);
					System.out.println(maskMobileno);
					//System.out.println(report);
					
					authenticateAction(stageOneId, stageTwoId, maskedEmailADDR, maskMobileno);
					
				}
			
				Map map = parseJson(response);

				if (map.get("errorString") != null && map.get("errorString").toString() != "" && map.get("errorString").toString() != null) {
					return "error " + map.get("errorString").toString();
				}

			}else{
				System.out.println("Error with status " + status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	
	private static void authenticateAction(String stageOneId,String stageTwoId,String maskedEmailId,String maskedPhoneNo){
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("stgOneHitId", stageOneId));
		params.add(new BasicNameValuePair("stgTwoHitId", stageTwoId));
		params.add(new BasicNameValuePair("ActualEmailADDR", maskedEmailId));
		//params.add(new BasicNameValuePair("ActualEmailADDR", "alok@tuwheelz.com"));
		params.add(new BasicNameValuePair("ActualMobileNumber", maskedPhoneNo));
		//params.add(new BasicNameValuePair("ActualMobileNumber", "8377944972"));
		String request;
		try {
			request = getQuery(params);
			System.out.println("request being printed "+request);
			authenticateRequest(request);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String authenticateRequest(String params) throws Exception {
		try {

			String url = "https://cbv2cpu.uat.experian.in:16443/ECV-P2/content/authenticateDeliveryData.action";
//			 String url = "http://localhost:9022/ECV-P2/content/singleAction.action";

			System.out.println("Call url : " + url);

			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("POST");	
		
			
			OutputStream os = conn.getOutputStream();
			os.write(params.getBytes());
			os.flush();
			os.close();

			int status = conn.getResponseCode();

			if (status == HttpURLConnection.HTTP_OK) {

				String response = print(conn);
				System.out.println("Response ");
				Object obj = new JSONParser().parse(response);
				if(response != null){
					JSONObject jsonObj = (JSONObject) obj;
					String errString = (String) jsonObj.get("errorString");
					String stageOneId = (String) jsonObj.get("stageOneId_");
					String stageTwoId = (String) jsonObj.get("stageTwoId_");
					String report = (String) jsonObj.get("showHtmlReportForCreditReport");
					
					
					System.out.println(errString);
					System.out.println(stageOneId);
					System.out.println(stageTwoId);
					//System.out.println(report);
					
					if(errString == null){
						System.out.println("***** " + StringEscapeUtils.unescapeXml(report));
						System.out.println(report);
					}else{
						System.out.println("Report is null");
					}
					
					/*DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(new ByteArrayInputStream(report.getBytes("UTF-8")));
					
					System.out.println(doc.getTextContent());*/
				}
			
				Map map = parseJson(response);

				if (map.get("errorString") != null && map.get("errorString").toString() != "" && map.get("errorString").toString() != null) {
					return "error " + map.get("errorString").toString();
				}

			}else{
				System.out.println("Error with status " + status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Get JSON string from single action response
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private static String print(HttpURLConnection conn) throws Exception{
	
		BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) 
		{
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());
		return response.toString();
	}
	
	/**
	 * Parse JSON string from response and put each key-value pair in map
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	private static Map parseJson(String json) throws Exception{
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, Map.class);
	}
}
