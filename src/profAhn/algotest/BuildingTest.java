package profAhn.algotest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * B구획의 빌딩 최고 높이 구하기
 */ 
public class BuildingTest {
	
//	static String input = "3\r\n" + 
//			"6\r\n" + 
//			"G B G G B B\r\n" + 
//			"G B G G B G \r\n" + 
//			"B B B B G B\r\n" + 
//			"B G B B B B\r\n" + 
//			"G B B B B G\r\n" + 
//			"G B B B B G\r\n" + 
//			"5\r\n" + 
//			"G B G G B \r\n" + 
//			"G B G G B  \r\n" + 
//			"B B B B G \r\n" + 
//			"B G B B B \r\n" + 
//			"G B B B B \r\n" + 
//			"3\r\n" + 
//			"G G B\r\n" + 
//			"G B B\r\n" + 
//			"B B B\r\n" + 
//			"";

	public static void main(String[] args) throws IOException{
		// 코드를 작성해주세요.
//		BufferedReader br = new BufferedReader(new StringReader(input));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			sb.append("#").append(tc+1).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N+2][N+2];
			
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) 
					map[i][j] = st.nextToken().charAt(0);
			}
			
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == 0 || j == 0 || i == N+1 || j == N+1)
						map[i][j] = 'B';
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			
			int ans = 2;
			boolean sol = true;
			
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if (map[i][j] == 'B') {
						for (int row = -1; row < 2; row++) {
							for (int col = -1; col < 2; col++) {
								if (map[i+row][j+col] == 'G') {
									sol = false;
									break;
								}
							}
							if (sol == false)
								break;
						}
						if (sol == true) {
//							System.out.println("i = " + i + ", j = " + j);
							int tmp = 0;
							for (int k = 1; k < N+1; k++) {
								if (map[i][k] == 'B') {
									tmp += 1;
//									System.out.println("(i, k) = " + "(" + i + ", " + k + ")");									
								}
								if (map[k][j] == 'B') {
									tmp += 1;
//									System.out.println("(k, j) = " + "(" + k + ", " + j + ")");																		
								}
//								else
//									continue;
							}
							tmp -= 1;
							ans = Math.max(ans, tmp);
						}
					}
					sol = true;
					
				}
				
			}
			
			sb.append(ans).append("\n");
			
		}
		System.out.println(sb);
		
		
	}
}

