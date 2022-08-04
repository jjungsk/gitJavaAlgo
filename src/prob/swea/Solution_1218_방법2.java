package prob.swea;

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

public class Solution_1218_방법2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<String> dq = new ArrayDeque<String>();
		
		
//		char[] close = {')', ']', '}', '>'};
		String[] open = {"(", "[", "{", "<"};
		String[] close = {")", "]", "}", ">"};
		
		int T = 10;
		
		for (int tc = 1; tc < T+1; tc++) {
			// 입력받은 문자를 char[]로 저장
			int n = Integer.parseInt(in.readLine());
			char[] input = new char[n];
			input = in.readLine().toCharArray();
			boolean flag = true;

			// 추후 List class의 indexOf & contains 사용하기위해 arrLisr<String>() 으로 변환
			List<String> arrList = new ArrayList<String>();
			for (char ch: input)
				arrList.add((Character.toString(ch)));
			
			
			for (String str: arrList) {
				// input 값이 open 괄호 문자이면 deque에 push
				if(Arrays.asList(open).contains(str)) {
					dq.push(str);
					
				// input 값이 close 괄호 문자이면 해당 input값 close의 index를 구하여 매칭 되는 open 값 구하기
				// index로 구한 open 값과 pop한 open 값이 같다면 pop() continue <-> 그렇지 않다면 for문 break 후 0 return
				} else {
					int idx = Arrays.asList(close).indexOf(str);
					String tempS = dq.pop();
					if (!open[idx].equals(tempS)) {
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
