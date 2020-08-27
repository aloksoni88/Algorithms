import java.util.Arrays;

public class ShallowCopy {
	private int[] data;

	// makes a shallow copy of values
	public ShallowCopy(int[] values) { 
        data = values; 
    }

	public void showData() {
		System.out.println(Arrays.toString(data));
	}

	public static void main(String[] args) {
		int[] vals = {3, 7, 9}; 
		ShallowCopy e = new ShallowCopy(vals); 
        e.showData(); // prints out [3, 7, 9] 
        System.out.println(Arrays.toString(vals));
        vals[0] = 13; 
        e.showData(); // prints out [13, 7, 9] 
        System.out.println(Arrays.toString(vals));
	}
}
