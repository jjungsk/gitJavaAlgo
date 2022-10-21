package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임_SK_g5 {
	
	static int N, M;
	static int[][] ladders, snakes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ladders = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ladders[i][0] = Integer.parseInt(st.nextToken());
			ladders[i][1] = Integer.parseInt(st.nextToken());
		}
		
		snakes = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			snakes[i][0] = Integer.parseInt(st.nextToken());
			snakes[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = dp[1] = 0;
//		for (int i = 2; i <= 7; i++) {
//			if (isLadder(i) == -1) {
//				dp[i] = 1;
//				continue;
//			}
//			dp[i] = 1;
//			dp[isLadder(i)] = 1;
//		}
		
		int curIdx = 2;
		while (curIdx != 101) {
			int minDp = Integer.MAX_VALUE;
			for (int j = curIdx-1; j >= curIdx-6; j--) {
				if (j <= 0) continue;
				minDp = Math.min(minDp, dp[j]);
			}
			
			dp[curIdx] = Math.min(dp[curIdx], minDp + 1);
			// 사다리가 있을 때
			if (isLadder(curIdx) != -1) {
				int ladderIdx = isLadder(curIdx);
				dp[ladders[ladderIdx][1]] = Math.min(dp[ladders[ladderIdx][1]], dp[curIdx]);
			}
			// 뱀이 있을 때
			if (isSnake(curIdx) != -1) {
				int snakeIdx = isSnake(curIdx);
				dp[snakes[snakeIdx][1]] = Math.min(dp[snakes[snakeIdx][1]], dp[curIdx]);
				snakes[snakeIdx][0] = -100; // 방문 처리
				curIdx = snakes[snakeIdx][1];
			}
			curIdx++;

		}
		
//		for (int i = 1; i <= 20; i++)
//			System.out.print(dp[i] + " ");
//		System.out.println();
		System.out.println(dp[100]);
		
		
	}
	
	static int isLadder(int cur) {
		for (int i = 0; i < N; i++) {
			if (ladders[i][0] == cur) return i;
		}
		return -1; // 사다리가 없을 때
	}

	static int isSnake(int cur) {
		for (int i = 0; i < M; i++) {
			if (snakes[i][0] == cur) return i;
		}
		return -1; // 뱀이 없을 때
	}
}
