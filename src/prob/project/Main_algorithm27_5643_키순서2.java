package prob.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main_algorithm27_5643_키순서2 {
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine()); // 학생 수 N명
			int M = Integer.parseInt(br.readLine()); // 학생 키 관계
			
			parents = new int[N+1];
			for (int i = 1; i<= N; i++) parents[i] = i;
			for (int i = 1; i<= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int child = Integer.parseInt(st.nextToken());
				int parent = Integer.parseInt(st.nextToken());
				union(parent, child);
			}
			
			System.out.println(Arrays.toString(parents));
			
			// main logic
			
			
		
//			int ans = 0;
//			
//			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		} // 모든 tc 종료문
		
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
		
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[b] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}


}
