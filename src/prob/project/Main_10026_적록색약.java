package prob.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_10026_적록색약 {
	
	private static int N, ordCnt, weakCnt;
	private static final int[] DR = {-1, 0, 0, 1};
	private static final int[] DC = {0, -1, 1, 0};
	private static char[][] map;
	private static boolean[][] ordVisited;
	private static boolean[][] weakVisited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j];
			}
		}
		
		// 구현부
		ordVisited = new boolean[N][N];
		weakVisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!ordVisited[i][j]) {
					char ordColor = map[i][j];
					ordBfs(i, j, ordColor);
					ordCnt++;
				}
				if (!weakVisited[i][j]) {
					char weakColor = map[i][j];
					weakBfs(i, j, weakColor);
					weakCnt++;
				}
			}
		}
		
		sb.append(ordCnt).append(" ").append(weakCnt);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void ordBfs(int i, int j, char startColor) {
		Deque<int[]> dq = new ArrayDeque<>();
		
		dq.add(new int[] {i, j}); // dq 삽입
		ordVisited[i][j] = true; // 시작 color 확인
		
		while (!dq.isEmpty()) {
			int[] temp = dq.poll();
			for (int k = 0; k < 4; k++) {
				int nextR = temp[0] + DR[k];
				int nextC = temp[1] + DC[k];
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
				if (!ordVisited[nextR][nextC] && map[nextR][nextC] == startColor) {
					ordVisited[nextR][nextC] = true;
					dq.add(new int[] {nextR, nextC});
				}
			}
		}
	}
	
	private static void weakBfs(int i, int j, char startColor) {
		Deque<int[]> dq = new ArrayDeque<>();
		
		dq.add(new int[] {i, j}); // dq 삽입
		weakVisited[i][j] = true; // 시작 color 확인
		
		while (!dq.isEmpty()) {
			int[] temp = dq.poll();
			for (int k = 0; k < 4; k++) {
				int nextR = temp[0] + DR[k];
				int nextC = temp[1] + DC[k];
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
				if (startColor == 'B' && !weakVisited[nextR][nextC] && map[nextR][nextC] == startColor) {
					weakVisited[nextR][nextC] = true;
					dq.add(new int[] {nextR, nextC});
				}
				if (startColor != 'B' && !weakVisited[nextR][nextC] && map[nextR][nextC] != 'B') {
					weakVisited[nextR][nextC] = true;
					dq.add(new int[] {nextR, nextC});
				}
			}
		}
	}

}
