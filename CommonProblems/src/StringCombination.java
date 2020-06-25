import java.util.HashSet;
import java.util.Set;


public class StringCombination {
	static Set<String> set;
	public static void main(String[] args){
		String str = "abc";
		set = new HashSet<String>();
		stringCombination(str,"",str.length(),3);
		System.out.println(set);
	}

	private static void stringCombination(String str, String prefix,int length, int k) {
	
		if(k == 0)
		{
			set.add(prefix);
			return;
		}
		
		for(int i=0; i< length; i++){
			String newPrefix = prefix + str.charAt(i);
			//System.out.println(prefix + " " + str.charAt(i)+ " " + str.substring(i+1));
			stringCombination(str, newPrefix, length,k-1);
		}
	}
}
