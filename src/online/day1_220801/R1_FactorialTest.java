package online.day1_220801;

import java.util.Scanner;

public class R1_FactorialTest {
	static int factorial1(int n) {
		// 5 4 3 2 1
		int res = 1;
		
		for (int i = n; i >= 1; i--) {
			res *= i;
		}
		return res;
	}
	
	static int res = 1;
	static void factorial2(int i) {
		if (i < 1) return;
		
		res *= i;
		factorial2(i-1);
//		int res = 1;
//		if (i > 1) {
//			res = i * factorial2(i-1);
//			return factorial2(i-1);
//		}
//		else
//			return res;
	}
	
	static int factorial3(int n) { // n! 계산
		return n * factorial3(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial1(N));
		factorial2(N);
		System.out.println(res);
		System.out.println(factorial3(N));
		
	}

}
