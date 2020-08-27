import java.util.Arrays;


public class CloningTest {
	public static void main(String[] args) {
		Emplopyee emp1 = new Emplopyee("Ram", "Contractual");
		System.out.println(emp1);
		try {
			Emplopyee emp2 = (Emplopyee) emp1.clone();
			
			System.out.println(emp2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(emp1);
	}
}


final class Emplopyee implements Cloneable{
	private String empName;
	private String empType;
	private int[] t = {1,2,3,4,5};
	
	public Emplopyee(String empName, String empType) {
		this.empName = empName;
		this.empType = empType;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return empName + ", "+empType + ", " + Arrays.toString(t);
	}
}

