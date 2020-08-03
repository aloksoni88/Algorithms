import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int processArray(ArrayList<Integer> array) {
        /* 
         * Do not make any changes outside this method.
         *
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the size of the
         * array. 
         *
         * Do not print anything in this method
         *
         * Submit this entire program (not just this function)
         * as your answer
         */
    	
    	
    	if (array == null || array.isEmpty()) {
			return 0;
		} else if (array.size() == 1) {
			return 1;
		}

		int count100 = 0;
		int currIdx = 0;
		while(currIdx < array.size()) {
			if (array.get(currIdx) >= 100) {
				count100++;
				array.remove(currIdx);
			} else if(array.get(currIdx) < 100 && count100 > 0){
				array.add(currIdx, count100);
				count100 = 0;
				currIdx = currIdx+2;
			}else {
				currIdx++;
			}
		}
		if(count100 != 0) {
			array.add(currIdx,count100);
		}
        return array.size();
    }

    public static void main (String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0) 
                break;
            arrayList.add(new Integer(num));
        }
        int new_length = processArray(arrayList);
        for(int i=0; i<new_length; i++)
            System.out.println(arrayList.get(i));
    }
}