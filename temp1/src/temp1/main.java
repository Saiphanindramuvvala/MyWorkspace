package temp1;

import java.util.HashMap;
import java.util.function.Predicate;

interface Addition{
	public void add(int a, int b);
}

public class main {

	public static void main(String[] args) {
		Addition ab= (a, b)->System.out.println("addition is:"+(a+b));
		ab.add(10, 20);
		
		HashMap<String, String> hm= new HashMap<String, String>();
		hm.put("a", "a");
		hm.put("b", "b");
		hm.put("z", "z");
		hm.put("c", "c");
		System.out.println(hm);
		
		Predicate<Integer> pre= a-> (a>=10);
		System.out.println(pre.test(11));
	}
}
