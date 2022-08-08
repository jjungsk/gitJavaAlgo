package prob.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
//		Deque<Integer> ans = new ArrayDeque<>(); 
		Deque<Integer> inputA = new ArrayDeque<>();
		Deque<Integer> tempA = new ArrayDeque<>();
		
		int n = Integer.parseInt(in.readLine());
		
		int[] input = new int[n];
		int[] ans = new int[n];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++)
			input[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++) {
			if (input[i-1] > input[i]) {
				ans[i] = i;
			}
			else {
				int temp = i - 1;
				
				while(temp > 0) {
					int idx = ans[temp] - 1;
					if (idx >= 0 && input[idx] > input[i]) {
						ans[i] = idx + 1;
						break;
					}
					temp = idx;
					
				}
			}
		}
		
		for (int i: ans)
			sb.append(i).append(" ");
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}

}
