package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기_SK {
	
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
			
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] mapCa = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		
		boolean[][] visited = new boolean[N][M];
		dq.add(new int[] {0, 0});
		mapCa[0][0] = map[0][0];
		visited[0][0] = true;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			int curC = mapCa[cur[0]][cur[1]];
			
			int nextR = 0, nextC = 0;
			for (int c = 0; c < 2; c++) {
				nextR = cur[0] + dr[c];
				nextC = cur[1] + dc[c];
				if ((nextR < N && nextC < M) && (map[nextR][nextC]+curC > mapCa[nextR][nextC] || !visited[nextR][nextC])) {
					mapCa[nextR][nextC] = map[nextR][nextC]+curC;
					dq.add(new int[] {nextR, nextC});
					visited[nextR][nextC] = true;
				}
			}
		}
		
		System.out.println(mapCa[N-1][M-1]);
	}

}
