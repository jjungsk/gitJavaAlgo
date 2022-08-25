package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_1541_괄호 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> dqC = new ArrayDeque<>();
		Deque<String> dqS = new ArrayDeque<>();
		
		String str = br.readLine();
		
		int len = str.length();
		char[] arr = new char[len];
		
		arr = str.toCharArray();
		
		for (int i = 0; i<len; i++) {
			
			dqC.add(arr[i]);
			int num = arr[i] - '0';
			// '-', '+' 를 만나면
			if (num == -3 || num == -5) {
				String temp = "";
				while(dqC.size() != 1) {
					temp += dqC.poll();
				}
				dqS.add(temp);
				dqS.add(Character.toString(dqC.poll()));
				continue;
			}			
			
			if (i == len-1) {
				String temp = "";
				while(!dqC.isEmpty()) {
					temp += dqC.poll();
				}
				dqS.add(temp);
			}
			
		}
		
//		System.out.println(dqS);
		
		int sum = 0;
		boolean minus = false;
		for (String st: dqS) {
			if (st.equals("-")) { // "-" 일때
				minus = true;
				continue;
			} else if (st.equals("+")) { // "+" 일때
				continue;
			} else {
				int num = Integer.parseInt(st);
				if (minus) {
					sum -= num;
				} else {
					sum += num;
				}
			}
		} // for문 종료
		
		System.out.println(sum);
		
	}

}
