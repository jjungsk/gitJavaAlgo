package prob.self.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_5430_AC2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
			
		loop:
		for (int tc = 1; tc <= T; tc++) {
			
//			char[] command = br.readLine().toCharArray();
			String command = br.readLine();
			double n = Integer.parseInt(br.readLine());
			
			Deque<Integer> dq = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine(), "[],"); // * 중요
			for (double i = 0; i < n; i++) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}
			
			
			boolean right = true;
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'R') {
					right = !right;
				} else {
					if (right) {
						if (dq.pollFirst() == null) {
							sb.append("error\n");
							continue loop;
						}
					} else {
						if (dq.pollLast() == null) {
							sb.append("error\n");
							continue loop;
						}
					}
				}
			}
			
			sb.append("[");
			
			if (dq.size() > 0) {
				
				if (right) {
					sb.append(dq.pollFirst());
					while (!dq.isEmpty()) {
						sb.append(",").append(dq.pollFirst());
					}
				} else {
					sb.append(dq.pollLast());
					while (!dq.isEmpty()) {
						sb.append(",").append(dq.pollLast());
					}
				}
			}
			sb.append("]").append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
