package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기_SK {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			int[][] conv = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				conv[i][0] = Integer.parseInt(st.nextToken());
				conv[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			boolean[] visited = new boolean[n];
			Deque<int[]> dq = new ArrayDeque<>();
			dq.add(start);
			
			boolean goFes = false;
			while (!dq.isEmpty()) {
				int[] cur = dq.poll();
				
				if (Math.abs(cur[0]-end[0]) + Math.abs(cur[1]-end[1]) <= 1000) {
					sb.append("happy").append("\n");
					goFes = true;
					break;
				}
				
				for (int i = 0; i < n; i++) {
					if (visited[i]) continue;
					if (Math.abs(cur[0]-conv[i][0]) + Math.abs(cur[1]-conv[i][1]) <= 1000) {
						dq.add(conv[i]);
						visited[i] = true;
					}
				}
				
			} // while문 종료
			
			if(!goFes) sb.append("sad").append("\n");
			
		} // 모든 tc문 종료
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
