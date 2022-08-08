package prob.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int T = 10;
		
		for (int tc = 1; tc < T + 1; tc++) {
			
			int n = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			int[] ans = new int[n];
			for (int i = 0; i < n; i++) {
				ans[i] = Integer.parseInt(st.nextToken());
			}
			
			int m = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			
			for (int i = 0; i < m; i++) {
				String order = st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int[] arr = new int[cnt];
				
				for (int k = 0; k < cnt; k++) {
					arr[k] = Integer.parseInt(st.nextToken());
				}
				
				for (int j = n-1; j >= idx+cnt && idx+cnt < n; j--) {
					ans[j] = ans[j-cnt];
				}
				
				for (int j = 0; j < cnt && j + idx < n; j++) {
					ans[idx + j] = arr[j];
				}
				
//				System.out.println("idx : " + idx + "cnt : " + cnt + Arrays.toString(arr));
//				System.out.println(Arrays.toString(ans));
//				System.out.println("------------------------");
			} // for - order
			sb.append("#").append(tc).append(" ");
			for (int a = 0; a < 10; a++) 
				sb.append(ans[a]).append(" ");
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
