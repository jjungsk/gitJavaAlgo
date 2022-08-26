package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_MST_prim {
	
	static class Node {
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	// pq
	static class Edge {
		int no, weight;
		
		public Edge(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int u, v, w;
		adjList = new Node[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adjList[u] = new Node(v, w, adjList[u]);
			adjList[v] = new Node(u, w, adjList[v]);
		}
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		int start = 1;
		distance[start] = 0;
		pq = new PriorityQueue<>();
		pq.offer(new int[] {start, 0});
		
		dijkstra();
		
	}
	
	static int V, E, start;
	static int[] distance;
	static boolean[] visited;
	static Node[] adjList;
	static PriorityQueue<int[]> pq;
	
	static void dijkstra() {
		
		// 모든 Vertex를 다 확인
		for (int c = 0; c < V; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			int[] cur = pq.poll();
			
			
		}
	}
	
}
