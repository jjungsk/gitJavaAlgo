package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		StringTokenizer st;
		
		int T = 10;
		for (int tc = 1; tc < T + 1; tc++) {
			
			int n = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 8; i++)
				dq.addLast(Integer.parseInt(st.nextToken()));
					
			loop:
				while(true) {
					for (int i = 1; i < 6; i++) {
						int poll = dq.poll() - i;
						if (poll <= 0) {
							dq.addLast(0);
							break loop;
						}
						
						dq.addLast(poll);
					}
				}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 7; i++) {
				sb.append(dq.poll()).append(" ");
			}
			
			sb.append(dq.poll()).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
		
	}

}
