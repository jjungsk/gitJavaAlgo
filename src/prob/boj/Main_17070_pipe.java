package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_pipe {
	
	static int cnt = 0;
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < N+2; j++) {
				map[i][j] = 1;
			}
		}
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j =1; j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		int[][] curP = {{1,1}, {1,2}};
		
		dfs(curP[0][0], curP[0][1], curP[1][0], curP[1][1]);
		
		System.out.println(cnt);
	}

	private static void dfs(int sPosI, int sPosJ, int ePosI, int ePosJ) {
		
		if(map[ePosI][ePosJ]==1) {
			return;
		}
		
		if (ePosI==N && ePosJ == N) {
			++cnt;
			return;
		}
		
		// 파이프가 가로일때, 세로일때, 대각선일때
		// 가로
		if (ePosJ-sPosJ==1 && ePosI==sPosI) {
			// 가로 -> 가로
			if (map[ePosI][ePosJ+1]!=1) {
				dfs(sPosI, sPosJ+1, ePosI, ePosJ+1);
			}
			// 가로 -> 대각선
			if (map[ePosI][ePosJ+1]!=1 && map[ePosI+1][ePosJ+1]!=1 && map[ePosI+1][ePosJ]!=1) {
				dfs(sPosI, sPosJ+1, ePosI+1, ePosJ+1);
			}
			
		} else if (ePosJ==sPosJ && ePosI-sPosI==1) { // 세로
			// 세로 -> 세로
			if (map[ePosI+1][ePosJ]!=1) {
				dfs(sPosI+1, sPosJ, ePosI+1, ePosJ);
			}
			
			// 세로로 -> 대각선
			if (map[ePosI][ePosJ+1]!=1 && map[ePosI+1][ePosJ+1]!=1 && map[ePosI+1][ePosJ]!=1) {
				dfs(sPosI+1, sPosJ, ePosI+1, ePosJ+1);
			}
		} else { // 대각선
//			System.out.println("대각선");
//			System.out.println("("+sPosI+", "+sPosJ+") : (" +ePosI+", "+ePosJ+")");
//			System.out.println(map[ePosI+1][ePosJ]);
			// 대각선 -> 가로
			if (map[ePosI][ePosJ+1]!=1) {
				dfs(sPosI+1, sPosJ+1, ePosI, ePosJ+1);
			}
			// 대각선 -> 세로
			if (map[ePosI+1][ePosJ]!=1) {
				dfs(sPosI+1, sPosJ+1, ePosI+1, ePosJ);
			}
			// 대각선 -> 대각선
			if (map[ePosI][ePosJ+1]!=1 && map[ePosI+1][ePosJ+1]!=1 && map[ePosI+1][ePosJ]!=1) {
				dfs(sPosI+1, sPosJ+1, ePosI+1, ePosJ+1);
			}
		}
		
		return;
		
	}
//	private static void dfs(int sPosI, int sPosJ, int ePosI, int ePosJ) {
//		
//		if (map[ePosI][ePosJ]==1 || map[ePosI-1][ePosJ]==1 || map[ePosI][ePosJ-1]==1) {
//			return;
//		}
//		
//		if (ePosI==N && ePosJ == N) {
//			System.out.println("들어옴");
//			++cnt;
//			return;
//		}
//		
//		// 파이프가 가로일때, 세로일때, 대각선일때
//		// 가로
//		if (ePosJ-sPosJ==1 && ePosI==sPosI) {
//			// 가로 -> 가로
//			if (map[ePosI][ePosJ+1]==1) {
//				return;
//			} else {
//				dfs(sPosI, sPosJ+1, ePosI, ePosJ+1);
//			}
//			// 가로 -> 대각선
//			if (map[ePosI][ePosJ+1]==1 || map[ePosI+1][ePosJ+1]==1 || map[ePosI+1][ePosJ]==1) {
//				return;
//			} else {
//				System.out.println("in 1");
//				dfs(sPosI, sPosJ+1, ePosI+1, ePosJ+1);
//			}
//			
//		} else if (ePosJ==sPosJ && ePosI-sPosI==1) { // 세로
//			// 세로 -> 세로
//			if (map[ePosI+1][ePosJ]==1) {
//				return;
//			} else {
//				dfs(sPosI+1, sPosJ, ePosI+1, ePosJ);
//			}
//			// 세로로 -> 대각선
//			if (map[ePosI][ePosJ+1]==1 || map[ePosI+1][ePosJ+1]==1 || map[ePosI+1][ePosJ]==1) {
//				return;
//			} else {
//				dfs(sPosI+1, sPosJ, ePosI+1, ePosJ+1);
//			}
//		} else { // 대각선
//			System.out.println("대각선");
//			// 대각선 -> 가로
//			if (map[ePosI][ePosJ+1]==1) {
//				return;
//			} else {
//				dfs(sPosI+1, sPosJ+1, ePosI, ePosJ+1);
//			}
//			
//			// 대각선 -> 세로
//			if (map[ePosI+1][ePosJ]==1) {
//				return;
//			} else {
//				System.out.println("in 2");
//				dfs(sPosI+1, sPosJ+1, ePosI+1, ePosJ);
//			}
//			
//			// 대각선 -> 대각선
//			if (map[ePosI][ePosJ+1]==1 || map[ePosI+1][ePosJ+1]==1 || map[ePosI+1][ePosJ]==1) {
//				return;
//			} else {
//				dfs(sPosI+1, sPosJ+1, ePosI+1, ePosJ+1);
//			}
//		}
//		
//		return;
//		
//	}
	
	// dfs(sPosI, sPosJ, ePosI, ePosJ);

}
