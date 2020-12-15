import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class MinParkingSpace {
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		int maxParkingCount = 0;

		Set<Integer> startTime = new HashSet<Integer>();
		for (int i = 0; i < parkingStartEndTimes.length; i++) {
			startTime.add(parkingStartEndTimes[i][0]);
		}
		return startTime.stream().mapToInt(time -> parkedCarsAtTime(time, parkingStartEndTimes)).max().getAsInt();
	}

	private static int parkedCarsAtTime(int minute, int[][] parkingStartEndTimeList) {
		
		int carsParked = 0;
		for (int i = 0; i < parkingStartEndTimeList.length; i++) {
			if (minute >= parkingStartEndTimeList[i][0] && minute < parkingStartEndTimeList[i][1]) {
				carsParked++;
			}
		}
		System.out.println(minute+" "+carsParked);
		return carsParked;
	}
//	static int minParkingSpaces(int[][] parkingStartEndTimes) {
//		if(parkingStartEndTimes.length <= 1) {
//			return parkingStartEndTimes.length;
//		}
//		int result = 0;
//		int count = 0;
//		List<ParkingRecord> parkingRecords = new ArrayList<>();
//
//		for (int i = 0; i < parkingStartEndTimes.length; i++) {
//			int startTime = parkingStartEndTimes[i][0];
//			int endTime = parkingStartEndTimes[i][1];
//			parkingRecords.add(new ParkingRecord(startTime, true));
//			parkingRecords.add(new ParkingRecord(endTime, false));
//		}
//
//	
//		parkingRecords = parkingRecords.stream()
//        .sorted(Comparator.comparingInt(ParkingRecord::getTime))
//        .collect(Collectors.toList());
//		
//
//		for (ParkingRecord pr : parkingRecords) {
//			if (pr.getStarted()) {
//				count++;
//				result = Math.max(result, count);
//			} else {
//				count--;
//			}
//		}
//		return result;
//	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		//4
		//5,10 0,20 25,40 35,50
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}

class ParkingRecord {

	private int time;
	private boolean started;

	public int getTime() {
		return time;
	}

	public boolean getStarted() {
		return started;
	}

	public ParkingRecord(int time, boolean started) {
		this.time = time;
		this.started = started;
	}
}
