package prob.self.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1003_피보나치 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[41][2]; // dp[i][0] = 0의 갯수, dp[i][1] = 1의 갯수
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int tc = 1; tc <= T; tc++ ) {
			
			int n = Integer.parseInt(br.readLine());
			
			if (dp[n][0]!=0 && dp[n][1]!=0) {
				sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
				continue;
			}
			
			for (int i = 2; i <= n; i++) {
				dp[i][0] = dp[i-1][0] + dp[i-2][0];
				dp[i][1] = dp[i-1][1] + dp[i-2][1];
			}
			
			sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
