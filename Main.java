import java.awt.Choice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		System.out.println("--Sort with other Java and Java 8--");
		List<Integer> numbers = new ArrayList<>();
		numbers.add(324);
		numbers.add(32);
		numbers.add(3234);
		numbers.add(23);
		Collections.sort(numbers, new Sort());
		System.out.println(numbers);

		Collections.sort(numbers);
		System.out.println(numbers);

		
		System.out.println("\n---Stream vs Parallel stream---");
		List<Integer> numbers2 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			Random rd = new Random();
			numbers2.add(rd.nextInt(100000));
		}

		long start = System.nanoTime();
		numbers.stream().sorted();
		long end = System.nanoTime();
		System.out.println("Sort with stream: " + (end - start) + " nano seconds");

		start = System.nanoTime();
		numbers.parallelStream().sorted();
		end = System.nanoTime();
		System.out.println("Sort with parallel stream: " + (end - start) + " nano seconds");
		
		
		System.out.println("\n---List to map---");
		List<Student> students = new ArrayList<>();
		students.add(new Student(2, "tuan"));
		students.add(new Student(34, "michu"));
		students.add(new Student(43, "tester"));
		students.add(new Student(45, "Javascript"));
		
		Map studentsMap =  students.stream().collect(Collectors.toMap(Student::getId, Student::getName));
		System.out.println( "Map: " + studentsMap);
		
		List<Integer> studentKeys = (List<Integer>) studentsMap.keySet().stream().collect(Collectors.toList());
		List<String> studentNames = (List<String>) studentsMap.values().stream().collect(Collectors.toList());
		System.out.println("Keys of map: " + studentKeys);
		System.out.println("Value of map: " + studentNames);

	}
}

class Sort implements Comparator<Integer> {

	@Override	
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}

}
