package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken()); // 암호 길이
		int C = Integer.parseInt(st.nextToken()); // 총 알파벳 수
		
		arr = new char[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		System.out.println(Arrays.toString(arr));
		choosed = new char[L];
		bowl = new char[]{'a', 'e', 'i', 'o', 'u'};
		
		comb(0, 0);
		
	}
	
	private static int L, C;
	private static char[] arr, choosed, bowl;
	
	private static void comb(int cnt, int startIdx) {
		
		if (cnt == L) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int i = startIdx; i < L; i++) {
			choosed[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
		
	}

}
