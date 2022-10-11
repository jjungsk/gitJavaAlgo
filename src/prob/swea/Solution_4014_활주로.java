package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4014_활주로 {
	
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // map 크기
			M = Integer.parseInt(st.nextToken()); // 경사 가로 길이
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// main logic
			int rowCnt = 0;
			int colCnt = 0;
			
			// 가로 탐색
			for (int i = 0; i < N; i++) {
				int leftLen = 1;
				int rightLen = 1;
				boolean est = true;
				for (int j = 1; j < N; j++) {
					if (Math.abs(map[i][j-1] - map[i][j]) > 1) { // 높이 차가 2 이상인 경우 제외
						est = false;
						break;
					}
					
					if (map[i][j-1] == map[i][j]) {
						++leftLen;
					} else { // 높이 차가 다르다면
						if (map[i][j-1] < map[i][j]) { // 왼쪽이 더 작다면
							if (leftLen < M) {
								est = false;
								break;
							}
							leftLen = 1;
						} else { // 오른쪽이 더 작다면
							rightLen = 1;
							for (int k = j+1; k < N; k++) {
								if (map[i][k] != map[i][j]) break;
								++rightLen;
							}
//							System.out.println(j + " : " + rightLen);
							if (rightLen < M) {
								est = false;
								break;
							}
						}
					}
				}
				if (est) {
					System.out.println("row : " + (i+1));
					++rowCnt;
				}
			}
			
			System.out.println();
			
			// 세로 탐색
			for (int j = 0; j < N; j++) {
				int leftLen = 1;
				boolean est = true;
				boolean first = true;
				for (int i = 1; i < N; i++) {
					if (Math.abs(map[i-1][j] - map[i][j]) > 1) { // 높이 차가 2 이상인 경우 제외
						est = false;
						break;
					}
					
					if (map[i-1][j] == map[i][j]) {
						++leftLen;
					} else { // 높이 차가 다르다면
						if (map[i-1][j] < map[i][j]) { // 왼쪽이 더 작다면
							if (leftLen < M) {
								est = false;
								break;
							}
							leftLen = 1;
						} else { // 오른쪽이 더 작다면
							int rightLen = 1;
							for (int k = i+1; k < N; k++) {
								if (map[k][j] != map[i][j]) break;
								++rightLen;
							}
//							System.out.println(j + " : " + rightLen);
							if (rightLen < M) {
								est = false;
								break;
							}
						}
					}
				}
				if (est) {
					System.out.println("col : " + (j+1));
					++colCnt;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(rowCnt+colCnt).append("\n");
			
		} // 모든 tc 종료문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
