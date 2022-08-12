package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4012_요리사_for문 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
//			System.out.println("------");
			
			for (int i =1; i <=N; i++) {
				for (int j =i+1; j<=N; j++) {
					map[i][j] += map[j][i];
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			
			src = new int[N];
			arrA = new int[N/2];
			arrB = new int[N/2];
			for (int i = 0; i<N; i++) {
				src[i] = i+1;
			}
			
			arrA[0] = 1;
			
			minV = Integer.MAX_VALUE;
			comb(N/2-1, arrA, 1);
			
//			System.out.println(minV);
			
			sb.append("#").append(tc).append(" ").append(minV).append("\n");
		}
		
		bw.write(sb.toString()+"");
		bw.flush();
		bw.close();
		
	}
	
	private static int N;
	private static int[] arrA;
	private static int[] arrB;
	private static int[] src;
	private static int[][] map;
	private static int minV;

	
	private static void comb(int cnt, int[] arrA, int startIdx) {
		if (cnt == 0) {
			int s = 0;
			for (int i=0; i<N; i++) {
				boolean flag = true;
				for (int x: arrA) {
					if (x == src[i]) {
						flag = false;
						break;
					}
				}
				if (flag) arrB[s++] = i+1;
			}
			
			int tempA = 0;
			int tempB = 0;
			for (int i=0; i<N/2-1; i++) {
				for (int j=i+1; j < N/2; j++) {
					tempA += map[arrA[i]][arrA[j]];
					tempB += map[arrB[i]][arrB[j]];
				}
			}
			
			int tempS = Math.abs(tempA-tempB);
			minV = (minV > tempS)? tempS: minV;
			
//			System.out.println(Arrays.toString(arrA));
//			System.out.println(Arrays.toString(arrB));
//			System.out.println("---------------");
			return;
		}
		
		for (int i =startIdx; i<N; i++) {
			arrA[N/2 - cnt] = i+1;
			comb(cnt - 1, arrA, i+1);
		}
	}

}
