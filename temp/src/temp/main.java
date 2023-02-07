package temp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//class myRun implements Runnable{
//	public void run() {
//		
//	}
//}
public class main {

	public static void main(String[] args) { 
//		Runnable r= ()->{
//			for(int i=0;i<10;i++) {
//				System.out.println("child thread");
//			}
//		};
//		Thread t= new Thread(r);
//		t.start();
//		for(int i=0;i<10;i++) {
//			System.out.println("main thread");
//		}
		ArrayList<Integer> l1= new ArrayList<Integer>();
		l1.add(0);
		l1.add(5);
		l1.add(15);
		l1.add(30);
		l1.add(20);
		l1.add(25);
		l1.add(35);
		l1.add(40);
		l1.add(45);
		l1.add(50);
		l1.add(55);
		l1.add(60);
		l1.add(22);
		l1.add(54);
		l1.add(77);
//		int r= new Random().nextInt();
//		l1.add(r);
//		Generating a random integer with the range nextInt(max-min)+min and adding to list
		Random r= new Random();
		Integer in= r.nextInt(19)+1;
		l1.add(in);
//		getting last element from the list
		int last= l1.stream().reduce((i1,i2)->i2).get();
		System.out.println("last element (random element) of the list is: "+last);
//		Getting sum of list using reduce
		int sum= l1.stream().reduce((i1,i2)->(i1+i2)).get();
		System.out.println("Sum of the list is: "+sum);
		//printing through iterator
		Iterator<Integer> itr= l1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		//printing without iterator
		System.out.println("original list"+l1);
		//printing using stream
		l1.stream().forEach(System.out::println);
		//l1.stream().forEach(s->System.out.println(s));
		//filtering
		long failed= l1.stream().filter(i->i<35).count();
		System.out.println("failed students are:"+failed);
		//filtering failed and adding 5 by map
		List<Integer> l2= l1.stream().filter(i->i<=35).map(i->i+5).collect(Collectors.toList());
		System.out.println("changed list"+l2);
		//ascending order
		List<Integer> sortedList= l1.stream().sorted().collect(Collectors.toList());
		System.out.println("sorted ascending order list is:"+sortedList);
		//descending order
		List<Integer> sortedListDesc= l1.stream().sorted((i1,i2)->(i1<i2)?1:(i1>i2)?-1:0).collect(Collectors.toList());
		System.out.println("sorted descending order list is:"+sortedListDesc);
		
		
		
		PriorityQueue<String> q= new PriorityQueue<String>();
		Object[] nue= new Object[10];
//		nue[0]= new student();
//		nue[1]= new school();
		
		Deque<Integer> dq= new ArrayDeque<Integer>();
		
		
		

	}

}
