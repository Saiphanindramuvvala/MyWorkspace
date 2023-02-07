import java.util.Optional;
import java.util.function.Predicate;

public class optMain {

	public static void main(String[] args) {
		
		//Optional example
		String[] array = new String[10]; 
		array[1]="hello";
		Optional<String> lOptional= Optional.ofNullable(array[1]);
//		if(lOptional.isPresent()) {
//			System.out.println("value assigned to variable: ");
//		}
//		else {
//			System.out.println("value not assigned to variable: ");
//		}
		lOptional.ifPresentOrElse(s->System.out.println("exist"), ()-> System.out.println("no value exist"));
		
		//predicate example
		Predicate<Integer> pre= i-> i<=20;
		System.out.println(pre.test(100));

	}

}
