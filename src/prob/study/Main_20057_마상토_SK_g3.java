package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_20057_마상토_SK_g3 {
	
	static int N;
	static int[] windR = {-2, -1, -1, -1, 0, 0, 1, 1, 1, 2};
	static int[] windC = {0, -1, 0, 1, -2, -1, -1, 0, 1, 0};
	static int[] percent = {2, 10, 7, 1, 5, 55, 10, 7, 1, 2};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {N/2+1, N/2+1});
		
		int cnt = 0; // 이동 cnt
		int tot = N*N; // 총 이동해야 할 total cnt = N*N번
		while (cnt != tot) {
			int[] cur = dq.poll();
			
			
		}
				
		rotat();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void rotat() {
		
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dq.add(map[i][j]);
			}
		}
		
		for (int j = N; j >= 1; j--) {
			for (int i = 1; i <= N; i++) {
				map[i][j] = dq.poll();
			}
		}
		
	}

	private static int[][] mapCopy() {
		
		int[][] temp = new int[N+2][N+2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		return temp;
	}

}
