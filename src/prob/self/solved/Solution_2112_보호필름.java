package prob.self.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {
	
	static int D, W, K;
	static int[][] layer, original;
	static int[] arr, paintR;
	static boolean[] painted;
	static boolean possible;
	static int[] src = {0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			layer = new int[D][W];
			original = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					layer[i][j] = Integer.parseInt(st.nextToken());
					original[i][j] = layer[i][j];
				}
			}
			
//			for (int[] a: layer)
//				System.out.println(Arrays.toString(a));
			
			possible = false;
			painted = new boolean[D];
			paintR = new int[D];
			
			if (K==1 || doCheck()) {
				sb.append("#").append(tc).append(" ").append(0).append("\n");
//				System.out.println("#" + tc + " " + 0);
				continue;
			}
			
			int cyc = 0;
			for (int i = 1; i < K; i++) {
				cyc = i;
				arr = new int[cyc];
				recur(0, cyc);
				if (possible) break;
			}
			if (!possible) cyc = K;
			sb.append("#").append(tc).append(" ").append(cyc).append("\n");
//			System.out.println("#" + tc + " " + cyc);
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}

	private static void input(int cnt, int startIdx, int[] method) {
		
		if (cnt == method.length) {
			for (int i = 0; i < D; i++) {
				if (paintR[i]==0) continue;
				if (paintR[i] == 1) {
					for (int j = 0; j < W; j++) {
						layer[i][j] = 1;
					}
				} else {
					for (int j = 0; j < W; j++) {
						layer[i][j] = 0;
					}
				}
			}
			
//			System.out.println(cnt + " : " + Arrays.toString(method));
//			for (int[] a: layer)
//				System.out.println(Arrays.toString(a));
			
			if (doCheck()) {
				possible = true;
				return;
			}
			for (int l = 0; l < D; l++) {
				layer[l] = original[l].clone();
			}
			return;
		}
		
		
		if (method[cnt] == 0) {
			for (int j = startIdx; j < D; j++) {
				if (painted[j]) continue;
				painted[j] = true;
				paintR[j] = -1; // -1 -> 0
				input(cnt+1, j+1, method);
				if (possible) return;
				painted[j] = false;
				paintR[j] = 0;
			}
		} else {
			for (int j = startIdx; j < D; j++) {
				if (painted[j]) continue;
				painted[j] = true;
				paintR[j] = 1; // 1 -> 1
				input(cnt+1, j+1, method);
				if (possible) return;
				painted[j] = false;
				paintR[j] = 0;
			}
		}
			
		return;
	}

	private static void recur(int cnt, int target) {
		if (cnt == target) {
//			System.out.println(Arrays.toString(arr));
			input(0, 0, arr);
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			arr[cnt] = src[i];
			recur(cnt+1, target);
		}
		
	}

	private static boolean doCheck() {
		
		for (int j = 0; j < W; j++) {
			boolean flag = false;
			int cnt = 1;
			int same = layer[0][j];
			for (int i = 1; i < D; i++) {
				if (layer[i][j] == same) {
					if (++cnt >= K) {
						flag = true;
						break;
					}
				} else {
					same = layer[i][j];
					cnt = 1;
				}
			}
			if (!flag) return false;
		}
		
		return true;
	}

}
