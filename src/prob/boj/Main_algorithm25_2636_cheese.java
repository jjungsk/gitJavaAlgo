package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_algorithm25_2636_cheese {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<int[]> dq;
		Deque<int[]> listDelete;
		List<Integer> listCnt = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int cheeseCnt = 0;
		int[][] map = new int[R+2][C+2];
		
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) ++cheeseCnt;
			}
		}
		map[0][0] = 9;
		
		
		int[] dr = {0, 1, 0, -1}; // 동 남 서 북
		int[] dc = {1, 0, -1, 0};
		
		while(cheeseCnt > 0) {
			dq = new ArrayDeque<>();
			listDelete = new ArrayDeque<>();
			boolean[][] visited = new boolean[R+2][C+2];
			int tempCnt = 0;
			
			dq.addFirst(new int[] {0, 0});
			
			while(!dq.isEmpty()) {
				int[] chee = dq.pollFirst();
				visited[chee[0]][chee[1]] = true;
						
				if (map[chee[0]][chee[1]] == 9) {
					for (int d = 0; d < 4; d++) {
						int nextR = chee[0] + dr[d];
						int nextC = chee[1] + dc[d];
						if (0<=nextR && nextR<R+2 && 0<=nextC && nextC<C+2 && map[nextR][nextC]==9 && !visited[nextR][nextC]) {
							dq.addFirst(new int[] {nextR, nextC});
							continue;
						}
						if (0<=nextR && nextR<R+2 && 0<=nextC && nextC<C+2 && map[nextR][nextC]==0 && !visited[nextR][nextC]) {
							dq.addFirst(new int[] {nextR, nextC});
							map[nextR][nextC] = 9;
						} 
						if (0<=nextR && nextR<R+2 && 0<=nextC && nextC<C+2 && map[nextR][nextC]==1 && !visited[nextR][nextC]) {
							visited[nextR][nextC] = true;
							++tempCnt;
							listDelete.addFirst(new int[] {nextR, nextC});
						}
					}
				}
			}
			

			while(!listDelete.isEmpty()) {
				int[] cur = listDelete.pollFirst();
				map[cur[0]][cur[1]] = 0;
			}
			listCnt.add(tempCnt);
			cheeseCnt -= tempCnt;
			
		} // while문 종료
				
		
		int len = listCnt.size();
		System.out.println(len);
		System.out.println(listCnt.get(len-1));
		
	}

}
