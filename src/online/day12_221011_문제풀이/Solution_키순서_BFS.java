package online.day12_221011_문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_키순서_BFS {
	
	static int N, M, adjMatrix[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[N+1][N+1]; // 학생번호 1번부터 처리
			
			StringTokenizer st;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; // a보다 b가 키가 크다
			}
			
			int ans = 0;
			
			for (int i = 0; i <= N; i++) {
				if (gtBFS(i) + ltBFS(i) == N-1) ++ans;
			}
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	
	static int gtBFS(int start) { // start 학생부터 자신보다 키가 큰 학생따라 탐색
		int cnt = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다 보기
				if (adjMatrix[cur][i] == 1 && visited[i]) { // i가 cur 보다 키가 크고 아직 탐색되지 않았다면
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		return cnt;
	}
	
	static int ltBFS(int start) { // start 학생부터 자신보다 키가 작은 학생따라 탐색
		int cnt = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다 보기
				if (adjMatrix[i][cur] == 1 && visited[i]) { // i가 cur 보다 키가 작고 아직 탐색되지 않았다면
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		return cnt;
	}

}
