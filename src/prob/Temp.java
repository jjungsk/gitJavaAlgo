package prob;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

public class Temp {
	
	public static void main(String[] args) {

		int[] dr = {-1, 0, 0, 1}; // 북 서 동 남
		int[] dc = {0, -1, 1, 0};

		int[][] map = new int[8][8];
		map[3][3] = -1;
		int sharkPosR = 3;
		int sharkPosC = 3;
		int cnt = 1;
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {1, 3});
		dq.add(new int[] {2, 2});
		dq.add(new int[] {2, 4});
		dq.add(new int[] {3, 1});
		dq.add(new int[] {3, 5});
		dq.add(new int[] {4, 2});
		dq.add(new int[] {4, 4});
		dq.add(new int[] {5, 3});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			for (int i = 0; i < 4; i++) {
				int nextR = cur[0] + dr[i];
				int nextC = cur[1] + dc[i];
				if (i==3 & nextR >= sharkPosR && nextC != sharkPosC) continue;
				if (map[nextR][nextC] != 0) continue;
				map[nextR][nextC] = cnt++;
				if (map[3][1] == 5) {
					System.out.println(i + " : " + nextR + " : " + nextC);
				}
			}
			for (int[] a: map)
				System.out.println(Arrays.toString(a));
			System.out.println("------------------------");
		}
		

	}
	
	
}