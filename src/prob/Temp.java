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
<<<<<<< HEAD
	
	private static void sample(int number, int[] num) {
		num[0] += number;
		num[1] += number;
		return;
		
	}
=======

>>>>>>> 09372973d3984ff666fa6092ffea2df0b29cf6f7
	
}

