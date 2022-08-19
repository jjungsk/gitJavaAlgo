package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_1260_BFSDFS {
	
	private static StringBuilder sb = new StringBuilder();
	
	private static int[][] adjMatrix;
	private static boolean[] visited, visited2;
	private static int N, M, V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점의 갯수
		M = Integer.parseInt(st.nextToken()); // 간선의 갯수
		V = Integer.parseInt(st.nextToken()); // 시작점 위치
		
		adjMatrix = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
//		for (int[] a: adjMatrix)
//			System.out.println(Arrays.toString(a));
		
		visited = new boolean[N+1];
		
		dfs(V);
		sb.append("\n");
		
		visited2 = new boolean[N+1];
		
		bfs();
		System.out.println(sb);
	}
	
	private static void dfs(int cur) {
		visited[cur] = true;
		sb.append(cur).append(" ");
//		System.out.print(cur + " ");
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adjMatrix[cur][i] != 0) {
				dfs(i);
			}
		}
	}
	
	private static void bfs() {
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(V);
		visited2[V] = true;
		
		while(!dq.isEmpty()) {
			int cur = dq.poll();
//			System.out.print(cur + " ");
			sb.append(cur + " ");
			for (int i = 1; i <= N; i++) {
				if (!visited2[i] && adjMatrix[cur][i] != 0) {
					visited2[i] = true;
					dq.offer(i);
				}
			}
			
		}
		
	}

}
