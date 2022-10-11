package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_계단오르기_SK {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[n+1];
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		if (n==1) {
			ans = stairs[1];
		} else if (n==2) {
			ans = stairs[1]+stairs[2];
		} else {
			dp[1] = stairs[1];
			dp[2] = stairs[1]+stairs[2];
			for (int i = 3; i <= n; i++) {
				dp[i] = Math.max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2]+stairs[i]);
			}
			ans = dp[n];
		}
		System.out.println(Arrays.toString(stairs));
		System.out.println(Arrays.toString(dp));
		
		System.out.println(ans);
		
	}

}
