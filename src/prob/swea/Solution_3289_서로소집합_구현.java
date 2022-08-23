package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_구현 {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int number = Integer.parseInt(st.nextToken());
			int calculation = Integer.parseInt(st.nextToken());
			
			int[][] calArr = new int[calculation][3];
			for (int i = 0; i < calculation; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				calArr[i][0] = Integer.parseInt(st.nextToken());
				calArr[i][1] = Integer.parseInt(st.nextToken());
				calArr[i][2] = Integer.parseInt(st.nextToken());
			}
			
			// 구현부
			

			sb.append("#").append(tc).append(" ");
			
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}
