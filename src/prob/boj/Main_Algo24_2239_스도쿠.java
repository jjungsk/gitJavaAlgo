package prob.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_Algo24_2239_스도쿠 {
	
	static boolean flag = false;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		map = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		
		stkRecursive(0);
		
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			if (i!=8) sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void stkRecursive(int cnt) {
		if (cnt == 81) {
			flag = true;
			return;
		}
		
		int row = cnt / 9;
		int col = cnt % 9;
		
		
		if (map[row][col]!=0) {
			stkRecursive(cnt + 1); // 정확히 맞은 숫자라면
		} else {
			for (int tempNo = 1; tempNo <= 9; tempNo++) {
				if (rowCheck(tempNo, row, col, map) && colCheck(tempNo, row, col, map)
						&& squareCheck(tempNo, row, col, map)) {
					// tempNo가 맞다면
					map[row][col] = tempNo;
					stkRecursive(cnt + 1);
					if(flag) return;
					map[row][col] = 0;
				}
				
			}
		}
	}
	
	// 가로줄 확인
	private static boolean rowCheck(int tempNo, int r, int c, int[][] mapTemp) {
		
		for (int j = 0; j < 9; j++) {
			if (mapTemp[r][j] == tempNo) return false; // 불가능한 숫자라면 false 리턴
		}
		return true; // 가능한 숫자라면 true
	}
	
	// 세로줄 확인
	private static boolean colCheck(int tempNo, int r, int c, int[][] mapTemp) {
		
		for (int i = 0; i < 9; i++) {
			if (mapTemp[i][c] == tempNo) return false;
		}
		return true;
	}
	
	// 3x3 정사각형에 확인
	private static boolean squareCheck(int tempNo, int r, int c, int[][] mapTemp) {
		
		if (0<=r&&r<=2 && 0<=c&&c<=2) { // 0, 0
			for (int i=0; i<=2; i++) {
				for (int j=0; j<=2; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} else if (0<=r&&r<=2 && 3<=c&&c<=5) { // 0, 3
			for (int i=0; i<=2; i++) {
				for (int j=3; j<=5; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} else if (0<=r&&r<=2 && 6<=c&&c<=8) { // 0, 6
			for (int i=0; i<=2; i++) {
				for (int j=6; j<=8; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} else if (3<=r&&r<=5 && 0<=c&&c<=2) { // 3, 0
			for (int i=3; i<=5; i++) {
				for (int j=0; j<=2; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} else if (3<=r&&r<=5 && 3<=c&&c<=5) { // 3, 3
			for (int i=3; i<=5; i++) {
				for (int j=3; j<=5; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} else if (3<=r&&r<=5 && 6<=c&&c<=8) { // 3, 6
			for (int i=3; i<=5; i++) {
				for (int j=6; j<=8; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} else if (6<=r&&r<=8 && 0<=c&&c<=2) { // 6, 0
			for (int i=6; i<=8; i++) {
				for (int j=0; j<=2; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} else if (6<=r&&r<=8 && 3<=c&&c<=5) { // 6, 3
			for (int i=6; i<=8; i++) {
				for (int j=3; j<=5; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} else if (6<=r&&r<=8 && 6<=c&&c<=8) { // 6, 6
			for (int i=6; i<=8; i++) {
				for (int j=6; j<=8; j++) {
					if (mapTemp[i][j] == tempNo) return false;
				}
			}
		} 
		
		return true;
	}

}
