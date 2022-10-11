package prob.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_7793_여신 {
	
	static int T;
	static int R, C;
	static char[][] map;
	static boolean[][] v;
	static int Dr, Dc;
	static Queue<int[]> player;
	static Queue<int[]> devil;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t<=T; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			
			map = new char[R][C];
			v = new boolean[R][C];
			player = new LinkedList<>();
			devil = new LinkedList<>();
			
			for (int i = 0; i < R; i++) {
				char[] temp = sc.next().toCharArray();
				for (int j = 0; j < C; j++) {
					map[i][j] = temp[j];
					
					if (map[i][j] == 'D') {
						Dr = i;
						Dc = j;
					}
					if (map[i][j] == 'S') {
						player.offer(new int[] {i,j,0});
					}
					if (map[i][j] == '*') {
						devil.offer(new int[] {i,j,0});
					}
				}
			}
			
			loop:
			while (true) {
				if(player.size()==0) {
					System.out.println("#"+t+" "+"GAME OVER");
					break loop;
				}
				dfsDevil();
			}
			
			
		} // for end
		
	}

	private static void dfsDevil() {
		int size = devil.size();
		while (size-->0) {
			int[] curr = devil.poll();
			int cr = curr[0];
			int cc = curr[1];
			int cdep = curr[2];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				if (!check(nr, nc)) continue;
				
				if (map[nr][nc]=='.' || map[nr][nc]=='S') {
				}
			}
			
		}
	}

	private static boolean check(int nr, int nc) {
		
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}
			

}
