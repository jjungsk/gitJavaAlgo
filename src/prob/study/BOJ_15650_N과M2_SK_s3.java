package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2_SK_s3 {
	
	static int N, M;
	static int[] src, choosed;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		choosed = new int[M];
		
		comb(0, 1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void comb(int cnt, int startIdx) {
		if (cnt == M) {
			for (int a: choosed) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = startIdx; i <= N; i++) {
			choosed[cnt] = i;
			comb(cnt+1, i+1);
		}
		
	}

}
