package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기 {
	
	private static String input = "5 4 7\r\n" + 
			"1 2 3 4\r\n" + 
			"7 8 9 10\r\n" + 
			"13 14 15 16\r\n" + 
			"19 20 21 22\r\n" + 
			"25 26 27 28" +
			"";
	
	
	public static int[][] origin;
	public static int[][] ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new StringReader(input));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int minV = (N > M)? M: N;
		int cnt = (minV%2==0)? minV/2: minV/2+1;
		int start = 1;
		
//		System.out.println(minV);
//		System.out.println(cnt);
		
		origin = new int[N+2][M+2];
		ans = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				ans[i][j] = origin[i][j];
			}
			
		}
		
		
		toRot(N, M, R, start, cnt, origin, ans);
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	// cycle method
	private static void cycle(int N, int M, int R, int start, int[][] origin, int[][] ans) {
		while(R!=0) {
			for (int i = start, j = start, cntO = 0; cntO < 2*N +2*M - 4*start; cntO++) {
				if (i!=N && j==start) {
					ans[i+1][j] = origin[i][j];
					i++;
				}
				if (i==N && j!=M) {
					ans[i][j+1] = origin[i][j];
					j++;
				}
				if (i!=start && j==M) {
					ans[i-1][j] = origin[i][j];
					i--;
				}
				if (i==start && j!=start) {
					ans[i][j-1] = origin[i][j];
					j--;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					origin[i][j] = ans[i][j];
				}
				
			}
			R--;
		}
		return;
	}
	
	// rot method
	private static void toRot(int N, int M, int R, int start, int cnt, int[][] origin, int[][] ans) {
		if (cnt == 0) {
			return;
		}
		
		cycle(N, M, R % (2*N + 2*M - 4*start), start, origin, ans);
		
		toRot(N-1, M-1, R, start + 1, cnt-1, origin, ans);
		
		return;
	}

}
