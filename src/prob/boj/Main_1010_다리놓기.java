package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
//			double sumN = 1d;
//			double sumM = 1d;
			BigInteger sumN = new BigInteger("1");
			BigInteger sumM = new BigInteger("1");
			BigInteger ans = new BigInteger("1");
			
			for (int i = M; i >= M - N + 1; i--) {
				sumM = sumM.multiply(BigInteger.valueOf(i));
				sumN = sumN.multiply(BigInteger.valueOf(M - i + 1));
			}
			
			ans = sumM.divide(sumN);
			sb.append(ans).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		
		
	}

}
