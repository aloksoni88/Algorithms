
public class StringReverseUsingRecurssion {
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(reverseString(str));
	}
	
	private static String reverseString(String str) {
		return reverse(str, str.length()-1, new StringBuffer());
		//return reverse(str, str.length()-1, "");
	}
	
	private static String reverse(String str, int len, StringBuffer result) {
		if(len < 0) {
			return "";
		}
		result = result.append(str.charAt(len));
		//System.out.print(str.charAt(len));
		reverse(str, len-1, result);
		return result.toString();
	}
	
}
