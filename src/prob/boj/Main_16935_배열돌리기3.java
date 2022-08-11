package prob.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// arrR 배열 저장
		int[] arrR = new int[R];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < R; i++)
			arrR[i] = Integer.parseInt(st.nextToken());
		
		int cnt = arrR.length;
		for (int order: arrR) {
			switch (order) {
				case 1: {
					// 1번 연산
					for (int i = 1; i <= N; i++) {
						for (int j = 1; j <= M; j++) {
							dq.addLast(map[i][j]);
						}
					}
					for (int i = N; i >= 1; i--) {
						for (int j = 1; j <= M; j++) {
							map[i][j] = dq.pollFirst();
						}
					}
					
					break;
				}
				case 2: {
					// 2번 연산
					for (int i = 1; i <= N; i++) {
						for (int j = 1; j <= M; j++) {
							dq.addLast(map[i][j]);
						}
					}
					for (int i = 1; i <= N; i++) {
						for (int j = M; j >= 1; j--) {
							map[i][j] = dq.pollFirst();
						}
					}
					
					break;
				}
				case 3: {
					// 3번 연산 (오른쪽 90도)
					for (int i = 1; i <= N; i++) {
						for (int j = 1; j <= M; j++) {
							dq.addLast(map[i][j]);
						}
					}
					int temp = N;
					N = M;
					M = temp;
					map = new int[N+2][M+2];
					for (int j = M; j >= 1; j--) {
						for (int i = 1; i <= N; i++) {
							map[i][j] = dq.pollFirst();
						}
					}
					
					
					break;
				}
				case 4: {
					// 4번 연산 (왼쪽 90도)
					for (int i = 1; i <= N; i++) {
						for (int j = 1; j <= M; j++) {
							dq.addLast(map[i][j]);
						}
					}
					int temp = N;
					N = M;
					M = temp;
					map = new int[N+2][M+2];
					for (int j = 1; j <= M; j++) {
						for (int i = N; i >= 1; i--) {
							map[i][j] = dq.pollFirst();
						}
					}
					
					
					break;
				}
				case 5: {
					// 5번 저장
					for (int i = 1; i <= N/2; i++) {
						for (int j = 1; j <= M/2; j++) {
							dq.addLast(map[i][j]);
						}
					}
					for (int i = 1; i <= N/2; i++) {
						for (int j = M/2+1; j <= M; j++) {
							dq.addLast(map[i][j]);
						}
					}
					for (int i = N/2+1; i <= N; i++) {
						for (int j = M/2+1; j <= M; j++) {
							dq.addLast(map[i][j]);
						}
					}
					for (int i = N/2+1; i <= N; i++) {
						for (int j = 1; j <= M/2; j++) {
							dq.addLast(map[i][j]);
						}
					}
					
					// 5번 배치
					for (int i = 1; i <= N/2; i++) {
						for (int j = M/2+1; j <= M; j++) {
							map[i][j] = dq.pollFirst();
						}
					}
					for (int i = N/2+1; i <= N; i++) {
						for (int j = M/2+1; j <= M; j++) {
							map[i][j] = dq.pollFirst();
						}
					}
					for (int i = N/2+1; i <= N; i++) {
						for (int j = 1; j <= M/2; j++) {
							map[i][j] = dq.pollFirst();
						}
					}
					for (int i = 1; i <= N/2; i++) {
						for (int j = 1; j <= M/2; j++) {
							map[i][j] = dq.pollFirst();
						}
					}
					
					break;
				}
				case 6: {
					// 저장
					for (int i = 1; i <= N/2; i++) {
						for (int j = 1; j <= M/2; j++) {
							dq.addLast(map[i][j]);
						}
					}
					for (int i = 1; i <= N/2; i++) {
						for (int j = M/2+1; j <= M; j++) {
							dq.addLast(map[i][j]);
						}
					}
					for (int i = N/2+1; i <= N; i++) {
						for (int j = M/2+1; j <= M; j++) {
							dq.addLast(map[i][j]);
						}
					}
					for (int i = N/2+1; i <= N; i++) {
						for (int j = 1; j <= M/2; j++) {
							dq.addLast(map[i][j]);
						}
					}
					
					// 6번 배치
					for (int i = N/2+1; i <= N; i++) {
						for (int j = 1; j <= M/2; j++) {
							map[i][j] = dq.pollFirst();
						}
					}		
					for (int i = 1; i <= N/2; i++) {
						for (int j = 1; j <= M/2; j++) {
							map[i][j] = dq.pollFirst();
						}
					}
					for (int i = 1; i <= N/2; i++) {
						for (int j = M/2+1; j <= M; j++) {
							map[i][j] = dq.pollFirst();
						}
					}
					for (int i = N/2+1; i <= N; i++) {
						for (int j = M/2+1; j <= M; j++) {
							map[i][j] = dq.pollFirst();
						}
					}	
					
					break;
				}
			} // switch문
			
		} // for문
	

		// 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
		
		
	}
	
	
	

}
