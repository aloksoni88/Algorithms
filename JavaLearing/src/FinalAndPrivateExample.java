
public class FinalAndPrivateExample extends SuperClass{
	
	//gives compiler error as you cannot overide the final method
//	public void myFinalMethod() {
//		
//	}
	
	//call this method if subclass object 
	private void myPrivateMethod() {
		System.out.println("My subclass private method");
	}
	
	static void myStaticMethod() {
		
	}
	
	
	public static void main(String[] args) {
		SuperClass superClass = new SuperClass();
		superClass.myFinalMethod();
//		superClass.myPrivateMethod();
		
		
		System.out.println("=============================");
		FinalAndPrivateExample example = new FinalAndPrivateExample();
		example.myFinalMethod();
		example.myPrivateMethod();
		
	
		System.out.println("=============================");
		SuperClass superClass2 = new FinalAndPrivateExample();
		superClass2.myFinalMethod();
//		superClass2.myPrivateMethod();
		
		System.out.println("=============================");
		FinalAndPrivateExample example2 = (FinalAndPrivateExample) superClass2;
		example2.myFinalMethod();
		example2.myPrivateMethod();
	}	
	
}


class SuperClass{
	final void myFinalMethod() {
		System.out.println("My super class final method");
	}
	
	//calls this method if super class object,this is also known method hiding
	private void myPrivateMethod() {
		System.out.println("My super class private method");
	}
	
	static void myStaticMethod() {
		
	}
	
	void myInstanceMethod() {
		
	}
}
