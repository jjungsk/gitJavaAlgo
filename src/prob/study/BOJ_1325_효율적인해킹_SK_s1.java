package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인해킹_SK_s1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N 개
		int M = Integer.parseInt(st.nextToken()); // M 관계
		int[] arr = new int[N+1];
		
		List<Integer>[] nodes = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		int to = 0, from = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			to = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			nodes[from].add(to);
		}
		
		int maxV = 0;
		boolean[] visited;
		Deque<Integer> dq;
		for (int i = 1; i <= N; i++) {
//			if (nodes[i].size()==0) continue;
			visited = new boolean[N+1];
			dq = new ArrayDeque<>();
			dq.add(i);
			visited[i] = true;
			
			int deep = 0;
			int cur = 0;
			
			while (!dq.isEmpty()) {
				cur = dq.poll();
				
				for (int k: nodes[cur]) {
					if (visited[k]) continue;
					dq.add(k);
					visited[k] = true;
					deep++;
				}
			}
			arr[i] = deep;
			maxV = (maxV > deep)? maxV: deep;
		}
		
		for (int i = 1; i <= N; i++) {
			if (maxV > arr[i]) continue;
			sb.append(i).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
