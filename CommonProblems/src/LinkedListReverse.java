import java.util.LinkedList;


public class LinkedListReverse {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<10; i++){
			list.add(i);
		}
		System.out.println(reverse(list));
	}
	
	private static LinkedList<Integer> reverse(LinkedList<Integer> list){
		if(list == null || list.isEmpty()){
			return new LinkedList();
		}
		LinkedList<Integer> reverseList = new LinkedList<Integer>();
		for(int i=list.size()-1; i>=0; i--){
			reverseList.add(list.get(i));
		}
		return reverseList;
	}
}
