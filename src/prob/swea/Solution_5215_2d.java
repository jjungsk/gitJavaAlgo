package prob.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_2d {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		
		for (int tc = 1; tc < T+1; tc++) {
			
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // N개 메뉴
			int L = Integer.parseInt(st.nextToken()); // 최대 칼로리 값
			
			int[] vi = new int[N+1]; // 점수
			int[] wi = new int[N+1]; // 칼로리
			
			int[] dp = new int[L+1];
			
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				vi[i] = Integer.parseInt(st.nextToken());
				wi[i] = Integer.parseInt(st.nextToken());
			}
			
			// 구현부
			for (int j = 1; j<=N; j++) {
				for (int i = L; i>=wi[j]; i--) {
					dp[i] = Math.max(dp[i], dp[i-wi[j]]+vi[j]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[L]).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
