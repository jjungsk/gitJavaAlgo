package prob.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7465_창용마을_kruskal {
	
	private static int N, M;
	private static int[] parents;
	private static int[][] nodes;
	
	
	// kuskal algorithm -> void make() : parents가 본인 자신으로 초기화 -> int find(int a) -> boolean union(int a, int b)
	private static void make() {
		parents = new int[N+1];
		
		for (int i = 1; i<=N; i++)
			parents[i] = i;
	}
	
	private static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		
		parents[bRoot] = aRoot;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			make();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
//				nodes[i][0] = Integer.parseInt(st.nextToken());
//				nodes[i][1] = Integer.parseInt(st.nextToken());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Set<Integer> hset = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				hset.add(find(i));
			}
			
			sb.append("#").append(tc).append(" ").append(hset.size()).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
