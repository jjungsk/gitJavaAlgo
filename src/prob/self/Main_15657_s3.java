package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_s3 {
	
	static int N, R;
	static int[] src, choosed;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		choosed = new int[R];
		src = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(src);
		
		duComb(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void duComb(int cnt, int startIdx) {
		if (cnt == R) {
			for (int a: choosed)
				sb.append(a).append(" ");
			sb.append("\n");
			
			return;
		}
		
		for (int i = startIdx; i < N; i++) {
			choosed[cnt] = src[i];
			duComb(cnt+1, i);
		}
		
	}

}
