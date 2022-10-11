package online.day12_221011_문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_키순서_DFS {
	
	static int N, M, adjMatrix[][];
	static int gtCnt, ltCnt;
	
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
				gtCnt = ltCnt = 0;
				gtDFS(i, new boolean[N+1]);
				ltDFS(i, new boolean[N+1]);
				if (gtCnt + ltCnt == N-1) ++ans;
			}
			System.out.println("#" + tc + " " + ans);
			
		}
		
	}
	
	static void gtDFS(int cur, boolean[] visited) { // start 학생부터 자신보다 키가 큰 학생따라 탐색
		
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다 보기
			if (adjMatrix[cur][i] == 1 && visited[i]) { // i가 cur 보다 키가 크고 아직 탐색되지 않았다면
				gtCnt++; // 나보다 키가 큰 학생 cnt
				gtDFS(i, visited);
			}
		}
		
	}
	
	static void ltDFS(int cur, boolean[] visited) { // start 학생부터 자신보다 키가 큰 학생따라 탐색
		
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다 보기
			if (adjMatrix[i][cur] == 1 && visited[i]) { // i가 cur 보다 키가 크고 아직 탐색되지 않았다면
				ltCnt++; // 나보다 키가 큰 학생 cnt
				ltDFS(i, visited);
			}
		}
		
	}

}
