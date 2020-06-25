import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;


public class RemoveWhiteSpace {
	public static void main(String[] args) {
		String str = "Ho.No. 0047      Triveni Park      EON rd wagholi";
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuffer sb = new StringBuffer();
		 
		while(st.hasMoreElements())
		{
		    sb.append(st.nextElement()).append(" ");
		}
		 
		String nameWithProperSpacing = sb.toString();
		 
		System.out.println( nameWithProperSpacing );
		//System.out.println(str.replaceAll("\\s", " "));
	}
}
