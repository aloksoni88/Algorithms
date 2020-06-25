
public class FibonacciSeries {
	public static void main(String[] args){
		int n = 12;
		System.out.println("Fibonacci series for number is: ");
		System.out.println(fibonacci(n) + ", ");
	
	}
	
	private static int fibonacci(int number){
		if(number == 1 || number == 2){
			return 1;
		}else{
			return fibonacci(number-1) + fibonacci(number-2); 
		}
	}
}
