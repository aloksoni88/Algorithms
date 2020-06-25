
public class FirstNonRepeatedChar {
	public static void main(String[] args){
		String input = "sandeepkumarsoni";
		if(input == null || input.isEmpty()){
			System.out.println("String is null or empty");
		}else if(input.length() == 1){
			System.out.println("there is only 1 char in string, hence first occurance of char is : " + input);
		}else{
			findNonRepeatedOccurance(input);
		}
	}
	
	private static void findNonRepeatedOccurance(String input){
		if(input != null && input.length() > 1){
			String ch = input.charAt(0) +"";
			input = input.substring(1);
			//System.out.println("char : " + ch + " string : " + input);
			if(input.contains(ch)){
				findNonRepeatedOccurance(input);
			}else{
				System.out.println("First occurance of char is : " + ch);
			}
		}
		else if(input.length() == 1){
			System.out.println("No char found");
		}
		
	}
}
