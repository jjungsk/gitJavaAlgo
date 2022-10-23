package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임_SK_g5_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[101];
		
		int[] move = new int[101]; // 사다리 or 뱀을 타고 이동 하는 위치
		int tot = N+M;
		for (int i = 0; i < tot; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()); 
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		
		// bfs
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			
			int nextP = 0;
			for (int i = 1; i <= 6; i++) {
				nextP = cur + i;
				
				if (nextP > 100) continue;
				
				if (move[nextP] != 0) {
					if (dist[move[nextP]] == 0 || dist[move[nextP]] > dist[cur] + 1) {
						dist[nextP] = dist[cur] + 1;
						dist[move[nextP]] = dist[cur] + 1;
						dq.add(move[nextP]);
					}
				} else {
					if (dist[nextP] == 0 || dist[nextP] > dist[cur] + 1) {
						dist[nextP] = dist[cur] + 1;
						dq.add(move[nextP]);
					}
				}
			}
		}
		
		for (int i = 1; i <= 20; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
		
		System.out.println(dist[99]);
		
		
		
		
	}
}
