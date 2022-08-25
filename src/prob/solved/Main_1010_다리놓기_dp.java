package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1010_다리놓기_dp {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		int[] dp = new int[31];
		int memoM = 0;
		
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for (int i = memoM+1; i<=M;i++) {
				for (int j=i; j>=2; j--) {
					dp[j] = dp[j] + dp[j-1];
				}
				dp[1] = i;
//				System.out.println(Arrays.toString(dp));
			}
			sb.append(dp[N]).append("\n");
			
			memoM = M;
			
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
		
		
		
	}

}
