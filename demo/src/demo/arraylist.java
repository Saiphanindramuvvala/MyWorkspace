package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class arraylist {

	public static void main(String[] args) {
		
		//arraylist red blue "" green ""
		//remove empty
		//convert uppercase
		List<String> ar= Arrays.asList("red", "blue", "", "green", "");
		
		List<String> l1= ar.stream().map(a->a.toUpperCase()).filter(a->a!= "").collect(Collectors.toList());
		System.out.println(l1);
		
		List<Integer> num= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer l2= num.stream().max((i1,i2)-> i1.compareTo(i2)).get();
		Integer l3= num.stream().min((i1,i2)-> i1.compareTo(i2)).get();
		System.out.println("min value:"+l2);
		System.out.println("max value:"+l3);
		//another way to print min and max using collections
		System.out.println(Collections.max(num));
        System.out.println(Collections.min(num));
		long l4= num.stream().count();
		System.out.println("count:"+l4);
//		Long l5= num.stream().collect(Collectors.averagingInt());

	}

}
