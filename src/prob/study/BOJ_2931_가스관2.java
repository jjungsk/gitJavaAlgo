package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2931_가스관2 {
	
	static int R, C;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] startP = new int[2];
	static int[] endP = new int[2];
	static char[] block = {'|', '-', '+', '1', '2', '3', '4'};
	static char[][] map;
	static char ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		Deque<int[]> dq = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if (map[i][j] == 'M') {
					dq.add(new int[] {i, j});
					visited[i][j] = true;
				}
				if (map[i][j] == 'Z') {
					endP[0] = i;
					endP[1] = j;
				}
			}
		}
		
//			for (char[] a: map)
//				System.out.println(Arrays.toString(a));
//			System.out.println(Arrays.toString(startP));
//			System.out.println(Arrays.toString(endP));
		
		int[] cur = dq.poll();
		int dir = 0;
		char pipe = '=';
		for (int i = 0; i < 4; i++) {
			int nextR = cur[0] + dr[i];
			int nextC = cur[1] + dc[i];
			if (0<=nextR && nextR<R && 0<=nextC && nextC<C && map[nextR][nextC]!='.') {
				if (isFlow(i, map[nextR][nextC])) {
					dq.add(new int[] {nextR, nextC});
					dir = getNextDir(i, map[nextR][nextC]);
					pipe = map[nextR][nextC];
					break;
				}
			}
		}
//		System.out.println(dir + " : " + pipe);
		
		int[] deleteP = new int[2];
		int lastDir = -1;
		ans = '+';
		while(!dq.isEmpty()) {
			cur = dq.poll();
			
			int nextR = cur[0] + dr[dir];
			int nextC = cur[1] + dc[dir];
			
			if (map[nextR][nextC] == '.') {
				int possDir = 0;
				deleteP[0] = nextR+1;
				deleteP[1] = nextC+1;
				for (int i = 0; i < 4; i++) {
					if (dir==0 && i==2) continue;
					if (dir==1 && i==3) continue;
					if (dir==2 && i==0) continue;
					if (dir==3 && i==1) continue;
					int nextRR = nextR + dr[i];
					int nextCC = nextC + dc[i];
					if (nextRR<0 || nextRR>=R || nextCC<0 || nextC>=C || map[nextRR][nextCC]=='.') continue;
					if (isFlow(i, map[nextRR][nextCC])) {
						possDir++;
						lastDir = i;
					}
				}
				
				if (possDir==3) break;
				
				ans = emptyBlock(dir, lastDir);
				break;
			}
			
			dir = getNextDir(dir, map[nextR][nextC]);
			dq.add(new int[] {nextR, nextC});
		}
		
		
		sb.append(deleteP[0]).append(" ")
		.append(deleteP[1]).append(" ").append(ans);
			
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		

		
		
	}

	private static char emptyBlock(int dir, int lastDir) {
		if (dir == 0) {
			if (lastDir == 0) ans = '|';
			if (lastDir == 1) ans = '1';
			if (lastDir == 3) ans = '4';
		}
		if (dir == 1) {
			if (lastDir == 1) ans = '-';
			if (lastDir == 0) ans = '3';
			if (lastDir == 2) ans = '4';
		}
		if (dir == 2) {
			if (lastDir == 2) ans = '|';
			if (lastDir == 1) ans = '2';
			if (lastDir == 3) ans = '3';
		}
		if (dir == 3) {
			if (lastDir == 3) ans = '-';
			if (lastDir == 2) ans = '1';
			if (lastDir == 0) ans = '2';
		}
		return ans;
	}

	private static int getNextDir(int dir, int pipe) {
		if (dir == 0) {
			if (pipe == '|' || pipe == '+') return 0;
			if (pipe == '1') return 1;
			if (pipe == '4') return 3;
		} else if (dir == 1) {
			if (pipe == '-' || pipe == '+') return 1;
			if (pipe == '3') return 0;
			if (pipe == '4') return 2;
		} else if (dir == 2) {
			if (pipe == '|' || pipe == '+') return 2;
			if (pipe == '2') return 1;
			if (pipe == '3') return 3;
		} else {
			if (pipe == '-' || pipe == '+') return 3;
			if (pipe == '1') return 2;
			if (pipe == '2') return 0;
		}
		
		return 0;
	}

	private static boolean isFlow(int dir, char pipe) {
		if (pipe=='M' || pipe=='Z') return false;
		if (dir == 0) {
			if (pipe == '-' || pipe == '2' || pipe == '3') return false;
			else return true;
		} else if (dir == 1) {
			if (pipe == '|' || pipe == '1' || pipe == '2') return false;
			else return true;
		} else if (dir == 2) {
			if (pipe == '-' || pipe == '1' || pipe == '4') return false;
			else return true;
		} else {
			if (pipe == '|' || pipe == '3' || pipe == '4') return false;
			else return true;
		}
	}
}
