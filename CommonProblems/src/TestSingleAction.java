
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;



public class TestSingleAction {
	
	public static void main(String args[]){
		invokeSingleRequest();
		
	}
	
	/**
	 * Create name value pair for key-values and call single action with JSON string
	 *
	 * CLIENT_NAME, VOUCHER_CODE, MOBILE_NUMBER, EMAIL_ID, meta data flags and test case details needs to be set as required
	 * 
	 */
	private static void invokeSingleRequest(){
		
	
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("clientName", "CLICBRICS_FM"));
		params.add(new BasicNameValuePair("allowInput", "1"));
		params.add(new BasicNameValuePair("allowEdit", "1"));
		params.add(new BasicNameValuePair("allowCaptcha", "1"));
		params.add(new BasicNameValuePair("allowConsent", "1"));
		params.add(new BasicNameValuePair("allowEmailVerify", "1"));
		params.add(new BasicNameValuePair("allowVoucher", "1"));
		params.add(new BasicNameValuePair("noValidationByPass","0"));
        params.add(new BasicNameValuePair("emailConditionalByPass","1"));
		params.add(new BasicNameValuePair("voucherCode", "ClicBricsQQXoA"));
		
	    params.add(new BasicNameValuePair("firstName", "Alok"));
	    //params.add(new BasicNameValuePair("middleName", ""));
		params.add(new BasicNameValuePair("surName", "Gautam"));
		params.add(new BasicNameValuePair("dateOfBirth", "13-Jan-1985"));
		params.add(new BasicNameValuePair("gender", "2"));//1581431
		//params.add(new BasicNameValuePair("mobileNo", "9873400053"));
		params.add(new BasicNameValuePair("mobileNo", "8377944971"));
		params.add(new BasicNameValuePair("email", "alok@clicbrics.com"));
		params.add(new BasicNameValuePair("flatno", "Ho.No. 0047"));
		params.add(new BasicNameValuePair("city", "Pune"));
		params.add(new BasicNameValuePair("state", "27"));//1581415
		params.add(new BasicNameValuePair("pincode", "411046"));
		//params.add(new BasicNameValuePair("pan", "BQGPM6634M"));
		//params.add(new BasicNameValuePair("reason", "test"));
		//params.add(new BasicNameValuePair("telephoneNo", ""));
		//params.add(new BasicNameValuePair("telephoneType", "0"));
		//params.add(new BasicNameValuePair("passport", ""));
		//params.add(new BasicNameValuePair("voterid", ""));
		//params.add(new BasicNameValuePair("aadhaar", ""));
		//params.add(new BasicNameValuePair("driverlicense", ""));
		String request;
		try {
			request = getQuery(params);
			System.out.println("request being printed "+request);
			singleRequest(request);
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
	public static String singleRequest(String params) throws Exception {
		try {

			String url = "https://cbv2cpu.uat.experian.in:16443/ECV-P2/content/singleAction.action";
//			 String url = "http://localhost:9022/ECV-P2/content/singleAction.action";

			System.out.println("Call url : " + url);

			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setConnectTimeout(60000);
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
						System.out.println("============ " + StringEscapeUtils.unescapeXml(report));
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
