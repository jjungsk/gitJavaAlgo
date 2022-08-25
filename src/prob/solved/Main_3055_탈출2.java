package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_3055_탈출2 {
	
	private static int R, C, escapeTime, wI, wJ, sI, sJ;
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
		
		visited = new int[R+2][C+2];
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
					sI = i;
					sJ = j;
					dqStart.offer(new int[] {i, j});
					visited[i][j] = 2;
				}
				if (charMap[j-1] == '*') {
					wPos.add(new int[] {i, j});
					wI = i;
					wJ = j;
					dqWater.offer(new int[] {i, j});
					visited[i][j] = 1;
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
		while (!escape && !die) {
			escape = false;
			die = true;
			bfs();
//			System.out.println(escape);
//			for (int i = 1; i<=R; i++) {
//				for (int j = 1; j <=C; j++)
//					System.out.print(map[i][j] + " ");
//				System.out.println();
//			}
//			System.out.println("------------");
		}
		
		if(escape)
			System.out.println(escapeTime+1);
		else
			System.out.println("KAKTUS");
		

		
	}
	
	private static Deque<int[]> dqWater = new ArrayDeque<>();
	private static Deque<int[]> dqStart = new ArrayDeque<>();
	private static int[][] visited;
	
	private static void bfs() {
		
		for (int[] a: dqStart) {
			for (int delta = 0; delta < 4; delta++) {
				int destSR = a[0] + dR[delta];
				int destSC = a[1] + dC[delta];
				if (destSR == dPos[0] && destSC == dPos[1]) {
					escape = true;
					return;
				}
			}
		}
		
		loopD:
		for (int delta = 0; delta < 4; delta++) {
			int surR = dPos[0] + dR[delta];
			int surC = dPos[1] + dC[delta];
			if (map[surR][surC] == '.') {
				die = false;
				break loopD;
			}
		}
		
		int wLen = dqWater.size();
		for (int i = 0; i < wLen; i++) {
			// water 선 실행
			int[] waterPos = dqWater.poll();
			int rWater = waterPos[0];
			int cWater = waterPos[1];
			for (int delta = 0; delta < 4; delta++) {
				int nextWR = rWater + dR[delta];
				int nextWC = cWater + dC[delta];
				if (visited[nextWR][nextWC] != 1 && map[nextWR][nextWC] == '.' || map[nextWR][nextWC] == 'S') {
					visited[nextWR][nextWC] = 1;
					dqWater.add(new int[] {nextWR, nextWC});
					map[nextWR][nextWC] = '*';
				}
			}
		}
		
		int sLen = dqStart.size();
		for (int i = 0; i < sLen; i++) {
			// start 후 실행
			int[] startPos = dqStart.poll();
			int rStart = startPos[0];
			int cStart = startPos[1];
			for (int delta = 0; delta < 4; delta++) {
				int nextSR = rStart + dR[delta];
				int nextSC = cStart + dC[delta];
				if (visited[nextSR][nextSC] !=1 && visited[nextSR][nextSC] !=2 && map[nextSR][nextSC] == '.') {
					visited[nextSR][nextSC] = 2;
					dqStart.add(new int[] {nextSR, nextSC});
					map[nextSR][nextSC] = 'S';
				}
			}
		}
		
		if (dqStart.isEmpty()) {
			die = true;
			return;
		}
		
		escapeTime++;
		
	}
	
	
}
