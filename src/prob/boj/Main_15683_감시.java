package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<int[]> posCC = new ArrayList<>();
		
		// rr
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // row 열
		int M = Integer.parseInt(st.nextToken()); // col 행
		
		int[][] map = new int[N+2][M+2]; // map arr
		
		for (int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j<M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i<N+2; i++) {
			for (int j = 0; j < M+2; j++) {
				// 6으로 벽 둘러 쌓기
				if (i==0||i==N+1||j==0||j==M+1)
					map[i][j] = 6;
				
				// 1~5 cctv 위치 정하기
				if (1<=map[i][j] && map[i][j]<=5) {
					
				}
			}
		}
		
		
		
		
		
		
	}

}
