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

public class Main_algorithm27_5643_키순서 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine()); // 학생 수 N명
			int M = Integer.parseInt(br.readLine()); // 학생 키 관계
			
			List[][] list = new ArrayList[N+1][2];
			for (int i = 0; i<= N; i++) {
				list[i][0] = new ArrayList<Integer>(); // child
				list[i][1] = new ArrayList<Integer>(); // parent
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int child = Integer.parseInt(st.nextToken());
				int parent = Integer.parseInt(st.nextToken());
				list[child][1].add(parent);
				list[parent][0].add(child);
			}
			
			
			// main logic
			for (int i = 1; i <= N; i++) {
				Deque<Integer> child = new ArrayDeque<>();
				Deque<Integer> parent = new ArrayDeque<>();
				
				for (int k = 0; k < list[i][0].size(); k++) {
					child.addFirst((Integer)list[i][0].get(k));
				}
				for (int k = 0; k < list[i][1].size(); k++) {
					parent.addFirst((Integer)list[i][1].get(k));
				}
				
				while (!child.isEmpty()) {
					int curC = child.pollFirst();
					
					if (list[curC][0].size()==0) continue;
					for (int c = 0; c < list[curC][0].size(); c++) {
						if (!list[i][0].contains(list[curC][0].get(c))) {
							child.addFirst((Integer)list[curC][0].get(c));
							list[i][0].add(list[curC][0].get(c));
						}
					}
				}
				while (!parent.isEmpty()) {
					int curP = parent.pollFirst();
					
					if (list[curP][1].size()==0) continue;
					for (int c = 0; c < list[curP][1].size(); c++) {
						if (!list[i][1].contains(list[curP][1].get(c))) {
							parent.addFirst((Integer)list[curP][1].get(c));
							list[i][1].add(list[curP][1].get(c));
						}
					}
				}
				
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				System.out.println(list[i][0] + " : " + list[i][1]);
				if (list[i][0].size() + list[i][1].size() == N-1) ++ans;
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		} // 모든 tc 종료문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
