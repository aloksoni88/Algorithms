/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alok Soni
 *
 */
public class CalendarMatching {
	public static void main(String[] args) {
		List<StringMeeting> calendar1 = new ArrayList<StringMeeting>();
	    calendar1.add(new StringMeeting("10:00", "10:30"));
	    calendar1.add(new StringMeeting("10:45", "11:15"));
	    calendar1.add(new StringMeeting("11:30", "13:00"));
	    calendar1.add(new StringMeeting("14:15", "16:00"));
	    calendar1.add(new StringMeeting("16:00", "18:00"));

	    StringMeeting dailyBounds1 = new StringMeeting("9:30", "20:00");

	    List<StringMeeting> calendar2 = new ArrayList<StringMeeting>();
	    calendar2.add(new StringMeeting("10:00", "11:00"));
	    calendar2.add(new StringMeeting("12:30", "13:30"));
	    calendar2.add(new StringMeeting("14:30", "15:00"));
	    calendar2.add(new StringMeeting("16:00", "17:00"));

	    StringMeeting dailyBounds2 = new StringMeeting("09:00", "18:30");
	    
	    int meetingDuration = 15;
	    
	    List<StringMeeting> availBlockList = calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration);
	    System.out.println(availBlockList);
	}

	//Time - O(c1+c2)
	//Space - O(c1 +c2) 
	//where c1 & c2 are the numbers of meetings in calendar1 and calendar2 respectively
	public static List<StringMeeting> calendarMatching(List<StringMeeting> calendar1, 
			StringMeeting dailyBounds1,List<StringMeeting> calendar2, StringMeeting dailyBounds2,
			int meetingDuration) {
		List<StringMeeting> availSlots = new ArrayList<>();
		
		calendar1.add(0, new StringMeeting("00:00", dailyBounds1.start));
		calendar1.add(new StringMeeting(dailyBounds1.end, "23:59"));
		
		calendar2.add(0, new StringMeeting("00:00", dailyBounds2.start));
		calendar2.add(new StringMeeting(dailyBounds2.end, "23:59"));
		
		List<Meeting> meetingList1 = updateCalendarMeetings(calendar1);
		List<Meeting> meetingList2 = updateCalendarMeetings(calendar2);
		
		System.out.println("Calendar1: " + meetingList1);
		System.out.println("Calendar2: " + meetingList2);
		
		List<Meeting> mergedList = mergeList(meetingList1, meetingList2);
		System.out.println(mergedList);
		
		List<Meeting> combinedList = combinedList(mergedList);
		System.out.println(combinedList);
		
		availSlots = getAvailableSlots(combinedList,meetingDuration);
		return availSlots;
	}
	
	private static List<Meeting> updateCalendarMeetings(List<StringMeeting> list){
		List<Meeting> meetings = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			StringMeeting stringMeeting = list.get(i);
			
			String[] startArr = stringMeeting.start.split(":");
			String[] endArr = stringMeeting.end.split(":");
			
			int startTime = (Integer.parseInt(startArr[0]) * 60) + Integer.parseInt(startArr[1]);
			int endTime = (Integer.parseInt(endArr[0]) * 60) + Integer.parseInt(endArr[1]);
			
			Meeting meeting = new Meeting(startTime, endTime);
			meetings.add(meeting);
		}
		
		return meetings;
	}
	
	private static List<Meeting> mergeList(List<Meeting> list1, List<Meeting> list2){
		List<Meeting> mergedList = new ArrayList<>();
		int i=0, j=0;
		while(i < list1.size() && j < list2.size()) {
			Meeting meeting1 = list1.get(i);
			Meeting meeting2 = list2.get(j);
			
			if(meeting1.start < meeting2.start) {
				mergedList.add(meeting1);
				i++;
			}else {
				mergedList.add(meeting2);
				j++;
			}
		}
		
		while(i < list1.size()) {
			mergedList.add(list1.get(i++));
		}
		
		while(j < list2.size()) {
			mergedList.add(list2.get(j++));
		}
		return mergedList;
	}
	
	private static List<Meeting> combinedList(List<Meeting> list){
		List<Meeting> combinedList = new ArrayList<>();
		Meeting prevMeeting = list.get(0);
		for(int i=1; i<list.size(); i++) {
			Meeting currMeeting = list.get(i);
			if(prevMeeting.end >= currMeeting.start) {
				prevMeeting = new Meeting(prevMeeting.start, Math.max(prevMeeting.end, currMeeting.end));
			}else {
				combinedList.add(prevMeeting);	
				prevMeeting = list.get(i);
			}
		}
		if(!combinedList.contains(prevMeeting)) {
			combinedList.add(prevMeeting);
		}
		return combinedList;
	}
	
	private static List<StringMeeting> getAvailableSlots(List<Meeting> list,int meetingDuration){
		List<StringMeeting> availSlots = new ArrayList<>();
		for(int i=0; i<list.size()-1; i++) {
			if((list.get(i+1).start - list.get(i).end) < meetingDuration) {
				continue;
			}
			
			int meetingStartTime = list.get(i).end;
			int meetingEndTime = list.get(i+1).start;
			
			String start = meetingStartTime/60 + ":" + (meetingStartTime%60 == 0 ? "00" : meetingStartTime%60);
			String end = meetingEndTime/60 + ":" + (meetingEndTime%60 == 0 ? "00" : meetingEndTime%60);
			
			availSlots.add(new StringMeeting(start, end));
		}
		return availSlots;
	}
	

	static class Meeting {
		public int start;
		public int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return start + "-" + end;
		}
	}
	
	static class StringMeeting {
		public String start;
		public String end;

		public StringMeeting(String start, String end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return start + "-" + end;
		}
	}
}
