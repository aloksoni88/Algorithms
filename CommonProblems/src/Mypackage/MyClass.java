package Mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MyClass {
	public static void main(String argv[]) {
		Integer[] arr = {1,2,3,4,5,6,-1,-4,-6,8,5,-2,8};
		
		ArrayList<Integer> list = new ArrayList(Arrays.asList(arr));
		System.out.println(list);
		removeNegative(list);
		System.out.println(list);
		
		System.out.println(n_squares(1000));
		//System.out.println(MyClass.f(Optional.of(3).get().get()));
	}
	
	
   
    
	static String n_squares(int n) {
	    StringBuffer s = new StringBuffer("0");
	    int n_squared = n*n;
	    for (int i=0; i<n_squared; i++) {
	        s.append (", " + i);
	    }
	    return s.toString();
	}

	static void removeNegative(ArrayList<Integer> a) {
	    int i=0;
	    while(i<a.size())
	        if (a.get(i) < 0) 
	            a.remove(i);
	        else
	            i++;
	}
	
}

class C {
	protected static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
}
