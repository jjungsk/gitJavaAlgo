package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc < T + 1; tc++) {
			
			int arrSize = Integer.parseInt(in.readLine());
			
			int[][] map = new int[arrSize+2][arrSize+2];
			boolean[][] visited = new boolean[arrSize+2][arrSize+2]; // 방문 boolean
			
			// 0으로 둘러싼 arrSize+2 2차원 배열 만들기
			for (int i = 1; i <= arrSize; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j <= arrSize; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 상하좌우
			int[] di = {-1, 1, 0, 0};
			int[] dj = {0, 0, -1, 1};
			
			// 결과값 저장
			int ans = 1;
			int ansI = 0;
			int ansJ = 0;
			map[0][0] = (int) Math.pow(arrSize, 2) + 1;
			
			for (int i = 1; i <= arrSize; i++) {
				for (int j = 1; j <= arrSize; j++) {
					int tempI = i;
					int tempJ = j;
					int cnt = 1;
					boolean flag = true;
					if (!visited[i][j]) {
						visited[i][j] = true;
						
						// 4방 탐색 중 내 방보다 1 큰 방이 있을때 지속 탐색
						while(flag) {
							flag = false;
							int mi = 0;
							int mj = 0;
							// 4방 탐색
							for (int k = 0; k < 4; k++) {
								mi = tempI + di[k];
								mj = tempJ + dj[k];
								// 4방 탐색 중 내 방보다 1 큰 방이 있을때 지속 탐색
								if (map[mi][mj] == map[tempI][tempJ] + 1) {
									visited[mi][mj] = true;
									flag = true;
									cnt++;
									break;
								}
							}
							
							tempI = mi;
							tempJ = mj;
						} // while문 : 1보다 큰 숫자 지속 탐색
						
						if (cnt > ans) {
							ans = cnt;
							ansI = i;
							ansJ = j;
						} else if (cnt == ans && map[ansI][ansJ] > map[i][j]) {
							ansI = i;
							ansJ = j;
						}
					}
					
				} // j - for문
			}
			
			sb.append("#").append(tc).append(" ").append(map[ansI][ansJ]).append(" ").append(ans).append("\n");
			
		} // TestCase for문
		
		out.write(sb.toString());
		out.flush();
		out.close();
		
	}

}
