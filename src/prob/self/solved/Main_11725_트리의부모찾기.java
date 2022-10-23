package prob.self.solved;

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

public class Main_11725_트리의부모찾기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] parents = new int[n+1];
		parents[1] = 1;
		
		List<Integer>[] list = new ArrayList[n+1];
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[p].add(c);
			list[c].add(p);
		}
		
		boolean[] visited = new boolean[n+1];
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		visited[1] = true;
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			
			for (int i = 0; i < list[cur].size(); i++) {
				if (visited[list[cur].get(i)]) continue;
				dq.add(list[cur].get(i));
				parents[list[cur].get(i)] = cur;
				visited[list[cur].get(i)] = true;
			}
		}
		
		for (int i = 2; i <= n; i++)
			sb.append(parents[i]).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
