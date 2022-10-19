package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15650_NM2_SK_s3 {
	
	private static int N, M;
	private static int[] src;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		for (int i = 0; i < N; i++) {
			src[i] = i+1;
		}
		
		int[] choosed = new int[M];
		comb(0, 0, choosed);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void comb(int cnt, int startIdx, int[] toChoosed) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(toChoosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = startIdx; i < N; i++) {
			toChoosed[cnt] = src[i];
			comb(cnt+1, i+1, toChoosed);
		}
		
	}

}
