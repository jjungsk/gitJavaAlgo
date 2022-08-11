package prob.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_1233_사칙유효성검사 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Map<Integer, Character> hm = new HashMap<>();
		
		int T = 10;
		
		boolean flag = true;
		

		for (int tc = 1; tc < T + 1; tc++) {
			int N = Integer.parseInt(in.readLine()) + 1;
			int[][] arr = new int[N][2];
			
			flag = true;
			
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int cnt = st.countTokens();
				if (cnt == 4) {
					int idx = Integer.parseInt(st.nextToken());
					char order = st.nextToken().charAt(0);
					arr[i][0] = Integer.parseInt(st.nextToken());
					arr[i][1] = Integer.parseInt(st.nextToken());
					hm.put(idx, order);
				} else if (cnt == 2) {
					int idx = Integer.parseInt(st.nextToken());
					char order = st.nextToken().charAt(0);
					hm.put(idx, order);
				}
				
			}
			
			
			if (flag) {
				for (int i = N-1; i >= 1; i--) {
					// 숫자면 밑에 수가 없어야 함
					if (arr[i][0] == 0 && arr[i][1] == 0) {
						if (hm.get(i) - '0' >= 0 && hm.get(i) - '0' <= 9) {
							continue;
						} else {
							flag = false;
							break;
						}
					} else {
						if (hm.get(arr[i][0]) - '0' >= 0 && hm.get(arr[i][0]) - '0' <= 9 
								&& hm.get(arr[i][1]) - '0' >= 0 && hm.get(arr[i][1]) - '0' <= 9) {
							hm.put(i, '1');
						} else {
							flag = false;
							break;
						}
					}
					
				}
			}
			
			sb.append("#").append(tc).append(" ");
			if (flag)
				sb.append(1).append("\n");
			else sb.append(0).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		
	}

}
