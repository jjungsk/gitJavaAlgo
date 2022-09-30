package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1600_원숭이 {
	
	static int ans = Integer.MAX_VALUE;
	static int K;
	static int n, m;
	static List<Integer> result;
	static int[][] map, del1, del2;
	static boolean[][][] visited;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		dq = new LinkedList<int[]>();
		
		K = Integer.parseInt(br.readLine()); // 3칸 이동할 수 있는 횟수
		
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n+2][m+2];
		visited = new boolean[n+2][m+2][K+1];
		
		for (int i = 0; i < n+2; i++) {
			for (int j = 0; j < n+2; j++) {
				map[i][j] = 1;
			}
		}
		for (int i =1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j= 1; j <=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		del1 = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
		del2 = new int[][]{{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}};
		
		bfs();
		
		
		if (result.isEmpty()) {
			System.out.println(-1);
		} else {
			Integer ans = result.get(0);
			for (int i = 1; i < result.size(); i++) {
				ans = Math.min(ans, result.get(i));
			}
			System.out.println(ans);
		}
		

		
	}

	private static void bfs() {
		result = new ArrayList<>();
		dq.add(new int[] {1,1,0,0}); // start pos i, start pos j, dist, cnt
		
		while (!dq.isEmpty()) {
			int[] temp = dq.poll();
			int curPosI = temp[0];
			int curPosJ = temp[1];
			int dist = temp[2];
			int cnt = temp[3];
			visited[curPosI][curPosJ][cnt] = true;
			if (curPosI==n && curPosJ==m) {
				result.add(dist);
			}
			
			for (int[] next: del1) { // 인접 
				int nextI = curPosI + next[0];
				int nextJ = curPosJ + next[1];
				if (1<=nextI && nextI<=n && 1<=nextJ&&nextJ<=m && !visited[nextI][nextJ][cnt] && map[nextI][nextJ]==0) {
					dq.add(new int[] {nextI, nextJ, dist+1, cnt});
				}
			}
			
			if (cnt < K) {
				for (int[] next: del2) { // 나이트
					int nextI = curPosI + next[0];
					int nextJ = curPosJ + next[1];
					if (1<=nextI && nextI<=n && 1<=nextJ&&nextJ<=m && !visited[nextI][nextJ][cnt] && map[nextI][nextJ]==0) {
						dq.add(new int[] {nextI, nextJ, dist+1, cnt+1});
					}
				}
			}
			
			
		}
		
	}


}
