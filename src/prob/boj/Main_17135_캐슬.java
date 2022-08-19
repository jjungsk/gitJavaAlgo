package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17135_캐슬 {
	
	private static int N, M, D, enemyCnt;
	private static int[][] map, originalMap;
	private static int[] src;
	private static List<int[]> list = new ArrayList<>();
	private static List<int[]> enemyList = new ArrayList<>();
	private static int ans = 0;
	private static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // row N
		M = Integer.parseInt(st.nextToken()); // col M
		D = Integer.parseInt(st.nextToken()); // 사거리 D
		
		// map 입력 & 전체 enemy count & enemyPos 확인
		enemyCnt = 0;
		originalMap = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				originalMap[i][j] = map[i][j] = temp;
				if (temp == 1) {
					enemyCnt++;
				}
			}
		}
		
		
		
		
		// 궁수의 위치 comb를 구하기 위한 src Arr
		src = new int[M];
		for (int i = 0; i < M; i++)
			src[i] = i;
		
		// 구현 part
		
//		for (int i = 0; i < N; i++) {
//			nextMap();
//			for (int[] a: map)
//				System.out.println(Arrays.toString(a));
//			System.out.println("=============");
//		}
		
//		int[] temp = {2,5,8};
//		int kill = killEnemy(0, temp);
		
//		System.out.println("ans");
//		System.out.println(kill);
		
		attack(0, 0, new int[3]);
		System.out.println(ans);
		
		
		// 출력
		
//		System.out.println(Arrays.toString(src));
		
//		attack(0, 0, new int[3]);
		
		
	}
	

	private static int killEnemy(int cnt, int[] archerPos) {
		
		if (cnt == N) return 0;
		
		int killCnt = 0;
		
		// archer3 탐색
		boolean[] isKill = new boolean[3];
		int[][] attackedEnemy = new int[3][2];
		boolean flag2 = false;
		for (int ca = 0; ca < D; ca++) {
			for (int archer = 0; archer < 3; archer++) {
				// map 아래부터 탐색
				if (!isKill[archer]) {
					loop:
					for (int j = archerPos[archer]-ca; j <= archerPos[archer]+ca; j++) {
						// N-ca-1 = 0
						for (int i = N-1; i >= 0; i--) {
							if (0 <= j && j <= M-1 
									&& (Math.abs(i-N) + Math.abs(j-archerPos[archer])) <= ca+1 && map[i][j] == 1) {
//								map[i][j] = 0;
								for (int p = 0; p < 3; p++) {
									if(isKill[p] && attackedEnemy[p][0] == i && attackedEnemy[p][1] == j) {
										flag2 = true;
									}
								}
								isKill[archer] = true;
								attackedEnemy[archer][0] = i;
								attackedEnemy[archer][1] = j;
								if (!flag2)
									killCnt++;
								flag2 = false;
								break loop; // 가장 가까운 적을 죽이고 다음 archer의 target 찾기
							}
						}
					}
				}
			}
		}
		for (int k = 0; k < 3; k++) {
			if(isKill[k]) {
				map[attackedEnemy[k][0]][attackedEnemy[k][1]] = 0;
			}
		}
//		for (int cn1 = 0; cn1 < 2; cn1++) {
//			for (int cn2 = cn1+1; cn2<3; cn2++) {
//				if (attackedEnemy[cn1][0] == attackedEnemy[cn2][0]
//						&& attackedEnemy[cn1][1] == attackedEnemy[cn2][1]) {
//					
//				}
//			}
//		}
//		System.out.println(killCnt);
//		System.out.println("-----");
		// 3명의 archer가 모두 적을 죽이고 나서
		nextMap(); // 턴 종료
//		return killCnt;
		return killCnt + killEnemy(cnt+1, archerPos);
		
		
	}
	
	
	private static void attack(int cnt, int startIdx, int[] archerPos) {
		
		if (cnt == 3) {
			// TODO : 질문!!!!
//			list.add(archerPos);
//			for (int[] a: list)
//				System.out.println(Arrays.toString(a));
			int killCnt = killEnemy(0, archerPos);
			// 맵 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = originalMap[i][j];
				}
			}
			
//			System.out.print("killCnt : " + killCnt + ", arr : ");
//			System.out.println(Arrays.toString(archerPos));
			ans = Math.max(ans, killCnt);
			if (killCnt == enemyCnt) {
				flag = true;
				return;
			}
			
			return;
		}
		
		for (int i = startIdx; i < M; i++) {
			archerPos[cnt] = src[i];
			attack(cnt+1, i+1, archerPos);
			if (flag) return;
		}
		
		return;
		
	}
	
	private static void nextMap() {
		
		for (int i = N-1; i > 0; i--) {
			for (int j = 0; j < M; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		
		for (int j = 0; j < M; j++)
			map[0][j] = 0;
	}

}
