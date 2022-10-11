package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1249_보급로 {
	
	static int N;
	static int[][] map, dist;
	static int INF = Integer.MAX_VALUE;
	static int[] dr = {0, 1, 0, -1}; // 동 남 서 북
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				char[] temp = str.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j]-48;
					dist[i][j] = INF;
				}
			}
			
			
			int ans = bfs();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
			
		} // 모든 tc 종료문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static int bfs() {
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {0, 0});
		dist[0][0] = map[0][0];
		
		int[] curPos;
		int nextI, nextJ;
		while (!dq.isEmpty()) {
			
			curPos = dq.poll();
			for (int i = 0; i < 4; i++) {
				nextI = curPos[0] + dr[i];
				nextJ = curPos[1] + dc[i];
				
				if ((0<=nextI && nextI<N && 0<=nextJ && nextJ<N)&&
						(dist[nextI][nextJ]==INF || dist[curPos[0]][curPos[1]]+map[nextI][nextJ]<dist[nextI][nextJ])) {
					dq.add(new int[] {nextI, nextJ});
					dist[nextI][nextJ] = dist[curPos[0]][curPos[1]]+map[nextI][nextJ];
					
				}
			}
			
			
		}
		
		return dist[N-1][N-1];
	}

}
