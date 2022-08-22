package prob.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_algorithm14_1987_알파벳2 {
	static char[][] board;
	static int[][] dist;
	static boolean[] checkAlphabet;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int R;
	static int C;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		
		
		board = new char[R][C];
		dist = new int[R][C];
		checkAlphabet = new boolean[26];

		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		} // 입력

		dist[0][0]=1;
		checkAlphabet[board[0][0] - 'A'] = true;
		func(0, 0);

		int max_dist = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				max_dist = Math.max(max_dist, dist[i][j]);
				System.out.print(dist[i][j]);
			}
			System.out.println();
		}
		sb.append(max_dist);
//		sb.append(result);
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void func(int x, int y) {
//		result = Math.max(result, distInt);
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
				continue;
			}
			if (checkAlphabet[board[nx][ny] - 'A']) {
				continue;
			}

			dist[nx][ny] = dist[x][y] + 1;
//			dist[nx][ny] = Math.max(dist[nx][ny], dist[x][y] + 1);
			checkAlphabet[board[nx][ny] - 'A'] = true;
			func(nx, ny);
			dist[x][y] = Math.max(dist[nx][ny], dist[x][y] + 1);
			checkAlphabet[board[nx][ny] - 'A'] = false;

		}
		
		return;

	}

}