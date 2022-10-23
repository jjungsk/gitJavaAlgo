package prob.self.d1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			long remain = arr[i] - B;
			cnt++;
			if (remain > 0) {
				if (remain % C == 0) cnt += remain/C;
				else cnt += remain / C + 1;
			}
		}
		System.out.println(cnt);
		
	}

}
