package swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {
	
	private static String input = "1 0 1 0 1 0 0 1 0 1\r\n" + 
			"1 0 1 1 1 0 0 1 0 1\r\n" + 
			"1 1 1 0 1 1 1 1 0 1\r\n" + 
			"1 0 1 0 1 0 0 1 1 1\r\n" + 
			"1 0 1 0 1 0 0 1 0 1\r\n" + 
			"1 0 1 0 1 0 0 1 0 1\r\n" + 
			"1 1 1 0 1 1 1 1 0 1\r\n" + 
			"1 0 1 0 1 0 0 1 1 1\r\n" + 
			"1 1 1 0 1 0 0 1 0 1\r\n" + 
			"1 0 1 0 1 0 0 2 0 1\r\n" + 
			"";
	
	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(input));
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("txt\\input_1210.txt"))));
		StringTokenizer st;
		int T = 10; // Total case 수
		
		for (int tc = 1; tc < T + 1; tc++) {
			int size = 100; // map size
			int testCase = Integer.parseInt(in.readLine()); // testcase 입력 값
			int endPx = 0;
			int endPy = size;
			
			int[][] map = new int[size + 2][size + 2];
			for (int i = 1; i < size + 1; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j < size + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i == size && map[i][j] == 2)
						endPx = j;
				}
			}
//			System.out.println(endPx + " : " + endPy);
//			for (int i = 0; i < size + 2; i++)
//				System.out.println(Arrays.toString(map[i]));

			while (endPy != 1) {
				// 이미 지나온 길 0으로 초기화
				map[endPy][endPx] = 0;
				// 좌우(左右) 탐색 -> 상(上) 탐색
				if (map[endPy][endPx - 1] == 1) { // 좌
					endPx--;
				} else if (map[endPy][endPx + 1] == 1) { // 우
					endPx++;
				} else if (map[endPy - 1][endPx] == 1) { // 상
					endPy--;
				}
			}
//			System.out.println("X : " + endPx + ", Y : " + endPy);
			System.out.println("#" + tc + " " + (endPx - 1)); // index 값이므로 -1 필요
	
			
		}
	}

}
