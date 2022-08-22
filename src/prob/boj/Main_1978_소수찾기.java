package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978_소수찾기 {
	
	private static boolean isPrime(int x) {
		if (x==1)
			return false;
		
		int end = (int) Math.sqrt(x);
		
		for (int i = 2; i <= end; i++) {
			if (x%i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine(), " ");
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (isPrime(Integer.parseInt(st.nextToken())))
				ans++;
		}
		
		System.out.println(ans);
	}

}
