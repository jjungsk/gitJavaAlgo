package prob.self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_day1_1_1012_유기농배추_silver2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[R][C];
			cabbagePos = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				cabbagePos[i][0] = Integer.parseInt(st.nextToken());
				cabbagePos[i][1] = Integer.parseInt(st.nextToken());
			}
			
//			for (int[] a: cabbagePos)
//				System.out.println(Arrays.toString(a));
			
			
			ans = 0;
			bfs();
			
//			System.out.println();
			sb.append(ans+1).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static int R, C, N, ans;
	static int[][] map, cabbagePos;
	static int[] dr = {-1, 0, 1, 0}; // 북동남서
	static int[] dc = {0, 1, 0, -1};
	
	public static void bfs() {
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(cabbagePos[0]);
//		System.out.print(Arrays.toString(cabbagePos[0]));
		cabbagePos[0] = null;
		
		while(!dq.isEmpty()) {
			
			boolean flag = true;
			int[] cur = dq.poll();
			
			loop:
			for (int j = 0; j < N; j++) {
				if (cabbagePos[j] == null) continue;
				for (int i = 0; i < 4; i++) {
					int nextR = cur[0] + dr[i];
					int nextC = cur[1] + dc[i];
					if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || cabbagePos[j] == null) continue;
					if (cabbagePos[j][0] == nextR && cabbagePos[j][1] == nextC) {
						dq.offer(cabbagePos[j]);
//						System.out.print(Arrays.toString(cabbagePos[j]));
						flag = false;
					}
				}
				cabbagePos[j] = null;
			}
			
			
			// dq offer
			if (flag) {
				for (int i = 0; i < N; i++) {
					if (cabbagePos[i] != null) {
						dq.offer(cabbagePos[i]);
//						System.out.println();
//						System.out.println("----------------");
//						System.out.print(Arrays.toString(cabbagePos[i]));
						cabbagePos[i] = null;
						ans++;
						break;
					}
				}
			}
			
		}
		
		
	}
	
	
}
