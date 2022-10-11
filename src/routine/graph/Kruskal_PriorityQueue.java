package routine.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kruskal_PriorityQueue {
	
	static class Edge implements Comparable<Edge> {
		
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo (Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(from, to, weight));
		}
		
		make();
		
		int cnt = 0, result = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (union(cur.from, cur.to)) {
				result += cur.weight;
				if (++cnt == V-1) break;
			}
		}
		
		System.out.println(result);
		
	}
	
	static void make() {
		parents = new int[V];
		
		for (int i = 0; i < V; i++)
			parents[i] = i;
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 사이클이 형성된다면 false 반환
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
