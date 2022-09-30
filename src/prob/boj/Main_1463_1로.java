package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		
		int[] dp = new int[target+1];
		
		for (int i=2; i <= target; i++) {
			dp[i] = target;
			if (i%3==0) dp[i] = Math.min(dp[i/3]+1, dp[i]);
			if (i%2==0) dp[i] = Math.min(dp[i/2]+1, dp[i]);
			dp[i] = Math.min(dp[i-1] + 1, dp[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[target]);
		
		
	}

}
