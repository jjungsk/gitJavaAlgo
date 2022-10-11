package prob.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_algorithm22_1149_RGB거리 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][3];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dp[i][0] = Integer.parseInt(st.nextToken());
			dp[i][1] = Integer.parseInt(st.nextToken());
			dp[i][2] = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i-1][1]+dp[i][0], dp[i-1][2]+dp[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+dp[i][1], dp[i-1][2]+dp[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+dp[i][2], dp[i-1][1]+dp[i][2]);
		}
		

		int ans = Math.min(dp[n][0], dp[n][1]);
		ans = Math.min(ans, dp[n][2]);
		
		System.out.println(ans);
		
	}

}
