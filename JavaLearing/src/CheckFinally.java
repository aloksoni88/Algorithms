
public class CheckFinally {
	public static void main(String[] args) {
		System.out.println(test());
		
	}
	
	private static int test() {
		try {
			int a = 10/0;
		}catch (Exception e) {
			return 1;
		}finally {
			System.out.println("finally");
		}
		return 0;
		
//		try {
//			int a = 10/0;
//		}catch (Exception e) {
//			return 1;
//		}finally {			
//			return 10;
//		}
	}
}
