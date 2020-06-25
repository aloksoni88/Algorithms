

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;




public class FileWriterTest {
	public static List<String> processedIDs = new ArrayList<>();
	static int counter = 0;
	public static void main(String[] args) {
		readProcessIds();
		process();
	}
	
	private static void addItem(){
		int size = new Random().nextInt(10);
		addItem(size,processedIDs.size());
		
	}
	
	private static void addItem(int count,int startValue){
		for(int i=startValue; i<(startValue + count); i++){
			String item = "QUERY_CONFIG_SLOTS-" + i;
			
			if(processedIDs != null && processedIDs.contains(item.trim())){
				continue;
			}
			processedIDs.add("QUERY_CONFIG_SLOTS-" + i);
		}
		System.out.println(processedIDs.size() + " "+ processedIDs);
	}
	
	private static void process(){
		try{
			while(true){
				addItem();
				counter++;
				Thread.sleep(1000*10);
				if(counter >= 4){
					copyProcessIDsToFile();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void readProcessIds(){
		if(processedIDs != null){
			processedIDs.clear();
		}
		File file = new File("testfile.txt");
		if(file.exists()){
			List<String> processIds = readFile(file);
			if(processIds != null && processIds.size()>0){
				processedIDs.addAll(processIds);
			}
		}
		
		System.out.println("ids from file " + processedIDs.size()  + " "+ processedIDs);
	}
	
	private static void copyProcessIDsToFile(){
		handleProcessedIDs();
		System.out.println("Copy id to file");
		if(processedIDs != null && processedIDs.size() > 0){
			try {
				File file = new File("testfile.txt");
				if(file.exists()){
					boolean isDeleted = file.delete();
					System.out.println("File deleted "+ isDeleted);
					file.createNewFile();
				}else{
					file.createNewFile();
				}
				/*BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				int cnt = 0;
				for(int i=processedIDs.size()-1; i>0; i--){
					writer.write(processedIDs.get(i) + "\n");
					if(cnt == 200){
						break;
					}
					cnt++;
				}
				writer.flush();
				writer.close();*/
				counter=0;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<String> readFile(File fileName){
		List<String> result = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(line.trim().length() != 0){
	    		  result.add(line);
		    	}
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	private static void handleProcessedIDs(){
		if(processedIDs != null && processedIDs.size() > 200){
			ListIterator<String> it = processedIDs.listIterator();
			int count = processedIDs.size() - 200;
			while(it.hasNext()){
				if(count > 0){
					count--;
					it.next();
					it.remove();
				}else{
					break;
				}
			}
		}
	}
}
