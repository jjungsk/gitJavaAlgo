package prob.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_algorithm15_1697_숨바꼭질_시간초과 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100_000*2 + 1];
		Arrays.fill(dp, -1);
		
		int time = 0;
		dp[N] = time;
		dq.offer(N);
		
		loop:
		while (dp[M] == -1) {
			int len = dq.size();
			for (int i = 0; i < len; i++) {
				int temp = dq.poll();
				
//				if (temp == M) break loop;
				
				// -1
				if (temp-1 >= 0 && dp[temp-1] == -1) {
					dp[temp-1] = time + 1;
					dq.offer(temp-1);
				}
				// +1
				if (temp+1 <= 100_000*2 && dp[temp+1] == -1) {
					dp[temp+1] = time + 1;
					dq.offer(temp+1);
				}
				// *2
				if (temp*2 <= 100_000*2 && dp[temp*2] == -1) {
					dp[temp*2] = time + 1;
					dq.offer(temp*2);
				}
				
			}
			time++;
			
//			for (int i = 0; i < 21; i++)
//				System.out.print(dp[i] + " ");
//			System.out.println();
		}
		
		System.out.println(dp[M]);
		
	}

}
