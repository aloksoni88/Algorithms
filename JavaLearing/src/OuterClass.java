import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class OuterClass {
	private String str= "alok";
	
	class InnerClass{
		private void test() {
			System.out.println(str);
		}
	}
	enum Planet{
		MERCURY, VENUS, EARTH
	}
	
	public static void main(String[] args) {
		System.out.println(Planet.MERCURY.equals(Planet.MERCURY));
		System.out.println(Planet.MERCURY == Planet.MERCURY);
		System.out.println(Planet.MERCURY == Planet.VENUS);
		
		HashSet<Integer> s = new HashSet<>();
		s.add(new Integer(1));
		s.add(new Integer(1));
		s.add(new Integer(2));
		System.out.println(s.size());
		
		String[] arr = {"f","o","o","bar"};
		String result= StringUtils.concat(arr);
		System.out.println(result);
		
		Sol sol = new Sol();
		int[] a = {7,6,4,3,3,8,4,4,5,6,2,1,9};
		//int[] resultArr = sol.filterDuplicates(a);
		int[] resultArr = sol.removeDuplicates(a, a.length);
		System.out.println(Arrays.toString(resultArr));
	}
}

class StringUtils{
	public static String concat(String[] strings) {
		StringBuilder result = new StringBuilder("");
		for(int i=0; i<strings.length; i++) {
			result.append(strings[i]);
		}
		return result.toString();
	}
}

class Sol {
	
	public static int[] filterDuplicates(int[] data) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<data.length; i++) {
			if(list.isEmpty() || !list.contains(data[i])) {
				list.add(data[i]);
			}
		}
		return list.stream().mapToInt(i-> i).toArray();
	}
	
	public static int[] removeDuplicates(int arr[], int n) 
    { 
        if (n == 0 || n == 1) 
            return arr; 
       
        // To store index of next unique element 
        int j = 0; 
       
        // Doing same as done in Method 1 
        // Just maintaining another updated index i.e. j 
        for (int i = 0; i < n-1; i++) 
            if (arr[i] != arr[i+1]) 
                arr[j++] = arr[i]; 
       
        arr[j++] = arr[n-1]; 
       
        return arr; 
    } 
}


