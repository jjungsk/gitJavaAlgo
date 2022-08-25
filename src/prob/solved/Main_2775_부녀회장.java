package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_부녀회장 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int k = Integer.parseInt(in.readLine()); // k층
			int n = Integer.parseInt(in.readLine()); // n호
			
			int[] arr = new int[n+1];
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}
			

			
			// 1층 이상 살때
			while (k != 0) {
				int sum = 0;
				for (int i = 1; i <= n; i++) {
					sum += arr[i];
					arr[i] = sum;
				}
				k--;
			}
			sb.append(arr[n]).append("\n");
//			System.out.println(arr[n]);
			
		}
		System.out.println(sb);
	}

}
