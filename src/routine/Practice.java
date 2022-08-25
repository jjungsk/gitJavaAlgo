package routine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int start = 0;
		int end = N - 1;
		
		int[] D = new int[N];
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N];
		
		// Initialize
		D[start] = 0;
		int min, minVertex;
		
		// 구현부
		for (int c = 0; c < N; c++) {
			// step1. 가장 작은 min값과 minVertex 찾기
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > D[i]) {
					min = D[i];
					minVertex = i;
				}
			}
			
			// step2. 방문처리
			visited[minVertex] = true;
			
			// stemp3. 최소값 D 갱신
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] > 0 && D[i] > D[minVertex] + adjMatrix[minVertex][i]) {
					D[i] = D[minVertex] + adjMatrix[minVertex][i];
				}
			}
		}
		
		System.out.println(D[end]);
	}
	
}
