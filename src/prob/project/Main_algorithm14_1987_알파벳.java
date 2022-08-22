package prob.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_algorithm14_1987_알파벳 {
	
	static char[][] map;
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // R -> D -> L -> U;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		map = new char[R+2][C+2];
		for (int i = 1; i <= R; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 1; j <= C; j++) {
				map[i][j] = arr[j-1];
			}
		}
		
		char init = map[1][1];
		for (int i = 0; i < R+2; i++) {
			for (int j = 0; j < C+2; j++) {
				if (i==0 || i==R+1 || j==0 || j==C+1)
					map[i][j] = init;
			}
		}

		// 코드 구현
		char[] visited = new char[26];
		
		dfs(1, 1, 0, visited);
		
		System.out.println(ans);
		
	}
	
	private static void dfs(int r, int c, int cnt, char[] visited) {
		
		// 방문한 map에 알파벳을 visited 처리 해주기
		visited[cnt] = map[r][c];
		
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			char temp = map[r+dir[i][0]][c+dir[i][1]]; // 탐색 방향의 char 불러오기
			if (!isVisited(cnt, temp, visited)) dfs(r+dir[i][0], c+dir[i][1], cnt+1, visited);
		}
		
		visited[cnt] = 0;
		
		// 최댓값 확인
		ans = Math.max(ans, cnt+1);
		
	}
	
	private static boolean isVisited(int cnt, char temp, char[] visited) {
		
		for (int i = 0; i < cnt+1; i++) {
			if (temp == visited[i]) return true;
		}
		
		return false;
	}

}
