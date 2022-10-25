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

public class BOJ_2931_가스관 {
	
	static int R, C;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] startP = new int[2];
	static int[] endP = new int[2];
	static char[][] map;
	
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
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if (map[i][j] == 'M') {
					startP[0] = i;
					startP[1] = j;
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
		
		Deque<int[]> dq = new ArrayDeque<>();
		int dir = 0;
		for (int i = 0; i < 4; i++) {
			int nextR = startP[0] + dr[i];
			int nextC = startP[1] + dc[i];
			if (0<=nextR && nextR<R && 0<=nextC && nextC<C && map[nextR][nextC]!='.' && map[nextR][nextC]!='Z') {
				if (i==0 && (map[nextR][nextC]=='-' || map[nextR][nextC]=='2' || map[nextR][nextC]=='3')) continue; 
				if (i==1 && (map[nextR][nextC]=='|' || map[nextR][nextC]=='1' || map[nextR][nextC]=='2')) continue; 
				if (i==2 && (map[nextR][nextC]=='-' || map[nextR][nextC]=='1' || map[nextR][nextC]=='4')) continue; 
				if (i==3 && (map[nextR][nextC]=='|' || map[nextR][nextC]=='3' || map[nextR][nextC]=='4')) continue; 
					
				dir = i;
				dq.add(new int[] {nextR, nextC});
				break;
			}
		}
		
//		if (!flag) {
//			for (int i = 0; i < 4; i++) {
//				int nextR = endP[0] + dr[i];
//				int nextC = endP[1] + dc[i];
//				if (0<=nextR && nextR<R && 0<=nextC && nextC<C && map[nextR][nextC]!='.') {
//					flag = true;
//					dir = i;
//					dq.add(new int[] {nextR, nextC});
//				}
//			}
//		}
		
		List<Character> list = new ArrayList<>();
		char ansBlock='.';
//			ansBlock = 'X';
//			System.out.println(ansBlock);
		int[] delBlock = new int[2];
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			visited[cur[0]][cur[1]] = true;
			
			if (map[cur[0]][cur[1]] == '.') {
				delBlock[0] = cur[0];
				delBlock[1] = cur[1];
				int cnt = 0;
				
				int nDir = 0;
				for (int i = 0; i < 4; i++) {
					if (dir == 0 && i==2) continue;
					if (dir == 1 && i==3) continue;
					if (dir == 2 && i==0) continue;
					if (dir == 3 && i==1) continue;
					int nextR = cur[0] + dr[i];
					int nextC = cur[1] + dc[i];
					if (0<=nextR && nextR<R && 0<=nextC && nextC<C 
							&& (map[nextR][nextC]!='.')) {
						if (map[nextR][nextC] == '+') {
							cnt++;
							list.add(map[nextR][nextC]);
							nDir = i;
							break;
						}
						if (visited[nextR][nextC]) continue;
						cnt++;
						list.add(map[nextR][nextC]);
						nDir = i;
					}
				}
//					System.out.println(nDir + " : " + dir);
				if (cnt == 3) {
					ansBlock = '+';
					break;
				} else {
					if (nDir == 0) {
						if (dir==0) {
							ansBlock = '|';
							break;
						}
						if (dir==3) {
							ansBlock = '2';
							break;
						}
						if (dir==1) {
							ansBlock = '3';
							break;
						}
					}
					if (nDir == 1) {
						if (dir==1) {
							ansBlock = '-';
							break;
						}
						if (dir==0) {
							ansBlock = '1';
							break;
						}
						if (dir==2) {
							ansBlock = '2';
							break;
						}
					}
					if (nDir == 2) {
						if (dir==2) {
							ansBlock = '|';
							break;
						}
						if (dir==3) {
							ansBlock = '1';
							break;
						}
						if (dir==1) {
							ansBlock = '4';
							break;
						}
					}
					if (nDir == 3) {
						if (dir==3) {
							ansBlock = '-';
							break;
						}
						if (dir==2) {
							ansBlock = '3';
							break;
						}
						if (dir==0) {
							ansBlock = '4';
							break;
						}
					}
				}
			} // 결과 값
			
			if (dir == 0) {
				if (map[cur[0]][cur[1]] == '+' || map[cur[0]][cur[1]] == '|') {
					dq.add(new int[] {cur[0]-1, cur[1]});
					continue;
				}
				if (map[cur[0]][cur[1]] == '1') {
					dir = 1;
					dq.add(new int[] {cur[0], cur[1]+1});
					continue;
				}
				if (map[cur[0]][cur[1]] == '4') {
					dir = 3;
					dq.add(new int[] {cur[0], cur[1]-1});
					continue;
				}
			}
			
			if (dir == 1) {
				if (map[cur[0]][cur[1]] == '+' || map[cur[0]][cur[1]] == '-') {
					dq.add(new int[] {cur[0], cur[1]+1});
					continue;
				}
				if (map[cur[0]][cur[1]] == '3') {
					dir = 0;
					dq.add(new int[] {cur[0]-1, cur[1]});
					continue;
				}
				if (map[cur[0]][cur[1]] == '4') {
					dir = 2;
					dq.add(new int[] {cur[0]+1, cur[1]});
					continue;
				}
			}
			
			if (dir == 2) {
				if (map[cur[0]][cur[1]] == '+' || map[cur[0]][cur[1]] == '|') {
					dq.add(new int[] {cur[0]+1, cur[1]});
					continue;
				}
				if (map[cur[0]][cur[1]] == '2') {
					dir = 1;
					dq.add(new int[] {cur[0], cur[1]+1});
					continue;
				}
				if (map[cur[0]][cur[1]] == '3') {
					dir = 3;
					dq.add(new int[] {cur[0], cur[1]-1});
					continue;
				}
			}
			
			if (dir == 3) {
				if (map[cur[0]][cur[1]] == '+' || map[cur[0]][cur[1]] == '-') {
					dq.add(new int[] {cur[0], cur[1]-1});
					continue;
				}
				if (map[cur[0]][cur[1]] == '1') {
					dir = 2;
					dq.add(new int[] {cur[0]+1, cur[1]});
					continue;
				}
				if (map[cur[0]][cur[1]] == '2') {
					dir = 0;
					dq.add(new int[] {cur[0]-1, cur[1]});
					continue;
				}
			}
			
		}
			
		sb.append(delBlock[0]+1).append(" ")
		.append(delBlock[1]+1).append(" ").append(ansBlock);
			
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		

		
		
	}
}
