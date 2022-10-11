package ssafy.sup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	
	static int T;
	static int pday, pmonth, p3month, pyear;
	static int[] plan;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			pday = Integer.parseInt(st.nextToken());
			pmonth = Integer.parseInt(st.nextToken());
			p3month = Integer.parseInt(st.nextToken());
			pyear = Integer.parseInt(st.nextToken());
			
			plan = new int[12];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			min = pyear;
			
			pay(0, 0);
			
			System.out.println("#t : " + t );
			
			
		}
		
		
	}
	
	
	// dfs -> 재귀 -> while
	private static void pay(int imonth, int w) {
		
		// 재귀 종료 조건
		if (imonth > 11) {
			min = Math.min(min,  w);
			return;
		}
		
		// 1일
		pay(imonth+1, w+plan[imonth]*pday);
		
		// 1개월
		pay(imonth+1, w+pmonth);
		
		// 3개월
		pay(imonth+3, w+p3month);
		
		
		
		
		
		
	}

}
