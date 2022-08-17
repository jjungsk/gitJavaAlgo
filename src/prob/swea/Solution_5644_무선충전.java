package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	
	static int[] pBC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // Test Case 수
		
		for (int tc = 1; tc<T+1; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			int cntBC = Integer.parseInt(st.nextToken()); // BC의 총 갯수
			
			int[] arrA = new int[M+1]; // A의 이동 위치를 담은 arr
			int[] arrB = new int[M+1]; // B의 이동 위치를 담은 arr
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++)
				arrA[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++)
				arrB[i] = Integer.parseInt(st.nextToken());
			
			// BC의 지도 정보 저장
			int[][][] map = new int[11][11][cntBC+1];
			pBC = new int[cntBC+1];
			
			for (int infoBC = 1; infoBC <= cntBC; infoBC++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken()); // col 위치
				int r = Integer.parseInt(st.nextToken()); // row 위치
				int k = Integer.parseInt(st.nextToken()); // BC의 층전 범위
				pBC[infoBC] = Integer.parseInt(st.nextToken()); // BC의 처리량
				
				// 지도 map에 저장
				for (int i = r-k; i<=r+k; i++) {
					for (int j = c-k; j<=c+k; j++) {
						if (Math.abs(r-i)+Math.abs(c-j)<=k && 1<=i && i<=10 && 1<=j && j<=10) {
							int temp = map[i][j][0] + 1;
							map[i][j][0] = temp;
							map[i][j][temp] = infoBC;
						}
					}
				}
			}
			
			// 최초 A의 pos과 B의 pos을 int[r, c] 로 저장
			int[] posA = {1, 1};
			int[] posB = {10, 10};
			
			// A와 B의 초기 위치값 (M=0) 충전량을 저장
			int ans = chargeAB(posA, posB, map);
			
			// M 1의 위치에서 M의 위치까지 for문
			for (int m = 1; m <= M; m++) {
				// pos 재정의
				posA = nextPos(arrA[m], posA);
				posB = nextPos(arrB[m], posB);
				
//				int temp = chargeAB(posA, posB, map);
				ans += chargeAB(posA, posB, map);
				
//				System.out.print("m = " + m + ", pos = " + Arrays.toString(posA) + " : " + Arrays.toString(posB) + ", temp = " + temp + ", sum = " + ans + "\n");
			}
			
//			System.out.println(ans);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
		// 출력 형식
//		for (int i = 1; i <= 10; i++) {
//			for (int j = 1; j <= 10; j++) {
//				System.out.print(Arrays.toString(map[i][j]) + " ");
//			}
//			System.out.println();
//		}
				
	}
	
	// 주어진 number에 따른 1초후 사용자의 위치 (r, c)
	private static int[] nextPos(int number, int[] currentPos) {
		switch(number) {
			case 0:
				break;
			case 1:
				currentPos[0] -= 1;
				break;
			case 2:
				currentPos[1] += 1;
				break;
			case 3:
				currentPos[0] += 1;
				break;
			case 4:
				currentPos[1] -= 1;
				break;
		}
		
		return currentPos;
	}
	
	
	// 주어진 map에서 최대 충전량을 저장
	private static int chargeAB(int[] posA, int[] posB, int[][][] map) {
		
		int sum = 0; // 결과값 저장
		int posA0 = map[posA[0]][posA[1]][0];
		int posB0 = map[posB[0]][posB[1]][0];
		
		// A와 B가 둘 다 충전이 될때 [겹칠때와 안겹칠때] 확인!!
		if (posA0 != 0 && posB0 != 0) {
			for (int i = 1; i<=posA0; i++) {
				for (int j = 1; j<=posB0; j++) {
					if (map[posA[0]][posA[1]][i] == map[posB[0]][posB[1]][j]) { // A와 B가 같은 충전기를 사용 한다면
						sum = Math.max(sum, pBC[map[posA[0]][posA[1]][i]]);
					} else
						sum = Math.max(sum, pBC[map[posA[0]][posA[1]][i]] + pBC[map[posB[0]][posB[1]][j]]); // 다른 충전기를 사용한다면
				}
			}
			
			return sum;
		} // A와 B가 겹치는 if문 확인
		
		// A만 충전 될때
		if (posA0 != 0 && posB0 == 0) {
			for (int i = 1; i<=posA0; i++) {
				sum = Math.max(sum, pBC[map[posA[0]][posA[1]][i]]);
			}
			
			return sum;
		}
		
		// B만 충전 될때
		if (posA0 == 0 && posB0 != 0) {
			for (int i = 1; i<=posB0; i++) {
				sum = Math.max(sum, pBC[map[posB[0]][posB[1]][i]]);
			}
			
			return sum;
		}
		
		// A와 B 둘다 충전 안될 때
		return 0;
		
	}

}
