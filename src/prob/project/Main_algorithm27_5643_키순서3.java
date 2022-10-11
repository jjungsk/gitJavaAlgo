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

public class Main_algorithm27_5643_키순서3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine()); // 학생 수 N명
			int M = Integer.parseInt(br.readLine()); // 학생 키 관계
			
			List[] childList = new ArrayList[N+1];
			List[] parentList = new ArrayList[N+1];
			for (int i = 1; i<= N; i++) {
				childList[i] = new ArrayList<Integer>(); // child
				parentList[i] = new ArrayList<Integer>(); // parent
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int child = Integer.parseInt(st.nextToken());
				int parent = Integer.parseInt(st.nextToken());
				childList[parent].add(child);
				parentList[child].add(parent);
			}
			
			
			
			// main logic
			int ans = 0;
			int[] known = new int[N+1];
			for (int i = 1; i <= N; i++) {
				if(childList[i].isEmpty()) continue;
				
				int temp = 0;
				boolean[] visited = new boolean[N+1];
				Deque<Integer> dq = new ArrayDeque<>();
				for (int k = 0; k < childList[i].size(); k++) {
					dq.addFirst((Integer)childList[i].get(k));
				}
				
				while (!dq.isEmpty()) {
					int cur = dq.pollFirst();
					if (visited[cur]) continue;
					if (childList[cur].isEmpty()) {
						temp++;
						visited[cur] = true;
						continue;
					}
					
					visited[cur] = true;
					temp++;
					
					for (int k = 0; k < childList[cur].size(); k++) {
						dq.addFirst((Integer)childList[cur].get(k));
					}
				}
				known[i] = temp;
			}
			
			for (int i = 1; i <= N; i++) {
				if(parentList[i].isEmpty()) continue;
				
				int temp = 0;
				boolean[] visited = new boolean[N+1];
				Deque<Integer> dq = new ArrayDeque<>();
				for (int k = 0; k < parentList[i].size(); k++) {
					dq.addFirst((Integer)parentList[i].get(k));
				}
				
				while (!dq.isEmpty()) {
					int cur = dq.pollFirst();
					if (visited[cur]) continue;
					if (parentList[cur].isEmpty()) {
						temp++;
						visited[cur] = true;
						continue;
					}
					
					visited[cur] = true;
					temp++;
					
					for (int k = 0; k < parentList[cur].size(); k++) {
						dq.addFirst((Integer)parentList[cur].get(k));
					}
				}
				known[i] += temp;
				
			}
			for (int i = 1; i <= N; i++) {
				if (known[i] == N-1) ++ans;
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		} // 모든 tc 종료문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
