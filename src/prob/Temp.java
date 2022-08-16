package prob;

import java.util.Scanner;

public class Temp {
	
	
	public static void main(String[] args) {

		int ans = recursivePower(2, 10);
		
		System.out.println(ans);
	}
	
	private static int recursivePower(int x, int n) {
		if (n==1)
			return x;
		
		if (n%2 == 0) {
			int temp = recursivePower(x, n/2);
			return temp*temp;
		} else {
			int temp = recursivePower(x, (n-1)/2);
			return temp*temp*x;
		}
	}
	
}