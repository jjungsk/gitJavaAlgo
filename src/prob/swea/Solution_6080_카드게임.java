package prob.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6080_카드게임 {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			winG = 0;
			
			int[] arrG = new int[9];
			int[] arrI = new int[9];
			boolean[] vistied = new boolean[9];
			boolean[] visitedG = new boolean[19];
			int toChoose = 9;
			int sumG = 0;
			int sumI = 0;
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				int temp = Integer.parseInt(st.nextToken());
				arrG[i] = temp;
				visitedG[temp] = true;
			}
			
			for (int i = 1, idx = 0; i < 19; i++) {
				if (!visitedG[i])
					arrI[idx++] = i; 
			}
			
			makePermutation(toChoose, arrG, arrI, vistied, sumG, sumI);
			
			sb.append("#").append(tc).append(" ").append(winG).append(" ").append(362_880-winG).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int idxG = 0;
	private static int winG = 0;
	
	private static void makePermutation(int toChoose, int[] arrG, int[] arrI, boolean[] visited, int sumG, int sumI) {
		
		if (toChoose == 0) {
			if (sumG > sumI)
				winG++;
			return;
		}
		
		for (int i = 0; i < 9; i++)
			if (!visited[i]) {
				visited[i] = true;
				if (arrG[9-toChoose] > arrI[i]) {
//					sumG += arrG[9-toChoose] + arrI[i];
					makePermutation(toChoose - 1, arrG, arrI, visited, sumG + arrG[9-toChoose] + arrI[i], sumI);
				}
				else {
//					sumI += arrG[9-toChoose] + arrI[i];
					makePermutation(toChoose - 1, arrG, arrI, visited, sumG, sumI + arrG[9-toChoose] + arrI[i]);
				}
//				makePermutation(toChoose - 1, arrG, arrI, visited, sumG, sumI);
				visited[i] = false;
				
			}
		
		
	}
	
}
