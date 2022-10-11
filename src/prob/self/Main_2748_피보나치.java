package prob.self;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2748_피보나치 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] dp = new long[N+1];
		dp[0] = 0;
		if (N!=0) dp[1] = 1;
		for (int i=2; i<=N; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[N]);
				
		
	}

}
