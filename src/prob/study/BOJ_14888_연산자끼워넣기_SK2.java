package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기_SK2 {
	
	static int N, M, tot;
	static int maxA, minA;
	static int[] numbers, cal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 숫자 갯수
		M = N-1; // 연산자 갯수
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		cal = new int[4];
		int idx = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Arrays.toString(cal));
		
		tot = 0;
		maxA = Integer.MIN_VALUE;
		minA = Integer.MAX_VALUE;
		
		rec(0, numbers[0]);
		System.out.println(tot);
		
		sb.append(maxA).append("\n").append(minA);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void rec(int cnt, int ans) {
		if (cnt == M) {
			maxA = (maxA > ans)? maxA: ans;
			minA = (ans > minA)? minA: ans;
			tot++;
			return;
		}
		
		if (cal[0] != 0) {
			cal[0]--;
			rec(cnt+1, ans + numbers[cnt+1]);
			cal[0]++;
		}
		if (cal[1] != 0) {
			cal[1]--;
			rec(cnt+1, ans - numbers[cnt+1]);
			cal[1]++;
		}
		if (cal[2] != 0) {
			cal[2]--;
			rec(cnt+1, ans * numbers[cnt+1]);
			cal[2]++;
		}
		if (cal[3] != 0) {
			cal[3]--;
			if (ans > 0) {
				rec(cnt+1, ans / numbers[cnt+1]);
			} else {
				rec(cnt+1, (-1*ans) / numbers[cnt+1] * -1);
			}
			cal[3]++;
		}
		
	}

	

}
