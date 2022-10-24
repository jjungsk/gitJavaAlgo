package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_21608_상초_SK_g4 {
	
	static int N;
	static int[] dr = {-1, 0, 0, 1}; // 북 서 동 남
	static int[] dc = {0, -1, 1, 0};
	static List<int[]> list;
	static int[][] satisfied;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		
		int people = N*N;
		satisfied = new int[people][];
		for (int i = 0; i < people; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			satisfied[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; 
		}
		
		for (int i = 0; i < people; i++) {
			int[] cur = new int[3];
			cur = mapSearch(i);
			map[cur[0]][cur[1]] = satisfied[i][0];
//			for (int n = 1; n <= N; n++) {
//				for (int m = 1; m <= N; m++) {
//					System.out.print(map[n][m] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("-----------");
		}
		
		int ans = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cur = map[i][j];
				int adj = 0;
				for (int k = 0; k < people; k++) {
					if (cur == satisfied[k][0]) {
						for (int r = 0; r < 4; r++) {
							int surR = i + dr[r];
							int surC = j + dc[r];
							if (map[surR][surC]==0) continue;
							for (int t = 1; t < 5; t++) {
								if (map[surR][surC] == satisfied[k][t]) ++adj;
							}
						}
					}
				}
				
				if (adj == 4) {
					ans += 1000;
//					System.out.println(i + " : " + j + " : " + 1000);
				} else if (adj == 3) {
					ans += 100;
//					System.out.println(i + " : " + j + " : " + 100);
				} else if (adj == 2) {
					ans += 10;
//					System.out.println(i + " : " + j + " : " + 10);
				} else if (adj == 1) {
					ans += 1;
//					System.out.println(i + " : " + j + " : " + 1);
				} else {
//					System.out.println(i + " : " + j + " : " + 0);
				}
						
			}	
		}
		
		System.out.println(ans);
		
		
		
	}

	private static int[] mapSearch(int idx) {
		int curStudent = satisfied[idx][0];
		List<int[]> list = new ArrayList<int[]>();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0) continue;
				list.add(getSat(i, j, satisfied[idx]));
			}
		}
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0]==o2[0]) {
					return o2[1]-o1[1];
				}
				return o2[0]-o1[0];
			}
			
		});
		
//		for (int[] a: list)
//			System.out.println(Arrays.toString(a));
		
		return new int[] {list.get(0)[2], list.get(0)[3], list.get(0)[0]};
		
	}

	private static int[] getSat(int i, int j, int[] satisfiedArr) {
		List<int[]> list = new ArrayList<int[]>();
		int sat = 0;
		int empty = 0;
		for (int r = 0; r < 4; r++) {
			int surR = i + dr[r];
			int surC = j + dc[r];
			if (1<=surR && surR<=N && 1<=surC && surC<=N) {
				if (map[surR][surC] == 0) empty++;
				else {
					for (int s = 1; s < 5; s++) {
						if (map[surR][surC] == satisfiedArr[s]) sat++;
					}
				}
			}
		}
		
		return new int[] {sat, empty, i, j};
	}

}
