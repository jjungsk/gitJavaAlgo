package prob.self.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_day1_1_1012_유기농배추_silver_bfs {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N];
			cabbagePos = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				cabbagePos[i][0] = Integer.parseInt(st.nextToken());
				cabbagePos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			
			int ans = 0;
			
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					bfs(i);
					ans++;
				}
			}
			
			sb.append(ans).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static int N;
	static int[][] map, cabbagePos;
	static int[] dr = {-1, 0, 1, 0}; // 북동남서
	static int[] dc = {0, 1, 0, -1};
	static boolean[] visited;
	
	public static void bfs(int start) {
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(cabbagePos[start]);
		visited[start] = true;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			for (int k = 0; k < 4; k++) {
				int nextR = cur[0] + dc[k];
				int nextC = cur[1] + dr[k];
				for (int j = 0; j < N; j++) {
					if (!visited[j] && cabbagePos[j][0] == nextR && cabbagePos[j][1] == nextC) {
						dq.offer(cabbagePos[j]);
						visited[j] = true;
					}
				}
			}
			
		}
		
	}
	
	
}
