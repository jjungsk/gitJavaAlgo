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

public class BOJ_14888_연산자끼워넣기_SK {
	
	static int N, M, tot;
	static int maxA, minA;
	static int[] numbers, cal;
	static boolean[] visited;
	static Map<Integer, Integer> map;
	static int[] orders;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 숫자 갯수
		M = N-1; // 연산자 갯수
		numbers = new int[N];
		visited = new boolean[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		cal = new int[M];
		orders = new int[M];
		map = new HashMap<>();
		int idx = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			int calCnt = Integer.parseInt(st.nextToken());
			if (calCnt == 0) continue;
			for (int j = 0; j < calCnt; j++) {
				cal[idx++] = i;
			}
			map.put(i, calCnt);
		}
		
		tot = 0;
		maxA = Integer.MIN_VALUE;
		minA = Integer.MAX_VALUE;
		perm(0);
		sb.append(maxA).append("\n").append(minA);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			int ans = numbers[0];
			for (int i = 0; i < M; i++) {
				if (orders[i] == 0) {
					ans = ans + numbers[i+1];
				} else if (orders[i] == 1) {
					ans = ans - numbers[i+1];
				} else if (orders[i] == 2) {
					ans = ans * numbers[i+1];
				} else if (orders[i] == 3) {
					if (ans >= 0) ans = ans / numbers[i+1];
					else {
						ans = -1*(-1*ans / numbers[i+1]);
					}
				}
			}
			maxA = (maxA > ans)? maxA: ans;
			minA = (ans > minA)? minA: ans;
			return;
		}
		
		for (int i = 0; i < M; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			orders[cnt] = cal[i];
			perm(cnt+1);
			visited[i] = false;
			
		}
		
	}

	

}
