package prob.project;

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

public class Solution_algorithm16_1238_contact {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		
		for (int tc = 1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			nodes = new int[N/2][2];
			for (int i = 0; i < N/2; i++) {
				nodes[i][0] = Integer.parseInt(st.nextToken());
				nodes[i][1] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[101];
			depth = 0;
			maxDepth = 0;
			bfs();
			System.out.println(maxDepth);
			int ans = 0;
			for (int[] a: ansList) {
				if (a[0] == maxDepth)
					ans = Math.max(ans, a[1]);
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	private static int start, depth, maxDepth;
	private static int[][] nodes;
	private static boolean[] visited;
	private static List<int[]> ansList;
	
	private static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		ansList = new ArrayList<>();
		
		dq.offer(new int[] {start, depth});
		visited[start] = true;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			for (int[] node: nodes) {
				if (cur[0] == node[0] && !visited[node[1]]) {
					visited[node[1]] = true; 
					dq.offer(new int[] {node[1], cur[1] + 1});
					ansList.add(new int[] {cur[1] + 1, node[1]});
					maxDepth = Math.max(maxDepth, cur[1] + 1);
				}
			}
		}
		
		
	}

}
