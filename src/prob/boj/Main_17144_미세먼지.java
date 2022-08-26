package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		T = Integer.parseInt(st.nextToken()); 
		
		map = new int[R][C];
		airPurifier = new int[2];
		int airPos = 0;
//		dustPos = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				if (map[i][j] >= 5) dustPos.offer(new int[] {i, j});
				if (map[i][j] == -1) {
					airPurifier[airPos] = i;
					airPos++;
				}
			}
		}
		
		// 구현부
		for (int t = 0; t < T; t++) {
			moveDust();
			workPurifier();
		}
		
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) ans += map[i][j]; 
			}
		}
		System.out.println(ans);
		
//		for (int[] a: dustPos)
//			System.out.print(Arrays.toString(a) + " ");
//		System.out.println();
		
//		for (int[] a: map)
//			System.out.println(Arrays.toString(a));
	}
	
	static int R, C, T;
	static int[] dr = {-1, 0, 0, 1}; // 북 서 동 남
	static int[] dc = {0, -1, 1, 0};
	static int[] airPurifier;
	static int[][] map;
//	static Deque<int[]> dustPos;

	static void moveDust() {
		int[][] tempMap = new int[R][C];
		
//		while (!dustPos.isEmpty()) {
//			int[] dustCur = dustPos.poll();
			
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] >= 5) {
					
					int curR = i;
					int curC = j;
					int dustAmount = map[i][j]; // 현재 위치 먼지 양
					
					int diffAmount = 0;
					for (int k = 0; k < 4; k++) {
						int nextR = curR + dr[k];
						int nextC = curC + dc[k];
						if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || map[nextR][nextC] == -1) continue;
						tempMap[nextR][nextC] += dustAmount / 5;
						diffAmount += dustAmount / 5;
					}
					tempMap[curR][curC] += dustAmount - diffAmount;
				} else
					tempMap[i][j] += map[i][j];
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tempMap[i][j];
//				if (map[i][j] >= 5) dustPos.offer(new int[] {i, j});
			}
		}
		
		for (int puri: airPurifier)
			map[puri][0] = -1;
		
	}
	
	static void workPurifier() {
		int upR = airPurifier[0];
		int downR = airPurifier[1];
		
		// 윗 공기
		for (int i = upR-1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for (int j = 0; j < C-1; j++) {
			map[0][j] = map[0][j+1];
		}
		for (int i = 0; i < upR; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for (int j = C-1; j > 1; j--) {
			map[upR][j] = map[upR][j-1];
		}
		map[upR][1] = 0;
		
		// 아랫 공기
		for (int i = downR+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for (int j = 0; j < C-1; j++) {
			map[R-1][j] = map[R-1][j+1];
		}
		for (int i = R-1; i > downR; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for (int j = C-1; j > 1; j--) {
			map[downR][j] = map[downR][j-1];
		}
		map[downR][1] = 0;
		
	}
	
}
