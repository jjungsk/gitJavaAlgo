package routine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Daily {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// start -> end로의 최단 경로
		int start = 0; // 출발 정점
		int end = V-1; // 도착 정점
		
		// dijkstra 알고리즘에 필요한 구조
		int[] D = new int[V];
		boolean[] visited = new boolean[V];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		// 출발 정점 처리
		D[0] = 0;
		
		int min, minVertex;
		
		for (int i = 0; i < V; i++) {
			// step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
			// 방문해야 하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					minVertex = j;
				}
				System.out.println(j + " : " + min + " : " + minVertex);
			}
			// step2. 방문 처리
			visited[minVertex] = true;
			
			// step2. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
					D[j] = D[minVertex] + adjMatrix[minVertex][j];
				}
			}
			
		}
		
		System.out.println(Arrays.toString(D));
		System.out.println(D[end]);
		
		
	
	}
	
}