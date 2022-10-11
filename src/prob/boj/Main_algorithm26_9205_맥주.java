package prob.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_algorithm26_9205_맥주 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] home = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			
			int[][] conv = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				conv[i][0] = Integer.parseInt(st.nextToken());
				conv[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] dest = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			
			Deque<int[]> dq = new ArrayDeque<>();
			dq.addFirst(home);
			
			boolean[] visited = new boolean[n];
			boolean flag = false;
			while (!dq.isEmpty()) {
				int[] curP = dq.pollFirst();
				
				if (Math.abs(curP[0]-dest[0])+Math.abs(curP[1]-dest[1])<=1000) {
					flag = true;
					break;
				}
				
				for (int i = 0; i < n; i++) {
					if (curP[0]==conv[i][0] && curP[1]==conv[i][1]) {
						visited[i] = true;
						break;
					}
				}
				
				for (int i = 0; i < n; i++) {
					if (visited[i] || (Math.abs(curP[0]-conv[i][0])+Math.abs(curP[1]-conv[i][1])>1000)) continue;
					
					dq.addFirst(conv[i]);
				}
				
			}
			
			if (flag) sb.append("happy").append("\n");
			else sb.append("sad").append("\n");
			
		} // 모든 tc 종료 문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
