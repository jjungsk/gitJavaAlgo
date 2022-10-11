package routine.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim_adjMatrix {
	
	static class Node implements Comparable<Node> {
		int no, weight;
		
		public Node(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
		@Override
		public int compareTo (Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] distance = new int[N];
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			distance[i] = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		
		// 초기화
		int start = 0;

		distance[start] = 0;
		pq.offer(new Node(start, distance[start]));
		
		// 구현
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			// break 조건 얘를 들어 특정 시점에 도달했을때
			
			if (distance[cur.no] < cur.weight) continue;
			
			for (int i = 0; i < N; i++) {
				if (adjMatrix[cur.no][i] != 0 && distance[i] > distance[cur.no] + adjMatrix[cur.no][i]) {
					distance[i] = distance[cur.no] + adjMatrix[cur.no][i];
					pq.offer(new Node(i, distance[i]));
				}
			}
		}
		
		System.out.println(Arrays.toString(distance));
		
		
		
	}

}
