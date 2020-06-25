
public class ReverseString {
	
	public static void main(String[] args){
		String str = "alok Soni";
		//System.out.println("Reverse String : " + reverseString(str));
		//System.out.println("Reverse String : " + revereString2(str));
		System.out.println("Reverse String : " + revereString3(str));
	}
	
	
	//using recursion
	private static String reverseString(String str){
		if(str.length() < 2){
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0); 
	}
	
	private static String revereString2(String str){
		char[] arr = str.toCharArray();
		String reverseStr="";
		for(int i=arr.length-1; i>=0; i--){
			reverseStr = reverseStr+arr[i];
		}
		return reverseStr;
	}
	
	private static String revereString3(String str){
		String reverseStr="";
		for(int i=str.length()-1; i>=0; i--){
			reverseStr = reverseStr+str.charAt(i);
		}
		return reverseStr;
	}

}
