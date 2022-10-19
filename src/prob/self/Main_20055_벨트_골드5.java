package prob.self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20055_벨트_골드5 {
	
	static int N, K;
	static int[] arrC, arrR;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		arrR = new int[2*N+1];
		arrC = new int[2*N+1];
		for (int i = 1; i <= 2*N; i++) {
			arrC[i] = Integer.parseInt(st.nextToken());
			arrR[i] = arrC[i];
		}
		
		
		rotate();
//		System.out.println(Arrays.toString(arrR));
		mvRobort();
//		setRobort();
//		boolean flag = checkDurability();
		
	}

	private static void mvRobort() {
		int toFirstR = arrR[2*N];
		for (int i = 2*N; i >= 1; i--) {
			if (arrC[i] == 0 || arrR[i] != 0) continue;
			arrR[i] = arrR[i-1];
			--arrC[i]; // 내구도 감소
		}
		arrR[1] = toFirstR;
		arrR[N+1] = arrR[N];
		arrR[N] = 0;
		
	}

	private static void rotate() {
		int toFirstC = arrC[2*N];
		for (int i = 2*N; i >= 1; i--) {
			arrC[i] = arrC[i-1];
		}
		arrC[1] = toFirstC;
		
		int toFirstR = arrR[2*N];
		for (int i = 2*N; i >= 1; i--) {
			arrR[i] = arrR[i-1];
		}
		arrR[1] = toFirstR;
		arrR[N+1] = arrR[N];
		arrR[N] = 0;
	}

}
