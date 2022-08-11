package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while ((int)Math.pow(2, cnt) * N < K) {
			cnt++;
		}
//		System.out.println(cnt); // 2
		
		int size = (int) Math.pow(2, cnt+1) * N; // 5 * 2^2 = 20
		
		int[] arr = new int[size + 1];
		int[] number = new int[size+1];
		for (int i = 0; i < size + 1; i++) {
			arr[i] = -1;
			number[i] = i;
		}
		
		if (K > N) {
			// N ~ 2N 초기화
			for (int i = N; i < 3 * N / 2 + 1; i++) {
				arr[i] = i - N;
			}
			for (int i = 2*N; i >= 3 * N / 2 + 1; i--)
				arr[i] = 2 * N - i;
			for (int i = N; i >= N / 2 + 1; i--) {
				arr[i] = N - i;
				if (arr[2*i] > N - i)
					arr[2*i] = N - i;
			}
			
//			System.out.println(Arrays.toString(number));
			cnt--;
			int k = 2;
			while (cnt != 0) {
				// 2N ~ 4N 값 일치화
				for (int i = N*k; i <= 2*N*k; i++) {
					arr[i] = arr[i/2];
				}
				
				for (int i = N*k; i < 2*N*k; i++) {
					if (i % 2 == 1) {
						if (arr[i-1] < arr[i+1])
							arr[i] = arr[i-1] + 1;
						else
							arr[i] = arr[i+1] + 1;
					}
				}
				cnt--;
				k *= 2;
			}
			
			System.out.println(Arrays.toString(arr));
			System.out.println(arr[K]);
		} else
			System.out.println(N-K);
	}

}
