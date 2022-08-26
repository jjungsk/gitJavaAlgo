package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			int K = Integer.parseInt(br.readLine());
			
			magnetArr = new int[4][8]; // 4x8 마그넷 행렬 입력
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					int temp = Integer.parseInt(st.nextToken());
					magnetArr[i][j] = temp;
				}
			}
			
			dirOrder = new int[K][2]; // 몇번째 마그넷 어느 방향으로 회전할지
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				dirOrder[i][0] = Integer.parseInt(st.nextToken());
				dirOrder[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//  구현부
			for(int[] order: dirOrder) {
				int magnetIdx = order[0]-1; // 회전할 마그넷 index 번호
				int rotateDir = order[1]; // 어느 방향으로 회전할지
				visited = new boolean[4]; // 이동할 방향의 마그넷을 회전 했는지 확인
				
				rotate(magnetIdx, rotateDir);
				
			}
			
			int sum = 0; // 총합
			for (int i = 0; i < 4; i++) {
				if (magnetArr[i][0] == 1) { // 회전 후 index 0인 지점이 s극일때
					sum += Math.pow(2, i);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			
		} // tc 종료문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}
	
	static boolean[] visited;
	static int[][] dirOrder;
	static int[][] magnetArr;

	// 왼쪽 마그넷과 s-n극으로 연결 되어있는지 확인
	static boolean contactL(int curIdx, int leftIdx) {
		if (magnetArr[leftIdx][2] != magnetArr[curIdx][6]) return true; // s-n으로 연결 되어 있다면 true
		return false;
	}
	
	// 오른쪽 마그넷과 s-n극으로 연결 되었있는지 확인
	static boolean contactR(int curIdx, int rightIdx) {
		if(magnetArr[curIdx][2] != magnetArr[rightIdx][6]) return true; // s-n으로 연결 되어 있다면 true
		return false;
	}
	
	
	static void rotate (int magnetIdx, int rotateDir) {
		visited[magnetIdx] = true; // 현재 마그넷 방문처리
		
		//  step1. 양옆 기어가 돌아가는지 확인 (조건 : 현재 인덱스를 기준 양옆 마그넷이 s-n으로 연결 되었는지 && 아직 방문 전인지
		if (magnetIdx == 0) {
			if (contactR(magnetIdx, magnetIdx+1) && !visited[magnetIdx+1]) {
				rotate(magnetIdx+1, -1*rotateDir); // 옆 기어가 돌아갈때는 rot 방향을 반대 방향으로 바꾸어야 한다
			}
		} else if (magnetIdx >= 1 && magnetIdx <=2) {
			if (contactL(magnetIdx, magnetIdx-1) && !visited[magnetIdx-1]) {
				rotate(magnetIdx-1, -1*rotateDir);
			}
			if (contactR(magnetIdx, magnetIdx+1) && !visited[magnetIdx+1]) {
				rotate(magnetIdx+1, -1*rotateDir);
			}
		} else if (magnetIdx == 3) {
			if (contactL(magnetIdx, magnetIdx-1) && !visited[magnetIdx-1]) {
				rotate(magnetIdx-1, -1*rotateDir);
			}
		}
		
		// step2. 해당 기어 회전
		if (rotateDir == 1) { // 시계 방향으로 회전
			int temp = magnetArr[magnetIdx][7];
			for (int i = 7; i > 0; i--) {
				magnetArr[magnetIdx][i] = magnetArr[magnetIdx][i-1]; 
			}
			magnetArr[magnetIdx][0] = temp;
		} else if (rotateDir == -1) { // 반시계 방향으로 회전
			int temp = magnetArr[magnetIdx][0];
			for (int i = 0; i < 7; i++) {
				magnetArr[magnetIdx][i] = magnetArr[magnetIdx][i+1];
			}
			magnetArr[magnetIdx][7] = temp;
		}
		
	} // rotate 함수 종료

}
