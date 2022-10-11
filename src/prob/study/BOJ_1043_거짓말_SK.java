package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말_SK {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 인원
		int M = Integer.parseInt(st.nextToken()); // 파티 갯수
		
		boolean[] truth = new boolean[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		int truthNo = Integer.parseInt(st.nextToken());
		for (int i = 0; i < truthNo; i++) {
			truth[Integer.parseInt(st.nextToken())] = true;
		}
		
		int[][] party = new int[M+1][];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int no = Integer.parseInt(st.nextToken());
			party[i] = new int[no];
			for (int j = 0; j < no; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// (1) truth로 만들기 -> 한명이라도 truth에 포함이 된다면
		int cnt = 0;
		int change = 0;
		for (int i = 1; i <=N; i++) {
			if (!truth[i]) continue;
			++cnt;
		}
		while (cnt!=change) {
			change = cnt;
			cnt = 0;
			for (int i = 1; i<=M; i++) {
				for (int person: party[i]) {
					if (!truth[person]) continue;
					
					for (int tr: party[i]) truth[tr] = true;
				}
			}
			for (int i = 1; i <=N; i++) {
				if (!truth[i]) continue;
				++cnt;
			}
		}
		
		// (2) truth가 없는 모임 찾기
		int imp = 0;
		for (int i = 1; i <= M; i++) {
			for (int person: party[i]) {
				if (truth[person]) {
					++imp;
					break;
				}
			}
		}
		
		System.out.println(M-imp);
	}
	

}
