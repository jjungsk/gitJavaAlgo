package prob.self.d1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_2n타일링_실버3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+10];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= n; i++)
			dp[i] = (dp[i-1] + dp[i-2])%10007L;
		
		
		System.out.println(dp[n]);
		
		
	}

}
