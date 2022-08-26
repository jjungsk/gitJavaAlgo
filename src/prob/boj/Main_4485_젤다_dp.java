package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4485_젤다_dp {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N];
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int temp = 0;
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0) {
					temp += map[i][j];
					dp[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(dp));
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == 0) dp[0] += map[i][0];
				else dp[j] = Math.min(dp[j-1], dp[j]) + map[i][j];
			}
			System.out.println(Arrays.toString(dp));
		}
	}

}
