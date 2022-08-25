package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_7576_토메이로 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dq = new ArrayDeque<>();
		map = new int[M][N];
		day = new int[M][N];
		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				day[i][j] = -1;
				if (map[i][j] == 1) {
					dq.offer(new int[] {i, j});
					day[i][j] = 0;
				}
				if (map[i][j] == -1)
					day[i][j] = 0;
			}
		}
		
		bfs();
		
		boolean unRip = false;
		loop:
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				if (day[i][j] == -1) {
					unRip = true;
					break loop;
				}
		}
		
//		for (int[] a: map)
//			System.out.println(Arrays.toString(a));
//		System.out.println("---------------");
//		for (int[] a: day)
//			System.out.println(Arrays.toString(a));
		
		if(unRip)
			System.out.println(-1);
		else
			System.out.println(maxDay);
		
	}

	private static int N, M, maxDay;
	private static int[][] map, day;
	private static Deque<int[]> dq;
	
	private static void bfs() {
		int[] dR = {0, -1, 0, 1};
		int[] dC = {-1, 0, 1, 0};
		
		
		while(!dq.isEmpty()) {
			int[] rippedTomato = dq.poll();
			for (int i = 0; i < 4; i++) {
				int nextTomatoR = rippedTomato[0] + dR[i];
				int nextTomatoC = rippedTomato[1] + dC[i];
				if (nextTomatoR < 0 || nextTomatoR >= M
						|| nextTomatoC < 0 || nextTomatoC >= N) continue;
				if (day[nextTomatoR][nextTomatoC] == -1
						&& map[nextTomatoR][nextTomatoC] == 0) {
					day[nextTomatoR][nextTomatoC] = day[rippedTomato[0]][rippedTomato[1]] + 1;
					maxDay = Math.max(maxDay, day[nextTomatoR][nextTomatoC]);
					dq.offer(new int[] {nextTomatoR, nextTomatoC});
				}
			}
		}
		
	}
	
}
