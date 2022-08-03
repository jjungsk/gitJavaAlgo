package swea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873_BattleField {
	
	
	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("txt\\input_1873.txt"))));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine()); // Test Case number;
		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int H = Integer.parseInt(st.nextToken()); // map Height
			int W = Integer.parseInt(st.nextToken()); // map Width
			char[][] map = new char[H + 2][W + 2];

			int idI = 0; // start point row i
			int idJ = 0; // start point column j
			char pos = '0'; // start position
			// map Input
			for (int i = 1; i < H + 1; i++) {
				st = new StringTokenizer(in.readLine());
				char[] tempCh = st.nextToken().toCharArray();
				for (int j = 1; j < W + 1; j++) {
					map[i][j] = tempCh[j - 1];
					if (tempCh[j - 1] - '0' > 0) {
						idI = i;
						idJ = j;
						pos = tempCh[j-1];
					}
				}
			}
			
			int N = Integer.parseInt(in.readLine()); // input String Length
			st = new StringTokenizer(in.readLine());
			char[] commands = new char[N];
			commands = st.nextToken().toCharArray(); // make command String -> toCharArr
			int cnt = 1;
			// iterative until command over
			for (char command: commands) {
				map[idI][idJ] = '.';
				switch (command) {
					case 'U':
						if (map[idI - 1][idJ] == '.')
							idI--;
						pos = '^';
						break;
					case 'D':
						if (map[idI + 1][idJ] == '.')
							idI++;
						pos = 'v';
						break;
					case 'L':
						if (map[idI][idJ - 1] == '.')
							idJ--;
						pos = '<';
						break;
					case 'R':
						if (map[idI][idJ + 1] == '.')
							idJ++;
						pos = '>';
						break;
					case 'S':
						int shI = idI; // temp shell position i
						int shJ = idJ; // temp shell position j
						if (pos == '^') {
							//
							while (map[shI - 1][shJ] != '#' && shI - 1 != 0) {
								if (map[shI - 1][shJ] == '*') {
									map[shI - 1][shJ] = '.';
									break;
								}
								shI--;
							}
						} else if (pos == 'v') {
							//
							while (map[shI + 1][shJ] != '#' && shI != H) {
								if (map[shI + 1][shJ] == '*') {
									map[shI + 1][shJ] = '.';
									break;
								}
								shI++;
							}
						} else if (pos == '<') {
							//
							while (map[shI][shJ - 1] != '#' && shJ - 1 != 0) {
								if (map[shI][shJ - 1] == '*') {
									map[shI][shJ - 1] = '.';
									break;
								}
								shJ--;
							}
						} else if (pos == '>') {
							//
							while (map[shI][shJ + 1] != '#' && shJ != W) {
								if (map[shI][shJ + 1] == '*') {
									map[shI][shJ + 1] = '.';
									break;
								}
								shJ++;
							}
						}
				} // switch end
			} // for end
			map[idI][idJ] = pos;
			
			sb.append("#").append(tc).append(" ");
			for (int i = 1; i < H + 1; i++) {
				for(int j = 1; j < W + 1; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
