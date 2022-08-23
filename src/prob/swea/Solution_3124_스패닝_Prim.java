package prob.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

// Prim algorithm => nodes의 갯수가 많을때 유리
public class Solution_3124_스패닝_Prim {
	
	private static int V, N, totalWeight;
	private static List<Edge>[] edges;
	
	public static class Edge implements Comparable<Edge> {
		
		int to, weight;
		
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static void prim(int vertex) {
		Deque<Edge> dq = new ArrayDeque<>();
		dq.add(new Edge(vertex, 0)); // 시작 정점 저장
		
		boolean[] visited = new boolean[V+1]; // 해당 정점을 간선으로 연결했는지 확인
		totalWeight = 0;
		
		while (!dq.isEmpty()) {
			Edge edge = dq.poll(); // 간선
			
			if (!visited[edge.to]) { // 방문 유무에 따라 그래프에 사이클리 생기는지 결정
				visited[edge.to] = true;
				totalWeight += edge.weight;
				
				for (Edge next: edges[edge.to]) {
					if (!visited[next.to]) {
						dq.add(next); // 방문하지 않은 해당 정점으로 부속된 간선 큐에 저장
					}
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[N];
		for (int i = 0; i < N; i++)
			edges[i] = new ArrayList<Edge>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		prim(0);
		
		System.out.println(totalWeight);
		
	}

}
