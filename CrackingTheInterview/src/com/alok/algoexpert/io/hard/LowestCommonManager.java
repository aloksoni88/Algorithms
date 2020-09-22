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
		return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
	}
	
	public static OrgInfo getOrgInfo(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
		int reporteeCount = 0;
		for(OrgChart manager : topManager.directReports) {
			OrgInfo orgInfo = getOrgInfo(manager, reportOne, reportTwo);
			if(orgInfo.lowestCommonManager != null){
					return orgInfo;
			}
			reporteeCount = reporteeCount + orgInfo.reporteeCount;
		}
		if(topManager == reportOne || topManager == reportTwo) {
				reporteeCount++;
		}
		OrgChart lowestCommonManager = reporteeCount == 2 ? topManager : null;
		OrgInfo orgInfo = new OrgInfo(lowestCommonManager, reporteeCount);
		return orgInfo;
	}
	
	
	static class OrgInfo{
		int reporteeCount;
		OrgChart lowestCommonManager;
		
		public OrgInfo(OrgChart lowestCommonManager, int reporteeCount) {
			this.lowestCommonManager = lowestCommonManager;
			this.reporteeCount = reporteeCount;
		}
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
