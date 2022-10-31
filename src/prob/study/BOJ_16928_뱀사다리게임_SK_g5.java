package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16928_뱀사다리게임_SK_g5 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<int[]> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int tot = N+M;
		
		int a=0, b=0;
		for (int i = 0; i < tot; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list.add(new int[] {a, b});
		}
		
		// main logic
		int[] minDist = new int[101]; // 1 ~ 100 사이를 몇번에 갈 수 있는지 저장하는 array
		minDist[1] = 0; // 처음 1번에서 출발할때 횟수는 0
		Arrays.fill(minDist, Integer.MAX_VALUE); // 나머지는 정수의 최댓값으로 초기화
		
		boolean flag = false; // 해당 게임판 지점에 사다리가 또는 뱀이 있는지 확인 하는 boolean 값
		int[] dice = new int[2]; // Que에 삽입할 {해당 지점, 그 지점을 가는데 필요한 주사위 횟수}
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {1, 0}); // 초반 1의 지점은 0번에 들어감
		while (!dq.isEmpty()) { // bfs 탐색
			dice = dq.poll(); // 현재 해당 주사위 위치와 몇번만에 왔는지
			
			for (int i = dice[0]+1; i < dice[0]+7; i++) { // 현재 위치를 중심으로 주사위는 1~6 이므로 갈 수 있는 지점을 for문으로 탐색
				if (i > 100) continue; // 만약 다음 탐색 지점이 100 보다 클 경우 무시
				
				flag = false; // 매 탐색 마다 아직 사다리 또는 뱀을 만나지 않음
				for (int[] move: list) { // 뱀 또는 사다리를 만나는지 탐색하는 for문.. 따로 함수로 빼는게 깔끔하지만 귀찮아서..ㅎㅎ
					if (move[0] == i) { // 만약 뱀 또는 사다리를 만났다면
						flag = true; // 만났다고 표시
						if (dice[1] + 1 >= minDist[move[1]]) { // 이동한 지점이 최솟값으로 갱신되지 않을때 무시
							break;
						}
						minDist[move[1]] = dice[1]+1; // 이동한 지점이 최솟값으로 갱신된다면 que에 넣어서 탐색
						dq.add(new int[] {move[1], minDist[move[1]]});
						break;
					}
				}
				if (flag || dice[1]+1 >= minDist[i]) continue; // 만약 뱀 또는 사다리를 만났다면 || 최솟값이 갱신되지 않는다면 무시
				minDist[i] = dice[1]+1; // 최솟값 갱신
				dq.add(new int[] {i, minDist[i]}); // 갱신한 최솟값과 그때의 주사위 위치를 q에 넣어 탐색
			}
			
			if (minDist[100] != Integer.MAX_VALUE) break; // 100번 위치가 최솟값이 아닌 수로 갱신된다면.. 즉 제일 빨리 갱신된 값이 최솟값..? 이게 왜 되지?ㅋㅋㅋ
		}
		
		System.out.println(minDist[100]);
	}

}
