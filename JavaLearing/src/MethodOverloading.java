
public class MethodOverloading {
	public static void main(String[] args) {
		MethodOverloading over = new MethodOverloading();
		//over.test(null);
	}
	
	private void test(Integer str) {
		System.out.println(str);
	}
	
	private void test(String obj) {
		System.out.println(obj);
	}
}
