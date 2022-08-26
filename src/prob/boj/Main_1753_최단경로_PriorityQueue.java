package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로_PriorityQueue {
	
	static class Node implements Comparable<Node> {
		int vertex, weight;
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); // 1 ~ V
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine()); // 1 ~ V의 start
		
		int u, v, w;
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adjList[u-1].add(new int[] {v-1, w}); // 0 ~ V-1의 index
		}
		
//		for (ArrayList<int[]> a: adjList) {
//			for (int[] b: a) {
//				System.out.print(Arrays.toString(b));
//			}
//			System.out.println();
//		}
		
		// 구현부
		D = new int[V];
		Arrays.fill(D, Integer.MAX_VALUE);
		visited = new boolean[V];
		D[start-1] = 0; // index 0이 시작점이므로 start - 1로 초기화
		
		pq.offer(new Node(start-1, 0));
		
		dijkstra();
		
		for (int i = 0; i < V; i++) {
			if (D[i] != Integer.MAX_VALUE) sb.append(D[i]).append("\n");
			else sb.append("INF").append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	static int V, E, start;
	static int min, minVertex, result;
	static int[] D;
	static ArrayList<int[]>[] adjList;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();

	static void dijkstra() {
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			min = node.weight;
			minVertex = node.vertex;
			
//			if (visited[minVertex]) continue;
//			visited[minVertex] = true;
			if (D[minVertex] < min) continue;
			
			
			for (int[] cur: adjList[minVertex]) {
//				if (!visited[cur[0]] && D[cur[0]] > D[minVertex] + cur[1]) {
				if (D[cur[0]] > D[minVertex] + cur[1]) {
					D[cur[0]] = D[minVertex] + cur[1];
					pq.offer(new Node(cur[0], D[cur[0]]));
				}
			}
			
//			System.out.println(Arrays.toString(D));
			
		}
		
	}
	
}
