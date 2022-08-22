package prob;

import java.util.Arrays;

public class Temp {
	
	
	public static void main(String[] args) {
		
		int[] num = {1,2};
		sample(2, num);
		
		System.out.println(num[0]);
		System.out.println(num[1]);


				
	
	}
	
	private static void sample(int number, int[] num) {
		num[0] += number;
		num[1] += number;
		return;
		
	}
	
}

