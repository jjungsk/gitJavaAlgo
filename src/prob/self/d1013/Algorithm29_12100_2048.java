package prob.self.d1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Algorithm29_12100_2048 {
	
	static int N, ans, rot;
	static int[][] map, copy;
	static int[] dr = {0, 1, 0, -1}; // 동 남 서 북
	static int[] dc = {1, 0, -1, 0};
	static Deque<Integer> dq;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// main Logic
		ans = 0; // 최댓값 담을 변수
		recur(0);
		
		
		System.out.println(ans);
		
	}

	
	// 메인 재귀 함수
	private static void recur(int cnt) {
		
		// 5회 반복 끝냈을 경우 map 안에서 가장 큰 수 ans에 저장
		if (cnt == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) continue;
					ans = Math.max(ans, map[i][j]);
				}
			}
			return;
		}
		
		// 질문!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// 재귀 들어가기 전에 original map을 copy
//		copy = new int[N][N]; // 틀린 답
		int[][] copy = new int[N][N]; // 맞는 답
		
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}
		
		for (int i = 0; i < 4; i++) {
			if (i == 0) { // 오른쪽으로 밀기
				right();
				recur(cnt+1);
				map = mapCopy(copy); // copy한 정보를 map에 덮어 씌우기
			} else if (i == 1) { // 왼쪽으로 밀기
				left();
				recur(cnt+1);
				map = mapCopy(copy);
			} else if (i == 2) { // 위로 밀기
				up();
				recur(cnt+1);
				map = mapCopy(copy);
			} else if (i == 3) { // 아래로 밀기
				down();
				recur(cnt+1);
				map = mapCopy(copy);
			}
		}
		return;
	}
	
	// map copy 함수
	private static int[][] mapCopy(int[][] mapOri) {
		int[][] copy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = mapOri[i][j];
			}
		}
		return copy;
	}

	// 오른쪽으로 밀때
	private static void right() {
		dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = N-1; j >= 0; j--) {
				if (map[i][j] == 0) continue;
				if (dq.isEmpty()) {
					dq.add(map[i][j]);
					map[i][j] = 0;
					continue;
				}
				if (dq.peekLast()==map[i][j]) {
					dq.add(dq.pollLast()*2);
					dq.add(-1);
					map[i][j] = 0;
					continue;
				}
				dq.add(map[i][j]);
				map[i][j] = 0;

			}
			
			int idx = N-1;
			while (!dq.isEmpty()) {
				int cur = dq.poll();
				if (cur == -1) continue;
				map[i][idx--] = cur;
			}
		}
	}
	
	// 왼쪽으로 밀때
	private static void left() {
		dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) continue;
				if (dq.isEmpty()) {
					dq.add(map[i][j]);
					map[i][j] = 0;
					continue;
				}
				if (dq.peekLast()==map[i][j]) {
					dq.add(dq.pollLast()*2);
					dq.add(-1);
					map[i][j] = 0;
					continue;
				}
				dq.add(map[i][j]);
				map[i][j] = 0;

			}
			
			int idx = 0;
			while (!dq.isEmpty()) {
				int cur = dq.poll();
				if (cur == -1) continue;
				map[i][idx++] = cur;
			}
		}
	}
	
	// 아래로 밀때
	private static void down() {
		dq = new ArrayDeque<>();
		
		for (int j = 0; j < N; j++) {
			for (int i = N-1; i >= 0; i--) {
				if (map[i][j] == 0) continue;
				if (dq.isEmpty()) {
					dq.add(map[i][j]);
					map[i][j] = 0;
					continue;
				}
				if (dq.peekLast()==map[i][j]) {
					dq.add(dq.pollLast()*2);
					dq.add(-1);
					map[i][j] = 0;
					continue;
				}
				dq.add(map[i][j]);
				map[i][j] = 0;

			}
			
			int idx = N-1;
			while (!dq.isEmpty()) {
				int cur = dq.poll();
				if (cur == -1) continue;
				map[idx--][j] = cur;
			}
		}
	}
	
	// 위로 밀때
	private static void up() {
		dq = new ArrayDeque<>();
		
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 0) continue;
				if (dq.isEmpty()) {
					dq.add(map[i][j]);
					map[i][j] = 0;
					continue;
				}
				if (dq.peekLast()==map[i][j]) {
					dq.add(dq.pollLast()*2);
					dq.add(-1);
					map[i][j] = 0;
					continue;
				}
				dq.add(map[i][j]);
				map[i][j] = 0;

			}
			
			int idx = 0;
			while (!dq.isEmpty()) {
				int cur = dq.poll();
				if (cur == -1) continue;
				map[idx++][j] = cur;
			}
		}
	}
	

}
