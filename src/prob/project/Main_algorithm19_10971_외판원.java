package prob.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_algorithm19_10971_외판원 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시의 수
		adjMatrix = new int[N][N]; // 도시의 인접 행렬
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		min = Integer.MAX_VALUE;
		visited = new boolean[N]; // N개의 마을은 방문 했는지 확인하는 boolean array
		dfs(0, 0, 0, new int[N]);
		System.out.println(min);
		
	}
	
	static int N, min;
	static int[][] adjMatrix;
	static boolean[] visited;
	
	public static void dfs(int cnt, int cur, int total, int[] order) {
		visited[cur] = true;
		order[cnt] = cur;
		if (cnt == N-1) {
			if (adjMatrix[cur][0] > 0) {
				min = Math.min(min, total + adjMatrix[cur][0]);
//				System.out.println(Arrays.toString(order) + " " + " : " + (total + adjMatrix[cur][0]));
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjMatrix[cur][i] > 0) {
				visited[i] = true;
				if (total + adjMatrix[cur][i] < min)
					dfs(cnt + 1, i, total + adjMatrix[cur][i], order);
				visited[i] = false;
			}
		}
	}

}
