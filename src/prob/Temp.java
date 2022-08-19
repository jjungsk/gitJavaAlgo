package prob;

import java.util.ArrayDeque;
import java.util.Deque;

public class Temp {
	
	
	public static void main(String[] args) {
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		dq.offer(1);
		dq.offer(2);
		dq.offer(3);
		dq.offer(4);
		
		System.out.println(dq);
		
		int temp1 = dq.poll();
		System.out.println(temp1);
		System.out.println(dq);


				
	
	}

	
}