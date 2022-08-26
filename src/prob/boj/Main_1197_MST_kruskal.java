package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_MST_kruskal {
	
	static class Node implements Comparable<Node> {
		int u, v, w;
		public Node(int u, int v, int w) {
			super();
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
//		pq = new PriorityQueue<>();
		nodes = new Node[E];
		
		int u, v, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(u, v, w);
		}
		
		
		// kruskal (union-find) 구현
		visited = new boolean[V+1];
		Arrays.sort(nodes);
		
		make();
		int total = 0;
		for (int i = 0; i < E; i++) {
			Node cur = nodes[i];
			if (union(cur.u, cur.v)) {
				total += cur.w;
			}
		}
		System.out.println(total);
		
	}
	
	static int V, E;
	static int[] parents;
	static boolean[] visited;
//	static PriorityQueue<Node> pq;
	static Node[] nodes;

	static void make() {
		parents = new int[V+1];
		
		for (int i = 1; i <= V; i++)
			parents[i] = i;
	}
	
	static int find(int a) {
		if (a == parents[a]) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
