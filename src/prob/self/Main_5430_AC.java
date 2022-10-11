package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_5430_AC {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
				
		for (int tc = 1; tc <= T; tc++) {
			
			char[] command = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			
			char[] temp = br.readLine().toCharArray();
			
			String str = "";
			for (int i = 1; i < temp.length-1; i++) {
				str += temp[i];
			}
			
			st = new StringTokenizer(str, ",");
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			int cntD = 0;
			for (int i = 0; i < command.length; i++) {
				if (command[i] == 'D') ++cntD;
			}
			if (cntD > arr.length || arr.length == 0) {
				sb.append("error\n");
				continue;
			}
			if (arr.length==cntD) {
				sb.append("[]\n");
				continue;
			}
			
			for (char com: command) {
				int len = arr.length;
				if (com == 'R') {
					Deque<Integer> dq = new ArrayDeque<>();
					while (len!=0) {
						dq.addFirst(arr[--len]);
					}
					while (!dq.isEmpty()) {
						arr[len++] = dq.pollLast();
					}
				} else {
					arr = Arrays.copyOfRange(arr, 1, len);
				}
			}
			
			sb.append("[");
			
			for (int i = 0; i < arr.length-1; i++) {
				sb.append(arr[i]).append(",");
			}
			sb.append(arr[arr.length-1]).append("]").append("\n");
					 
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
