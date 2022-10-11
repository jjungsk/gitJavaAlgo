package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_기출1_낚시터 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T + 1; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			fisherPos = new int[3][2];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				fisherPos[i][0] = Integer.parseInt(st.nextToken()); // Gate
				fisherPos[i][1] = Integer.parseInt(st.nextToken()); // 낚시꾼 수
			}
			
			// 게이트 입장 순서 나열 (perm() 함수를 돌리려고 했지만 경우의 수가 작아서 수기 입력 했습니다..^^)
			int[][] perm = {{0,1,2}, {0,2,1}, {1,2,0}, {1,0,2}, {2,1,0}, {2,0,1}};
			int ans = Integer.MAX_VALUE;
			
			// 왼쪽 우선 탐색
			for (int[] order: perm) {
				distance = new int[N+1];
				Arrays.fill(distance, -1); // 방문하지 않은 위치를 -1로 초기화
				int a = toPlace(fisherPos[order[0]][0], fisherPos[order[0]][1]);
				int b = toPlace(fisherPos[order[1]][0], fisherPos[order[1]][1]);
				int c = toPlace(fisherPos[order[2]][0], fisherPos[order[2]][1]);
				ans = Math.min(ans, a+b+c);
//				System.out.println(Arrays.toString(distance) + " : " + (a+b+c));
			}
			
			// 오른쪽 우선 탐색
			for (int[] order: perm) {
				distance = new int[N+1];
				Arrays.fill(distance, -1); // 방문하지 않은 위치를 -1로 초기화
				int a = toPlaceR(fisherPos[order[0]][0], fisherPos[order[0]][1]);
				int b = toPlaceR(fisherPos[order[1]][0], fisherPos[order[1]][1]);
				int c = toPlaceR(fisherPos[order[2]][0], fisherPos[order[2]][1]);
				ans = Math.min(ans, a+b+c);	
//				System.out.println(Arrays.toString(distance) + " : " + (a+b+c));
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static int N;
	static int[] distance;
	static int[][] fisherPos;
	static boolean[] visited;
	
	// 왼쪽 우선 탐색
	static int toPlace(int gate, int fisherCnt) {
		
		int cnt = 0;
		int dist = 1;
		int tot = 0;
		while(true) {
			for (int i = 0; i < N; i++) {
				for (int j = gate-i; j <= gate+i; j++) { // 변경점
					if (1<=j && j<=N && distance[j] == -1) { // 1~N 사이 게이트 입장 && -1 == 방문하지 않았다면
						distance[j] = dist;
						tot += dist;
						if (++cnt == fisherCnt) return tot;
					}
				}
				dist++;
			}
		}
	}
	
	// 오른쪽 우선 탐색
	static int toPlaceR(int gate, int fisherCnt) {
		
		int cnt = 0;
		int dist = 1;
		int tot = 0;
		while(true) {
			for (int i = 0; i < N; i++) {
				for (int j = gate+i; j >= gate-i; j--) { // 변경점
					if (1<=j && j<=N && distance[j] == -1) {
						distance[j] = dist;
						tot += dist;
						if (++cnt == fisherCnt) return tot;
					}
				}
				dist++;
			}
		}
	}
}
