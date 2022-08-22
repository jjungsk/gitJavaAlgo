package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	
	static int N, M;
	static List<int[]> posCC;
	static int[] cntD;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		posCC = new ArrayList<>();
		
		//
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // row 열
		M = Integer.parseInt(st.nextToken()); // col 행
		
		map = new int[N+2][M+2]; // map arr
		
		// map 위치 저장
		for (int i = 1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j<M+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 감시카메라 위치 저장
		posCC = new ArrayList<>();
		for (int i = 0; i<N+2; i++) {
			for (int j = 0; j < M+2; j++) {
				// 6으로 벽 둘러 쌓기
				if (i==0||i==N+1||j==0||j==M+1)
					map[i][j] = 6;
				
				// 1~5 cctv 위치 정하기
				if (1<=map[i][j] && map[i][j]<=5) {
					int[] temp = {map[i][j], i, j};
					posCC.add(temp);
				}
			}
		}
		
		
		// 5>4>3>2>1 순으로 카메라 sort (생략 가능한지 확인 필요)
		Collections.sort(posCC, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0]-o1[0];
			}
		});
		
		
		for (int[] a: posCC) setMap(a);
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				if (map[i][j] == 0) ans++;						
		}
		
		System.out.println(ans);
		
		// 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(map[i][j] + " ");						
			}
			System.out.println();
		}
		
		for (int[] a: posCC)
			System.out.println(Arrays.toString(a));
		
		
	}
	
	private static void setMap(int[] position) {
		
		int n = position[0];
		cntD = new int[4]; // up, right, down, left
		int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		// cntD 저장
		for (int i = 0; i < 4; i++) {
			int cnt = 0;
			int row = position[1];
			int col = position[2];
			while (map[row][col] != 6) {
				row += dir[i][0];
				col += dir[i][1];
				if (map[row][col] == 0) cnt++;
			}
			cntD[i] = cnt;
		}
//		System.out.println(Arrays.toString(cntD));
		
		int row = position[1];
		int col = position[2];
		int maxD = 0;
		int dirIdx = 0;
		switch(n) {
		case 1:
			dirIdx = 0;
			maxD = cntD[0];
			for (int i=1; i<4; i++) {
				if (cntD[i]>maxD)
					dirIdx = i;
			}
			
			while (map[row][col] != 6) {
				row += dir[dirIdx][0];
				col += dir[dirIdx][1];
				if (map[row][col] == 0)
					map[row][col] = 8;
			}
			
			break;
		
		case 2:
			maxD = cntD[0] + cntD[2]; // 상하로 초기화
			int dir21 = 0;
			int dir22 = 2;
			if (cntD[1]+cntD[2] > maxD) {
				dir21 = 1;
				dir22 = 3;
			}
			
			while (map[row][col] != 6) {
				row += dir[dir21][0];
				col += dir[dir21][1];
				if (map[row][col] == 0)
					map[row][col] = 8;
			}
			
			row = position[1];
			col = position[2];
			
			while (map[row][col] != 6) {
				row += dir[dir22][0];
				col += dir[dir22][1];
				if (map[row][col] == 0)
					map[row][col] = 8;
			}

			break;
			
		case 3:
			maxD = cntD[0] + cntD[1];
			int dir31 = 0;
			int dir32 = 1;
			for (int i=1; i<3; i++) {
				if (cntD[i] + cntD[i+1]>maxD)
					maxD = cntD[i];
					dir31 = i;
					dir32 = i+1;
			}
			if (cntD[3] + cntD[0]>maxD) {
				dir31 = 0;
				dir32 = 3;
			}
			
			while (map[row][col] != 6) {
				row += dir[dir31][0];
				col += dir[dir31][1];
				if (map[row][col] == 0)
					map[row][col] = 8;
			}
			row = position[1];
			col = position[2];
			while (map[row][col] != 6) {
				row += dir[dir32][0];
				col += dir[dir32][1];
				if (map[row][col] == 0)
					map[row][col] = 8;
			}
			
			break;
			
		case 4:
			maxD = cntD[0] + cntD[1] + cntD[2];
			int dir41 = 0;
			int dir42 = 1;
			int dir43 = 2;
			
			if (cntD[1] + cntD[2] + cntD[3]>maxD) {
				dir41 = 1;
				dir42 = 2;
				dir43 = 3;
			}
			if (cntD[2] + cntD[3] + cntD[0]>maxD) {
				dir41 = 2;
				dir42 = 3;
				dir43 = 0;
			}
			if (cntD[3] + cntD[0] + cntD[1]>maxD) {
				dir41 = 3;
				dir42 = 0;
				dir43 = 1;
			}
			
			while (map[row][col] != 6) {
				row += dir[dir41][0];
				col += dir[dir41][1];
				if (map[row][col] == 0)
					map[row][col] = 8;
			}
			row = position[1];
			col = position[2];
			while (map[row][col] != 6) {
				row += dir[dir42][0];
				col += dir[dir42][1];
				if (map[row][col] == 0)
					map[row][col] = 8;
			}
			row = position[1];
			col = position[2];
			while (map[row][col] != 6) {
				row += dir[dir43][0];
				col += dir[dir43][1];
				if (map[row][col] == 0)
					map[row][col] = 8;
			}
			
			break;
			
		case 5:
			
			for (int i = 0; i<4; i++) {
				row = position[1];
				col = position[2];
				while (map[row][col] != 6) {
					row += dir[i][0];
					col += dir[i][1];
					if (map[row][col] == 0)
						map[row][col] = 8;
				}
			}
			break;
		
		}
		
		
	}

}
