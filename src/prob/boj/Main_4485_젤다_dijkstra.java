package prob.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_젤다_dijkstra {
	
	static class Node {
		int r, c, w;
		public Node (int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}
	
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
			boolean[][] visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			
			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.w - o2.w;
				}
			});
			
			pq.offer(new Node(0,0, map[0][0]));
			distance[0][0] = map[0][0];
			
			while (!pq.isEmpty()) {
				
				Node cur = pq.poll();
				
				if (cur.r == N-1 && cur.c == N-1) break;
				
				if (distance[cur.r][cur.c] < cur.w) continue;
				
				for (int d = 0; d < 4; d++) {
					int nextR = cur.r + dr[d];
					int nextC = cur.c + dc[d];
					if (nextR < 0 || nextR >= N
							|| nextC < 0 || nextC >= N) continue;
					
					if (distance[nextR][nextC] > distance[cur.r][cur.c] + map[nextR][nextC]) {
						distance[nextR][nextC] = distance[cur.r][cur.c] + map[nextR][nextC];
						pq.offer(new Node(nextR, nextC, map[nextR][nextC]));
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
