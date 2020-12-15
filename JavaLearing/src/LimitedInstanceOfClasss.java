
public class LimitedInstanceOfClasss {
	public static void main(String[] args) {
		try {
			LimitedInstanceClass instance1 = LimitedInstanceClass.getInstance();
			LimitedInstanceClass instance2 = LimitedInstanceClass.getInstance();
			LimitedInstanceClass instance3 = LimitedInstanceClass.getInstance();
			LimitedInstanceClass instance4 = LimitedInstanceClass.getInstance();
			LimitedInstanceClass instance5 = LimitedInstanceClass.getInstance();
			
			System.out.println(instance1);
			System.out.println(instance2);
			System.out.println(instance3);
			System.out.println(instance4);
			System.out.println(instance5);
			
			LimitedInstanceClass instance6 = LimitedInstanceClass.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		LimitedInstanceClassEnum enumInstance1 = LimitedInstanceClassEnum.INSTANCE1;
		LimitedInstanceClassEnum enumInstance2 = LimitedInstanceClassEnum.INSTANCE2;
		LimitedInstanceClassEnum enumInstance3 = LimitedInstanceClassEnum.INSTANCE3;
		LimitedInstanceClassEnum enumInstance4 = LimitedInstanceClassEnum.INSTANCE4;
		LimitedInstanceClassEnum enumInstance5 = LimitedInstanceClassEnum.INSTANCE5;
		
		System.out.println(enumInstance1.hashCode());
		System.out.println(enumInstance2.hashCode());
		System.out.println(enumInstance3.hashCode());
		System.out.println(enumInstance4.hashCode());
		System.out.println(enumInstance5.hashCode());
	}
}

class LimitedInstanceClass{
	public static int instanceCount = 0;
	public static LimitedInstanceClass instance;
	
	private LimitedInstanceClass() {
		
	}
	
	public static LimitedInstanceClass getInstance() throws Exception {
		if(instanceCount < 5) {
			instanceCount++;
			return new LimitedInstanceClass();
		}else {
			throw new Exception("Cannot create more than 5 instance of class");
		}
	}
}
