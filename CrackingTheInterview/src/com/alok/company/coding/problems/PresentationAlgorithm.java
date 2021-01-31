/**
 * 
 */
package com.alok.company.coding.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alok Soni
 *
 */

/**
 * 
 * check Coding Exercise- Java.pdf
 */
public class PresentationAlgorithm {
	
	public static void main(String[] args) {
		List<Presentation> list = readPresentationFile();
		Collections.sort(list, new Presentation());
		System.out.println("Presenters list");
		System.out.println("Presenter Name" + "	" + "No. of Hours for Presentation" + "	" + "Cost benefit for presenter");
		System.out.println(list);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please provide the no of hours in session:");
		int sessionHour = scanner.nextInt();
		scanner.close();
		System.out.println("Total Number of sessions are : ");
		List<Presentation> result = getNumberOfSessions(sessionHour, list);
		if(result == null || result.isEmpty()) {
			System.out.println("Not enough presenters");
		}else {
			System.out.println(result);
		}
		
	}
	
	private static List<Presentation> getNumberOfSessions(int hours, List<Presentation> list) {
		List<Presentation> result = new ArrayList<>();
		int totalHour = 0;
		for(int i=0; i<list.size(); i++) {
			Presentation presentation = list.get(i);
			if(presentation.getNoOfHours() <= (hours/2) 
					&& hours >= (totalHour + presentation.getNoOfHours())) {
				totalHour = totalHour + presentation.getNoOfHours();
				result.add(presentation);
			}
		}
		return result;
	}
	
	/**
	 * Method to Read the csv file
	 * @return - List of Presentation 
	 */
	private static List<Presentation> readPresentationFile(){
		try {
			String line = "";  
			String splitBy = ",";
			int counter = 0;
			List<Presentation> list = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader("Presentation_File.csv"));
			while ((line = br.readLine()) != null) 
			{
				if(counter == 0) {
					counter++;
					continue;
				}
				String[] presentation = line.split(splitBy); 	
				Presentation pre = getPresentation(presentation);
				list.add(pre);
			}
			br.close();
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Method to create the presentation object from array(row data in csv) 
	 * @param arr -  row data in csv
	 * @return - Presentation object
	 */
	private static Presentation getPresentation(String[] arr) {
		Presentation presentation = new Presentation();
		presentation.setPresentationName(arr[0]);
		presentation.setNoOfHours(Integer.parseInt(arr[1]));
		presentation.setPresentationCost(Integer.parseInt(arr[2].substring(1)));
		return presentation;
	}
		
}

class Presentation implements Comparator<Presentation>{
	private String presentationName;
	private Integer noOfHours;
	private Integer presentationCost;
	
	
	
	/**
	 * @return the presentationName
	 */
	public String getPresentationName() {
		return presentationName;
	}




	/**
	 * @param presentationName the presentationName to set
	 */
	public void setPresentationName(String presentationName) {
		this.presentationName = presentationName;
	}




	/**
	 * @return the noOfHours
	 */
	public Integer getNoOfHours() {
		return noOfHours;
	}




	/**
	 * @param noOfHours the noOfHours to set
	 */
	public void setNoOfHours(Integer noOfHours) {
		this.noOfHours = noOfHours;
	}




	/**
	 * @return the presentationCost
	 */
	public Integer getPresentationCost() {
		return presentationCost;
	}




	/**
	 * @param presentationCost the presentationCost to set
	 */
	public void setPresentationCost(Integer presentationCost) {
		this.presentationCost = presentationCost;
	}




	@Override
	public String toString() {		
		return presentationName + "	" + noOfHours + "	" + "$" + presentationCost + "\n";
	}



	/**
	 * Sorting based on the noOfHours
	 * if hours are same then sorting based on cost
	 */
	@Override
	public int compare(Presentation p1, Presentation p2) {
		int result = p1.getNoOfHours().compareTo(p2.getNoOfHours()); 		
		if(result == 0) {
			return p1.getPresentationCost().compareTo(p2.getPresentationCost());
		}
		return result;
	}
	
	
}
