package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1218_괄호짝짓기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<Character> dq = new ArrayDeque<>();
		
		// TODO : Tc for문 작성 필요
		int T = 10;
		for(int tc = 1; tc < T+1; tc++) {
			char[] close = {')', ']', '}', '>'};
			int n = Integer.parseInt(in.readLine());
			char[] input = new char[n];
			input = in.readLine().toCharArray();
			boolean flag = true;
			
			
			for (int i = 0; i < n; i++) {
				char tempC = input[i];
				if (tempC == '(' || tempC == '[' || tempC == '{' || tempC == '<')
					dq.push(tempC);
				else {
					char pop = dq.pop();
					int temp = 0;
					switch(pop) {
					case '(':
						temp = 0;
						break;
					case '[':
						temp = 1;
						break;
					case '{':
						temp = 2;
						break;
					case '<':
						temp = 3;
						break;
					}
					if (tempC != close[temp]) {
						flag = false;
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			if (flag)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
		
	}

}
