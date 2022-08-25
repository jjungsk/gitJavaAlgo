package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
				
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 물품 수
		int K = Integer.parseInt(st.nextToken()); // 최대 무게
		
		int[] vA = new int[N+1]; // 가치 array
		int[] wA = new int[N+1]; // 무게 array
		int[] dp = new int[K+1]; // 최대 무게까지의 최대 가치를 담는 dp
		
		for (int i=1; i<=N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			wA[i] = Integer.parseInt(st.nextToken());
			vA[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=K; j>=wA[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-wA[i]]+vA[i]);
			}
		}
		
		out.write(dp[K]+"");
		out.flush();
		out.close();
				
		
	}

}
