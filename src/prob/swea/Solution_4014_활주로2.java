package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4014_활주로2 {
	
	private static int N, X;
	private static int[][] map, map2;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // map 크기
			X = Integer.parseInt(st.nextToken()); // 경사 가로 길이
			
			map = new int[N][N];
			map2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// main logic
		
			int ans = process();

			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		} // 모든 tc 종료문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	private static int process() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (makeRoad(map[i])) cnt++;
			if (makeRoad(map2[i])) cnt++;
		}
		
		return cnt;
	}
	
	// 해당 지형 정보로 활주로 건설이 가능하다면 true, 그렇지 않다면 false 리턴
	private static boolean makeRoad(int[] road) {
		
		int beforeHeight = road[0], size = 0;
		int j = 0;
		
		while (j < N) {
			
			if (beforeHeight == road[j]) { // 동일 높이
				size++;
				j++;
			} else if (beforeHeight+1 == road[j]) { // 이전높이 보다 1 높음 : 오르막 경사로 설치 체크
				if (size < X) return false; // X 길이 미만이면 활주로 건설 불가
				
				beforeHeight++;
				size = 1;
				j++;
				
			} else if (beforeHeight-1 == road[j]) { // 이전 높이보다 1 작음
				int count = 0;
				for (int k = j; k < N; k++) {
					if (road[k] != beforeHeight-1) return false;
					
					if (++count == X) {
						beforeHeight--;
						j += X;
						size = 0;
						break;
					}
				}
				
			} else { // 높이가 2 이상의 차이
				return false;
			}
			
		}
		
		
		return true;
	}

}
