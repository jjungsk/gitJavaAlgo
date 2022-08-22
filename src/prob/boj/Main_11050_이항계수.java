package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050_이항계수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		K = (K < N-K)? K: N-K;
		int up = 1;
		int down = 1;
		for (int i = 1; i <= K; i++) {
			up *= (N+1-i);
			down *= i;
		}
		
		int ans = up / down;
		System.out.println(ans);
	}

}
