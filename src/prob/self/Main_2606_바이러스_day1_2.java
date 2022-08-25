package prob.self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2606_바이러스_day1_2 {
	
	private static int node, edge, virus;
	private static List<Integer>[] edges;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		
		// edges ArrrayList 초기화
		edges = new ArrayList[node+1];
		for (int i = 0; i <= node; i++)
			edges[i] = new ArrayList<>();
		
		visited = new boolean[node+1];
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edges[from].add(to);
			edges[to].add(from);
		}
		
//		for (List<Integer> a: edges)
//			System.out.println(a);
		
		// 구현부
		bfs();
		
		System.out.println(virus-1);
	}
	
	private static void bfs() {
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		visited[1] = true;
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			virus++;
//			System.out.println(cur);
			for (int next: edges[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					dq.add(next);
				}
			}
		}
		
	}

}
