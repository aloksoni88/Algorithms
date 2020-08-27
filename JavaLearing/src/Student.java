import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
	private String name;
	private HashMap<String, Integer> map;
	
	public HashMap<String, Integer> getMap(){
		return map;
	}
	
	public Student(String name, HashMap<String, Integer> map) {
		this.name = name;
		this.map = map;
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> map1 = new HashMap<>();
		map1.put("Maths", 90);
		map1.put("English", 80);
		map1.put("Science", 95);
		map1.put("Hindi", 92);
		map1.put("Computer", 76);
		Student s1 = new Student("Alok",map1);
		
		
		HashMap<String, Integer> map2 = new HashMap<>();
		map2.put("Maths", 89);
		map2.put("English", 60);
		map2.put("Science", 88);
		map2.put("Hindi", 91);
		map2.put("Computer", 79);
		Student s2 = new Student("Atul",map2);
		
		
		HashMap<String, Integer> map3 = new HashMap<>();
		map3.put("Maths", 76);
		map3.put("English", 97);
		map3.put("Science", 81);
		map3.put("Hindi", 79);
		map3.put("Computer", 94);
		Student s3 = new Student("Rahul",map3);
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		System.out.println();
		Student topper = null;
		int maxScore = Integer.MIN_VALUE;
		for(Student student : studentList) {
			int sum = 0;
			for(int i : student.getMap().values()) {
				sum = sum + i;
			}
			if(sum > maxScore) {
				maxScore = sum;
				topper = student;
			}
		}
		System.out.println("Topper : "+ topper.name + ", " + topper.getMap().keySet() + ", " + topper.getMap().values());
		System.out.println();
		
		List<Integer> integers = Arrays.asList(1, 1, 1);
		Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
		System.out.println(reduced);

		studentList.parallelStream().forEach(student -> printStudent(student));
		
		System.out.println();
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		for(int i : streamIterated.collect(Collectors.toList())) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		Map<HashMap<String, Integer>, List<Student>> val = studentList.stream()
				.collect(Collectors.groupingBy(Student::getMap));
		System.out.println(val);
		 
		
	}
	
	private static Comparator comparing(Collection<Integer> values) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void printStudent(Student student) {
		System.out.println(student.name + " " + student.map.keySet() + ", " + student.map.values());
	}
}

class Subject{
	private String subName;
}
