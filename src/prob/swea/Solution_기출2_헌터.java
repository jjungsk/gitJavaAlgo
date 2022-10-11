package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Solution_기출2_헌터 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			customerPos = new int[5][2]; // 고객 위치
			monsterPos = new int[5][2]; // 몬스터 위치
			
			int temp = 0;
			M = 0; // 고객 또는 몬스터의 수
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken());
					if (temp > 0) { // 양수는 몬스터 위치
						monsterPos[temp][0] = i;
						monsterPos[temp][1] = j;
						M++;
					} else if (temp < 0) { // 음수는 고객 위치
						customerPos[-temp][0] = i;
						customerPos[-temp][1] = j;
					}
				}
			}
			
			
			visited = new boolean[M+1][2]; // [][0] = monster, [][1] = customer
			int[] startPos = {0, 0};
			minDis = Integer.MAX_VALUE;
			
			dfs(0, startPos, startPos, 0);
			
			sb.append("#").append(tc).append(" ").append(minDis).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static int N, M, minDis;
	static int[][] customerPos, monsterPos;
	static boolean[][] visited;
	static Deque<Integer> dq = new ArrayDeque<>();
	
	// 현재 위치에서 다음 위치까지의 거리
	public static int dist(int[] curPos, int[] nextPos) {
		return Math.abs(curPos[0]-nextPos[0]) + Math.abs(curPos[1]-nextPos[1]);
	}

	
	public static void dfs(int cnt, int[] curPos, int[] nextPos, int dist) {
		
		// 기저 조건 : 고객과 몬스터 다 방문 했다면 재귀 종료
		if (cnt == 2*M) {
			minDis = Math.min(minDis, dist); // 모두 방문 했을때 거리의 값은 최소값으로 갱신
			System.out.println("----------------");
			return;
		}
		
		// 1번 부터 M까지 재귀
		for (int i = 1; i <= M; i++) {
			if (!visited[i][0]) { // [i][0] = monster를 아직 방문하지 않았다면
				visited[i][0] = true;
				System.out.print(i + " ");
				dfs(cnt+1, nextPos, monsterPos[i], dist + dist(nextPos, monsterPos[i])); // 다음 몬스터 확인
				dq.poll();
				visited[i][0] = false;
			}
			if (visited[i][0] && !visited[i][1]) { // [i][0] = monster를 방문하고 [i][1] = 고객은 방문하지 않았다면
				visited[i][1] = true;
				System.out.print(-i + " ");
				dfs(cnt+1, nextPos, customerPos[i], dist + dist(nextPos, customerPos[i])); // 다음 고객집 확인
				visited[i][1] = false;
			}
		}
		
	}
	
	
	
	
	

}
