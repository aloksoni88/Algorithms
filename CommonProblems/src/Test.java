

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;;

public class Test {
	private static ArrayList<String> list = new ArrayList<>();
	public static void main(String[] args){
		
	
		try {
			JSONObject jsonObj = (JSONObject) new JSONParser().parse(new FileReader("test.json"));
			System.out.println(jsonObj);
			
			String stgOneHitId = "", stgTwoHitId = "",maskMobNo = "", maskEmailId = "";
			stgOneHitId =  (Long)jsonObj.get("stgOneHitId")+"";
			stgTwoHitId = (Long) jsonObj.get("stgTwoHitId")+"";
			maskMobNo = ((JSONArray)jsonObj.get("maskMobileno")).get(0)+"";
			maskEmailId = ((JSONArray)jsonObj.get("maskedEmailADDR")).get(0)+"";
			
			System.out.println(stgOneHitId + ", " + stgTwoHitId + ", " + maskMobNo + ", " +maskEmailId);
			
			
			File xmlFile = new File("report.xml");
			String content = "";
		    try
		    {
		        content = new String (Files.readAllBytes(Paths.get("report.xml")));
		    } 
		    catch (Exception e) 
		    {
		        e.printStackTrace();
		    }
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new ByteArrayInputStream(content.getBytes("UTF-8")));
			
			
			NodeList queryList = doc.getElementsByTagName("SCORE");
			if(queryList != null && queryList.getLength() > 0){
				Node node = queryList.item(0);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) node;
					String score = element.getElementsByTagName("BureauScore").item(0).getTextContent();
					System.out.println("Score == "+score);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
