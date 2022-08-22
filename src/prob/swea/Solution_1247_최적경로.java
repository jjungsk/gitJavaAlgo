package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		// TODO : tc for문 필요
		for (int tc = 1; tc < T+1; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			companyPos[0] = Integer.parseInt(st.nextToken());
			companyPos[1] = Integer.parseInt(st.nextToken());
			homePos[0] = Integer.parseInt(st.nextToken());
			homePos[1] = Integer.parseInt(st.nextToken());

			customerArr = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				customerArr[i][0] = Integer.parseInt(st.nextToken());
				customerArr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[] visited = new int[N+1];
			ans = Integer.MAX_VALUE;
			getMinDistance(0, 0, companyPos, visited);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	private static int N, ans;
	private static int[] companyPos = new int[2];
	private static int[] homePos = new int[2];
	private static int[][] customerArr;
	
	private static void getMinDistance(int cnt, int distance, int[] from, int[] visited) {
		
		if (cnt == N) {
			if (ans > distance + Math.abs(from[0]-homePos[0]) + Math.abs(from[1]-homePos[1])) {
				ans = distance + Math.abs(from[0]-homePos[0]) + Math.abs(from[1]-homePos[1]);
			}
			return;
		}
		
		// 방문한곳 visited 처리
		for (int i = 1; i<=N; i++) {
			if (visited[i] == 0) {
				visited[i] = cnt+1;
				getMinDistance(cnt+1, distance + Math.abs(from[0]-customerArr[i-1][0]) + Math.abs(from[1]-customerArr[i-1][1]),
						customerArr[i-1], visited);
				visited[i] = 0;
			}
		}
		
		return;
		
	}
	
	

}
