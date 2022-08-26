package prob.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_젤다_dijkstra2 {
	
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int problemNo = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			int[][] map = new int[N][N];
			int[][] distance = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			distance[0][0] = map[0][0];
			pq.offer(new int[] {0, 0, distance[0][0]});
			
			while (!pq.isEmpty()) {
				
				int[] cur = pq.poll();
				
				if (cur[0] == N-1 && cur[1] == N-1) break; // 목표지점 도달
				if (distance[cur[0]][cur[1]] < cur[2]) continue; // visited 최적화
				
				for (int d = 0; d < 4; d++) {
					int nextR = cur[0] + dr[d];
					int nextC = cur[1] + dc[d];
					if (nextR < 0 || nextR >= N
							|| nextC < 0 || nextC >= N) continue;
					
					if (distance[nextR][nextC] > distance[cur[0]][cur[1]] + map[nextR][nextC]) {
						distance[nextR][nextC] = distance[cur[0]][cur[1]] + map[nextR][nextC];
						pq.offer(new int[] {nextR, nextC, distance[nextR][nextC]}); // **Point 갱신 전 값을 넣어도 답은 나오지만 시간 미쳤음..
//						pq.offer(new int[] {nextR, nextC, map[nextR][nextC]}); // **Point 갱신 전 값을 넣어도 답은 나오지만 시간 미쳤음..
					}
				}
			}
			
//			for (int[] a: distance)
//				System.out.println(Arrays.toString(a));
			
//			System.out.println(distance[N-1][N-1]);
			sb.append("Problem").append(" ").append(problemNo++).append(": ").append(distance[N-1][N-1]).append("\n");
		} // while문 종료
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
