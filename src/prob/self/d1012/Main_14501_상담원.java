package prob.self.d1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14501_상담원 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N+1];
		int[] pay = new int[N+1];
		int[] dp = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N; i > 0; i--) {
			if (i+time[i]-1 > N) dp[i] = dp[i+1];
			else dp[i] = Math.max(dp[i+1], pay[i] + dp[i+time[i]]);
			System.out.println(Arrays.toString(dp));
		}
		System.out.println("------------");
		dp = new int[N+2];
		for (int i = N; i > 0; i--) {
			if (i+time[i]-1 > N) continue;
			dp[i] = Math.max(dp[i+1], pay[i] + dp[i+time[i]]);
			System.out.println(Arrays.toString(dp));
		}
		
		
	}

}
