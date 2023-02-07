import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Student{
	int id;

	public Student(int id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id;
	}
	
	
}
public class Example {

	public static void main(String[] args) {
		
		
		Student std1= new Student(1);
		Student std2= new Student(1);
		
		Map<Student, String> stdMap= new HashMap<Student, String>(1);
		stdMap.put(std1, "phani");
		stdMap.put(std2, "phani");
		
//		stdMap.put(new Student(1), "phani");
		
		System.out.println(stdMap.size());
		
		System.out.println(stdMap);
		
		System.out.println(stdMap.entrySet());

		
		Integer i1= new Integer(1);
		Integer i2= new Integer(1);
		Map<Integer, String> intMap= new HashMap<Integer, String>();
		intMap.put(i1, "phani");
		intMap.put(i2, "phani");
		System.out.println(intMap.size());
		


	}

}
