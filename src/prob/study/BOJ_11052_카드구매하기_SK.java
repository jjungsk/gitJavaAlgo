package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11052_카드구매하기_SK {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (j>=i) dp[j] = Math.max(dp[j], dp[j-i]+arr[i]);
			}
//			System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[N]);
	}

}
