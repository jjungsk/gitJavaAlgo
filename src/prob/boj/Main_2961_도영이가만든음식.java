package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든음식 {
	
	private static int[] sour;
	private static int[] bitter;
	private static int N;
	int sourMul = 1;
	int bitterSum;
	private static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		sour = new int[N+1];
		bitter = new int[N+1];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		// 함수 구현 comb - bitMaskting
		for (int i =1; i<=N; i++) comb(i, 1, 1, 0);
		
		
		System.out.println(ans);
		
	}
	
	
	private static void comb(int toChoose, int startIdx, int sourMul, int bitterSum) {
		if (toChoose==0) {
//			System.out.println("신맛 곱 : " + sourMul + ", 쓴맛 합 : " + bitterSum);
			int temp = Math.abs(bitterSum-sourMul);
			ans = (temp > ans)? ans: temp;
			return;
		}
		
		for (int i = startIdx; i<=N; i++) {
			
			comb(toChoose-1, i+1, sourMul * sour[i], bitterSum + bitter[i]);
			
		}
		
		return;
		
	}
	

}
