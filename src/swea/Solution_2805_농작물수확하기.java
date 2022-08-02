package swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {
	
//	private static String input = "1\r\n" + 
//			"5\r\n" + 
//			"14054\r\n" + 
//			"44250\r\n" + 
//			"02032\r\n" + 
//			"51204\r\n" + 
//			"52212\r\n" + 
//			" ";
	
	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new StringReader(input));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("txt\\input_2805.txt"))));
		int T = Integer.parseInt(in.readLine()); // test case
		
		for (int tc = 1; tc < T + 1; tc++) {
			int n = Integer.parseInt(in.readLine()); // map size
			int[][] map = new int[n][n];
			
			// toCharArray 형태로 입력값 받고 map 지정
			for (int i = 0; i < n; i++) {
				char[] ch = in.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = ch[j] - '0';
				}
			}
			
			int sum = 0; // 결과 값
			// 상 -> 중 순서로 탐색
			for (int i = 0; i <= n / 2; i++) {
				// 중앙을 기준으로 좌 -> 우 탐색
				for (int j = n/2 - i; j < n / 2 + i + 1; j++) {
					// 위 -> 아래로 탐색
					for (int row = i; row < n - i; row++) {
						sum += map[row][j];
						map[row][j] = 0; // 지나온 값 0으로 초기화 (중복 방지)
					}
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		
	}

}
