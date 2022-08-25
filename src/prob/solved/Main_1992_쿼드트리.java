package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while ((int)Math.pow(2, cnt)!=N) cnt++;			
		
		
		map = new int[N][N];
		for (int i = 0; i<N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j <N; j++) {
				map[i][j] = arr[j] - '0';
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		qrdTree(cnt, 0, N, 0, N);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void qrdTree(int cnt, int startR, int endR, int startC, int endC) {
		
		if (cnt == 1) {
			boolean flag = true;
			int init = map[startR][startC];
			for (int i = startR; i < endR; i++) {
				for (int j = startC; j < endC; j++) {
					if (map[i][j] != init) {
						flag = false;
					}
				}
			}
			if (flag) {
				sb.append(init);
				return;
			}
			sb.append("(").append(map[startR][startC]).append(map[startR][startC+1]).append(map[startR+1][startC]).append(map[startR+1][startC+1]).append(")");
			return;
		}
			
		int midR = (endR+startR) / 2;
		int midC = (endC+startC) / 2;
		
		
		// 모든 사분면의 숫자가 같을 경우
		boolean flag = true;
		int init = map[startR][startC];
		for (int i = startR; i < endR; i++) {
			for (int j = startC; j < endC; j++) {
				if (map[i][j] != init) {
					flag = false;
				}
			}
		}
		if (flag) {
			sb.append(init);
			return;
		}
		
		sb.append("(");
		qrdTree(cnt-1, startR, midR, startC, midC);
		qrdTree(cnt-1, startR, midR, midC, endC);
		qrdTree(cnt-1, midR, endR, startC, midC);
		qrdTree(cnt-1, midR, endR, midC, endC);
		sb.append(")");
		return;
		
//		// 1분면
//		flag = true;
//		int init1 = map[startR][startC];
//		for (int i = startR; i < midR; i++) {
//			for (int j = startC; j < midC; j++) {
//				if (map[i][j]!=init1) {
//					qrdTree(cnt-1, startR, midR, startC, midC);
//					flag = false;
//				}
//			}
//		}
////		if (flag) sb.append(init1);
//		
//		// 2분면
//		flag = true;
//		int init2 = map[startR][midC];
//		for (int i = startR; i < midR; i++) {
//			for (int j = midC; j < endC; j++) {
//				if (map[i][j]!=init2) {
//					qrdTree(cnt-1, startR, midR, midC, endC);
//					flag = false;
//				}
//			}
//		}
////		if (flag) sb.append(init2);
//		
//		// 3분면
//		flag = true;
//		int init3 = map[midR][startC];
//		for (int i = midR; i < endR; i++) {
//			for (int j = startC; j < midC; j++) {
//				if (map[i][j]!=init3) {
//					qrdTree(cnt-1, midR, endR, startC, midC);
//					flag = false;
//				}
//			}
//		}
////		if (flag) sb.append(init3);
//		
//		// 4분면
//		flag = true;
//		int init4 = map[midR][midC];
//		for (int i = midR; i < endR; i++) {
//			for (int j = midC; j < endC; j++) {
//				if (map[i][j]!=init4) {
//					qrdTree(cnt-1, midR, endR, midC, endC);
//					flag = false;
//				}
//			}
//		}
////		if (flag) sb.append(init4);
//		
//		sb.append(")");
//		return;
		
	}

}
