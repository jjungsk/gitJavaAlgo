package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_13023_ABCDE {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); // 정점
		N = Integer.parseInt(st.nextToken()); // 간선의 갯수
		
		list = new ArrayList[V];
		for (int i = 0; i < V; i++) 
			list[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		
		for (int i = 0; i < V; i++) {
			flag = false;
			visited = new boolean[V];
			dfs(i, 0);
			if(flag) break;
		}
		
		if(flag)
			System.out.println(1);
		else
			System.out.println(0);
		
	}
	
	private static List<Integer>[] list;
	private static int V, N;
	private static boolean flag;
	private static boolean[] visited;
	
	private static void dfs(int start, int depth) {
		
		if (depth == 4) {
			flag = true;
			return;
		}
		
		visited[start] = true;
	
		int len = 0;
		while (list[start].size() != len) {
			int next = list[start].get(len++);
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, depth+1);
				visited[next] = false;
				if (flag) return;
			}
		}
		
		for (int i = 0, size = list[start].size(); i < size; i++) {
			int next = list[start].get(i);
			if (!visited[next]) {
				
			}
		}
		
		return;
	}

}
