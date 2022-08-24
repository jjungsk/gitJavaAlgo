package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	
	private static int R, C, cnt, wI, wJ;
	private static boolean escape = false;
	private static boolean die = false;
	private static int[] dPos = new int[2];
	private static ArrayList<int[]> sPos = new ArrayList<>();
	private static ArrayList<int[]> wPos = new ArrayList<>();
	private static final int[] dR = {-1, 0, 1, 0}; // 북 동 남 서
	private static final int[] dC = {0, 1, 0, -1};
	private static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		map = new char[R+2][C+2];
		for (int i = 1; i<R+1; i++) {
			char[] charMap = br.readLine().toCharArray();
			for (int j = 1; j <C+1; j++) {
				map[i][j] = charMap[j-1];
				if (charMap[j-1] == 'D') {
					dPos[0] = i;
					dPos[1] = j;
				}
				if (charMap[j-1] == 'S') {
					sPos.add(new int[] {i, j});
				}
				if (charMap[j-1] == '*') {
					wPos.add(new int[] {i, j});
					wI = i;
					wJ = j;
				}
			}
		}
		
		for (int i = 0; i < R+2; i++) {
			for (int j = 0; j < C+2; j++) {
				if (i==0 || i ==R+1 || j==0 || j==C+1)
					map[i][j] = 'X';
			}
		}
		
		// 구현부
		
		int escapeTime = Math.abs(dPos[0] - sPos.get(0)[0]) + Math.abs(dPos[1] - sPos.get(0)[1]);
		cnt = 0;
		while (cnt != escapeTime) {
			startMove();
			water();
			if (die) break;
			++cnt;
//			for (char[] ch: map)
//				System.out.println(Arrays.toString(ch));
//			System.out.println("-------------");
		}
		
		if (escape)
			System.out.println(escapeTime);
		else
			System.out.println("KAKTUS");
		
//		for (char[] ch: map)
//			System.out.println(Arrays.toString(ch));
//		
//		startMove();
//		water();
//		System.out.println("-------------");
//		
//		startMove();
//		water();
//		for (char[] ch: map)
//			System.out.println(Arrays.toString(ch));
//		
//		for (int[] water: wPos)
//			System.out.println(Arrays.toString(water));
//		System.out.println("-------------");
//		for (int[] sr: sPos)
//			System.out.println(Arrays.toString(sr));
		
		// 출력
//		System.out.println(Arrays.toString(sPos) + " : " + Arrays.toString(dPos));
//		for (char[] ch: map)
//			System.out.println(Arrays.toString(ch));
		
	}
	
	// 물이 map에 퍼지는 함수
	private static void water() {
		ArrayList<int[]> wAddPos = new ArrayList<>();
		
		for (int[] water: wPos) {
			if (Math.abs(water[0]-wI) + Math.abs(water[1]-wJ)  == cnt) {
				for (int delta = 0; delta < 4; delta++) {
					int delR = water[0] + dR[delta];
					int delC = water[1] + dC[delta];
//				System.out.println(delR + " : " + delC);
					if (map[delR][delC] == '.' || map[delR][delC] == 'S')
						wAddPos.add(new int[]{delR, delC});
				}
			}
		}
		
		
		for (int[] wa: wAddPos) {
			map[wa[0]][wa[1]] = '*';
			wPos.add(wa);
		}
	}

	
	// 고슴도치가 map으로 이동할 수 있는 경우의 수
	private static void startMove() {
		ArrayList<int[]> sAddPos = new ArrayList<>();
		
		if (sPos.size() == 0) {
			die = true;
		}
		
		for (int[] tempW: wPos) {
			for (int i = 0; i < sPos.size(); i++) {
				if(tempW[0] == sPos.get(i)[0] && tempW[1] == sPos.get(i)[1])
					sPos.remove(i);
			}
		}
		
		for (int[] start: sPos) {
			for (int delta = 0; delta < 4; delta++) {
				int delR = start[0] + dR[delta];
				int delC = start[1] + dC[delta];
//				System.out.println(delR + " : " + delC);
				if (map[delR][delC] == '.' || map[delR][delC] == 'D')
					sAddPos.add(new int[]{delR, delC});
				if (delR == dPos[0] && delC == dPos[1]) {
					escape = true;
					break;
				}
			}
		}
		
		for (int[] st: sAddPos) {
			map[st[0]][st[1]] = 'S';
			sPos.add(st);
		}
		
	}
	
}
