import java.util.Arrays;

public class DeepCopy implements Cloneable{
	private int[] data; 
	  
    // altered to make a deep copy of values 
    public DeepCopy(int[] values) { 
        data = new int[values.length]; 
        for (int i = 0; i < data.length; i++) { 
            data[i] = values[i]; 
        } 
    } 

    
    public void showData() { 
        System.out.println(Arrays.toString(data)); 
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }
    
    public static void main(String[] args) { 
        int[] vals = {3, 7, 9}; 
        DeepCopy e = new DeepCopy(vals); 
        e.showData(); // prints out [3, 7, 9]
        System.out.println(Arrays.toString(vals));
        vals[0] = 13; 
        e.showData(); // prints out [3, 7, 9] 
        System.out.println(Arrays.toString(vals));
  
        DeepCopy e2 = new DeepCopy(vals);
        try {
			e2 = (DeepCopy) e.clone();
			e2.showData();
			e2.data[0] = 100;
			e2.showData();
			e.showData();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
        		
      
       // changes in array values will not be  
       // shown in data values.  
    } 
}
