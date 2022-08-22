package prob.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_algorithm15_1697_숨바꼭질 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100_001];
		Arrays.fill(dp, -1);
//		for (int i = 0; i < 100_001; i++)
//			dp[i] = -1;
		
		dp[N] = 0;
		dq.offer(N);
		
		while (true) {
			int cur = dq.poll();
			
			// 기저 조건
			if (cur == M)
				break;
			
			// -1, +1, *2
			if (cur-1>=0 && dp[cur-1] == -1) {
				dp[cur-1] = dp[cur]+1;
				dq.offer(cur-1);
			}
			if (cur+1<=100_000 && dp[cur+1] == -1) {
				dp[cur+1] = dp[cur]+1;
				dq.offer(cur+1);
			}
			if (cur*2<=100_000 && dp[cur*2] == -1) {
				dp[cur*2] = dp[cur]+1;
				dq.offer(cur*2);
			}
			
//			System.out.println(dq);
			
		}
		
		System.out.println(dp[M]);
		
	}

}
