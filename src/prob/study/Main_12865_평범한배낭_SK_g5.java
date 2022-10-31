package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭_SK_g5 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
//		for (int[] a: arr)
//			System.out.println(Arrays.toString(a));
//		System.out.println("------");
		
		int[] dp = new int[K+1];
		
		int searchW = 0;
		for (int i = 0; i < N; i++) {
			searchW = arr[i][0];
			for (int j = K; j >= searchW; j--) {
				dp[j] = Math.max(dp[j], arr[i][1]+dp[j-searchW]);
			}
			System.out.println(Arrays.toString(dp));
		}
		
		System.out.println(dp[K]);
		
		
		
	}

}
