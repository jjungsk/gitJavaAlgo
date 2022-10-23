package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309_동물원_SK {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// (1) 점화식
//		int[] arr = new int[N+1];
//		arr[0] = 1;
//		arr[1] = 3;
//		
//		for (int i = 2; i <= N; i++) {
//			arr[i] = (arr[i-1]*2 + arr[i-2])%9901;
//		}
		
		// (2) DP
		int[][] dp = new int[N+1][3]; // dp[i][0] = 공백, dp[i][1] = 왼쪽, dp[i][2] = 오른쪽
		dp[1][0] = dp[1][1] = dp[1][2] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
			dp[i][1] = dp[i][2] = (dp[i-1][0] + dp[i-1][2]);
		}
		int ans = (dp[N][0]+dp[N][1]+dp[N][2])%9001;
		System.out.println(ans);
		
	}

}
