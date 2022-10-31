package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동_SK_g5 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j< N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
		int[] dc = {0, 1, 0, -1};
		
//		for (int[] a: map)
//			System.out.println(Arrays.toString(a));
		
		Deque<int[]> dq = new ArrayDeque<>();
		int day = 0;
		int[] cur = new int[2];
		int population = 0;
		boolean flag = true;
		while (flag) {
			flag = false;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					dq.add(new int[] {i, j});
					visited[i][j] = true;
					List<int[]> countryList = new ArrayList<>();
					countryList.add(new int[] {i, j});
					population = map[i][j];
					
					while (!dq.isEmpty()) {
						cur = dq.poll();
						// if (visited[cur[0]][cur[1]]) continue;
						for (int d = 0; d < 4; d++) {
							int nextR = cur[0] + dr[d];
							int nextC = cur[1] + dc[d];
							
							if (0<=nextR && nextR<N && 0<=nextC && nextC<N && !visited[nextR][nextC]) {
								int dif = Math.abs(map[cur[0]][cur[1]]-map[nextR][nextC]);
								if (dif < L || dif > R) continue;
								dq.add(new int[] {nextR, nextC});
								visited[nextR][nextC] = true;
								countryList.add(new int[] {nextR, nextC});
								population += map[nextR][nextC];
								flag = true;
							}
						}
					}
					if (countryList.size()==1) continue;
					int pop = population / countryList.size();
					for (int[] country: countryList) {
						map[country[0]][country[1]] = pop;
					}
				}
			}
			if (flag) day++;
		}
		
		System.out.println(day);
		
			
		
	}

}
