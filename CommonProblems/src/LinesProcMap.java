/* 
 * Save this in a file called Main.java and compile it. To test it 
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* Do not add a package declaration */
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */
public class LinesProcMap {
    public static Map<String,Integer> processData(ArrayList<String> array) {
       if(array == null || array.isEmpty()) {
    	   new HashMap<>();
       }
       List<Employee> empList = new ArrayList<Employee>();
       for(int i=0; i<array.size(); i++) {
    	   String str = array.get(i);
    	   String[] strArr = str.split(",");
    	   int id = Integer.parseInt(strArr[0]);
    	   String name = strArr[1];
    	   String dept = strArr[2];
    	   float salary = Float.parseFloat(strArr[3]);
    	   Employee emp = new Employee(id,name,dept,salary);
    	   empList.add(emp);
       }
       
       Collections.sort(empList, (Employee emp1, Employee emp2) ->
       		emp2.getSalary().compareTo(emp1.getSalary()));
       
//       empList = empList.stream().filter(salary1 -> salary1.getSalary() > 1600000.0).collect(Collectors.toList());
//       System.out.println("==");
//       System.out.println(empList);
       
       Collections.sort(empList);
       System.out.println(empList);
       
       Map<String,Integer> retVal = new HashMap<String,Integer>();
       if(!empList.isEmpty()) {
    	   for(int i=0; i<empList.size(); i++) {
    		   if(!retVal.containsKey(empList.get(i).getDept())) {
    			   retVal.put(empList.get(i).getDept(), empList.get(i).getId());
    		   }
    	   }
       }  
//       System.out.println(retVal);
       return retVal;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String,Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}

class Employee implements Comparable<Employee>{
	private Integer id;
	private String name;
	private String dept;
	private Float salary;
	
	public Employee(Integer id, String name, String dept, Float salary) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * @return the salary
	 */
	public Float getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return id + ", " + name + ", " + dept + ", " + salary +"\n";
	}
	
//	@Override
//	public int compareTo(Employee o) {
//		return Comparator.comparing(Employee::getName)
//	              .thenComparing(Employee::getDept)	
//	              .thenComparing(Employee::getSalary)
//	              .compare(this, o);
//	}
	
	@Override
	public int compareTo(Employee emp) {
	    int i = name.compareTo(emp.name);
	    if (i != 0) return i;

	    i = dept.compareTo(emp.dept);
	    if (i != 0) return i;

	    return Float.compare(salary, emp.salary);
	}
	
}
