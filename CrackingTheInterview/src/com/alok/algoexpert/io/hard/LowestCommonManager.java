/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class LowestCommonManager {
	public static void main(String[] args) {

	}

	public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
		// Write your code here.
		return topManager; // Replace this line.
	}

	static class OrgChart {
		public char name;
		public List<OrgChart> directReports;

		OrgChart(char name) {
			this.name = name;
			this.directReports = new ArrayList<OrgChart>();
		}

		// This method is for testing only.
		public void addDirectReports(OrgChart[] directReports) {
			for (OrgChart directReport : directReports) {
				this.directReports.add(directReport);
			}
		}
	}
}
