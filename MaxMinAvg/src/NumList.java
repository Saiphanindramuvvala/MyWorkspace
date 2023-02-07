import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumList {

	public static void main(String[] args) {
		 

		        // creating a stream
		        IntStream stream = IntStream.of(-9, -18, 54, 8, 7, 14, 3, 13, 15, -10);
		        Stream<Integer> stream2= Stream.of(1,2,3,4,5,6,7,8,9,0);
		        try {
		        OptionalDouble avg= stream.average();
		        OptionalInt max= stream.max();
		        Integer sum= stream.sum();
		        OptionalInt min= stream.min();
		        System.out.println("min value from the set is: "+min);
		        System.out.println("max value from the set is: "+max);
		        System.out.println("total value from the set is: "+sum);
		        System.out.println("average value from the set is: "+avg);
		        }
		        catch(IllegalStateException e) {
		        	System.out.println(e);
		        }

		    }

}
