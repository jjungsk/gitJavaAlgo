package prob.self.d1013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int[] dp = new int[N+2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1] = arr[0][0];
		
//		for (int[] a: arr)
//			System.out.println(Arrays.toString(a));
		
		for (int i = 1; i < N; i++) {
			arr[i][0] += dp[1];
			arr[i][i] += dp[i];
			for (int j = 1; j < i; j++) {
				arr[i][j] += Math.max(dp[j], dp[j+1]);
			}
			for (int k = 0; k < i+1; k++) {
				dp[k+1] = arr[i][k];
			}
//			System.out.println(Arrays.toString(dp));
		}
		int ans = 0;
		for (int a: dp) ans = (a>ans)? a: ans;
		System.out.println(ans);
		
	}

}
