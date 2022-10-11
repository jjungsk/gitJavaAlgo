package prob.self;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_9095_123더하기 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
				
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			if (dp[N]!=0) {
				sb.append(dp[N]).append("\n");
				continue;
			}
			for (int i = 4; i <=N; i++) {
				if (dp[i] != 0) continue;
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			sb.append(dp[N]).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}

}
