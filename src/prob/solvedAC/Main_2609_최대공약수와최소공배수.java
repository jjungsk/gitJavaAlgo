package prob.solvedAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
	
	// Euclidean Algorithm
	private static int gcd(int a, int b) {
		if (b == 0) return a;
		
		System.out.println(b +" " + a%b);
		return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if (a <= b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int maxD = 1;
		int minM = 0;
		
		int gcd = gcd(a, b);
		
		for (int i = 1; i <= b; i++) {
			if (a%i == 0 && b%i == 0) {
				maxD = (i > maxD)? i: maxD;
			}
		}
		
		minM = maxD * (a/maxD) * (b/maxD);
		
		System.out.println(maxD);
		System.out.println(minM);
			
		
		
	}

	
}
