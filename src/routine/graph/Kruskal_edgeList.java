package routine.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal_edgeList {
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static int[] parents;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 각 간선 및 가중치에 대한 정보(간선의 가중치)
		edgeList = new Edge[E];
		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		
		
		Arrays.sort(edgeList); // 최초, 모든 간선을 가중치 기준 오름차순 정렬
		make(); // 정점 초기화
		
		// 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가 시킴
		int cnt = 0, result = 0;
		for (Edge edge: edgeList) {
			// 싸이클이 형성되지 않는다면
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				// N-1개의 간선이 선택될 때 까지 반복
				if (++cnt == V-1) break;
			}
		}
		
		System.out.println(result);
	}
	
	// make : 정점 초기화 (자신을 대표로)
	static void make() {
		parents = new int[V];
		
		for (int i = 0; i < V; i++)
			parents[i] = i;
	}
	
	// int find : Path Compression
	static int find(int a) {
		if (a == parents[a]) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	// boolean union 
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 사이클 존재시 false
		if (aRoot == bRoot) return false;
		
		// 사이클이 생성되지 않는다면 (다른 부모를 갖는다면) union 수행
		parents[bRoot] = aRoot;
		return true;
	}
	
}
