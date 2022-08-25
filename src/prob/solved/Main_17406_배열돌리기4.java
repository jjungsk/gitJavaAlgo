package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	
//	private static String input = "5 6 2\r\n" + 
//			"1 2 3 2 5 6\r\n" + 
//			"3 8 7 2 1 3\r\n" + 
//			"8 2 3 1 4 5\r\n" + 
//			"3 4 5 1 1 1\r\n" + 
//			"9 3 2 1 4 3\r\n" + 
//			"3 4 2\r\n" + 
//			"4 2 1" +
//			"";
	
	private static int[][] map;
	private static int[][] initMap;
	private static Deque<Integer> dq = new ArrayDeque<>();
	private static int[][] saved;
	private static int idx = 0;
	private static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(input));
		StringTokenizer st;

		// (1) N, M, K의 값 받기
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		
		// (2) map 값 입력 받기
		map = new int[N+2][M+2];
		initMap = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				initMap[i][j] = map[i][j];
			}
		}
		
		
		// (3) K의 숫자를 받고 순서를 저장 : arrK[][] -> [[3,4,2], [4,2,1]]
		int[][] arrK = new int[K][3];
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int kk = 0; kk < 3; kk++) {
				arrK[k][kk] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(arrK[k]));
		}
		
		
		// (4) K의 배열 순서 저장하기 : saved[][] -> [[1,2], [2,1]]
		int[] order = new int[K];
		int[] newA = new int[K];
		int cnt = K;
		for (int i = 0; i < K; i++)
			order[i] = i+1;
		
		boolean[] visited = new boolean[K];
		int arrSize = factorial(K);
		saved = new int[arrSize][K];
		
		perm(cnt, order, newA, visited);
	
		
		int minV = Integer.MAX_VALUE;
		
		for (int i = 0; i < arrSize; i++) {
			
			// map 초기화
			for (int w = 1; w <= N; w++) {
				for (int e = 1; e <= M; e++) {
					map[w][e] = initMap[w][e];
				}
			}
			
			for (int j = 0; j < K; j++) {
				
				// 회전 구현
				int r = arrK[saved[i][j]-1][0];
				int c = arrK[saved[i][j]-1][1];
				int s = arrK[saved[i][j]-1][2];
				
				System.out.println("r: " + r + ", c: " + c + ", s:" + s);
				
				rotCal(r, c, s);
				
//				for (int[] a: map)
//					System.out.println(Arrays.toString(a));
			}
			System.out.println("----------------------");
			
			for (int n = 1; n <= N; n++) {
				int temp = 0;
				for (int m = 1; m <= M; m++) {
					temp += map[n][m];
				}
				minV = (temp > minV)? minV: temp;
			}
			
		}
		
		
		System.out.println(minV);
		
	}
	
	
	private static void perm(int cnt, int[] order, int[] newA, boolean[] visited) {
		// TODO Auto-generated method stub
		if (cnt == 0) {
			for (int i = 0; i < K; i++) {
				saved[idx][i] = newA[i];
			}
			idx++;
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				newA[K-cnt] = order[i];
				perm(cnt-1, order, newA, visited);
				visited[i] = false;
			}
		}
		
	}


	private static void rotCal(int r, int c, int s) {
		
		if (s == 0)
			return;
		
		// (1)dq 삽입
		for (int j = c-s; j < c+s; j++) {
			dq.addLast(map[r-s][j]);
		}
		for (int i = r-s; i < r+s; i++) {
			dq.addLast(map[i][c+s]);
		}
		for (int j = c+s; j > c-s; j--) {
			dq.addLast(map[r+s][j]);
		}
		for (int i = r+s; i > r-s; i--) {
			dq.addLast(map[i][c-s]);
		}
		
		// (2) 회전
		for (int ro = 0; ro < 1; ro++) {
			dq.addFirst(dq.pollLast());
		}
		
		// (3) map 업데이트
		for (int j = c-s; j < c+s; j++) {
			map[r-s][j] = dq.pollFirst();
		}
		for (int i = r-s; i < r+s; i++) {
			map[i][c+s] = dq.pollFirst();
		}
		for (int j = c+s; j > c-s; j--) {
			map[r+s][j] = dq.pollFirst();
		}
		for (int i = r+s; i > r-s; i--) {
			map[i][c-s] = dq.pollFirst();
		}
		
		rotCal(r, c, s-1);
		
		return;
		
	}
	
	private static int factorial(int x) {
		if (x == 1)
			return x;
		
		x = x * factorial(x-1);
		
		return x;
	}
		
	

}
