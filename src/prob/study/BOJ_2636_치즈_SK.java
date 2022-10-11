package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2636_치즈_SK {
	
	static int N, M;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0}; 
	static int[][] map;
	static boolean[][] visited, visitedC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int cheeseCnt = 0;
		map = new int[N+2][M+2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheeseCnt++;
			}
		}
		int melChe = 0;
		int hour = 0;
		while (cheeseCnt > 0) {
			melChe = meltingCheese();
			cheeseCnt -= melChe;
			hour++;
		}
		sb.append(hour).append("\n").append(melChe);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
//		for (int[] a: map)
//			System.out.println(Arrays.toString(a));
		
	}

	private static int meltingCheese() {
		Deque<int[]> dq = new ArrayDeque<>();
		int melChe = 0;
		dq.add(new int[] {0, 0});
		visited = new boolean[N+2][M+2];
		visited[0][0] = true;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int nextR = 0, nextC = 0;
			for (int c = 0; c < 4; c++) {
				nextR = cur[0] + dr[c];
				nextC = cur[1] + dc[c];
				if ((0<=nextR && nextR <=N && 0<=nextC && nextC<=M)
						&& (map[nextR][nextC] == 0 && !visited[nextR][nextC])) {
					visited[nextR][nextC] = true;
					dq.add(new int[] {nextR, nextC});
				}
				if ((0<=nextR && nextR <=N && 0<=nextC && nextC<=M)
						&& (map[nextR][nextC] == 1 && !visited[nextR][nextC])) {
					visited[nextR][nextC] = true;
					map[nextR][nextC] = 0;
					melChe++;
				}
			}
			
		}
		
		return melChe;
	}

}
