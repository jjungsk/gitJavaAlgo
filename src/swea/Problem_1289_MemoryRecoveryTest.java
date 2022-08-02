package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1289_MemoryRecoveryTest  {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 int T = Integer.parseInt(in.readLine());
		 
		 for (int tc = 1; tc < T + 1; tc++) {
//			 sb = new StringBuilder();
			 sb.append("#").append(tc);
			 
			 // 최소 수정 횟수
			 int cnt = 0;
			 char temp = '0';
			 
			 // 입력값을 toCharArray 형태로 변환
			 char[] memo = in.readLine().toCharArray();
			 
			 // 초기값 부터 1과 0의 변경 횟수를 구함
			 for (int i = 0; i < memo.length; i++) {
				 if (memo[i] != temp) {
					 cnt++;
					 temp = (temp == '0')? '1': '0'; 
				 }
			 }
			 
			 sb.append(" ").append(cnt).append("");
		 }
		 System.out.println(sb.toString());
	}

}
