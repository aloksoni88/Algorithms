
public class TimeDiff {
	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis();
        long timeDiff =  currentTime - 1579160693000l;
        long DIFF_TIME = 1000 * 60 * 60 * 24 ;
        int noOfDays = (int)(timeDiff/DIFF_TIME);
        System.out.println(noOfDays);
	}
}
