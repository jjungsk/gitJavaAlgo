package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R+2][C];
		
		// map 지정
		for (int i = 1; i <= R; i++) {
			char[] ch = br.readLine().toCharArray();
			map[i] = ch;
		}
		
		for (int i = 1; i <= R; i++) {
			call = 0;
			flag = false;
			conPipe(i, 0);
//			System.out.println(call);
		}
		
//		for (int i = 1; i <= R; i++) {
//			for (int j = 0; j < C; j++)
//				System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
		
		System.out.println(ans);
	}
	
	private static int R, C, ans;
	private static char[][] map;
	private static boolean flag;
	private static int call;
	
	private static void conPipe(int r, int c) {
		
		call++;
		map[r][c] = 'x';
		
		if (c == C-2) {
			for (int i = -1; i <= 1; i++) {
				if (map[r+i][c+1] != 'x' && 1<=r+i && r+i<=R) {
					map[r][c] = 'x';
					break;
				}
			}
			flag = true;
			ans++;
			return;
		}
		
		for (int i = -1; i <= 1; i++) {
			if (map[r+i][c+1] != 'x' && 1<=r+i && r+i<=R) conPipe(r+i, c+1);
			if (flag) return;
		}
	
		return;
	}


}
