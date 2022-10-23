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

public class BOJ_11725_트리의부모찾기_SK_s2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] parents = new int[N+1];

		List<Integer>[] nodes = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].add(b);
			nodes[b].add(a);
		}
		
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		parents[1] = 1;
		
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			
			for (int i = 0; i < nodes[cur].size(); i++) {
				if (parents[nodes[cur].get(i)]!=0) continue;
				dq.add(nodes[cur].get(i));
				parents[nodes[cur].get(i)] = cur;
			}
		}
		
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
