package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3109_빵집2 {

	static int ans, dx[] = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String rc = br.readLine();
		StringTokenizer st = new StringTokenizer(rc);
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		for (int i = 0; i < r; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				map[i][j] = row[j];
			}
		}

//		init done

		ans = 0;
		for (int i = 0; i < r; i++) {
			check(map, r, c, i, 0);
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}

		System.out.println(ans);

	}

	private static boolean check(char[][] map, int r, int c, int x, int y) {
		if (y == c - 1) {
			ans++;
			return true;
		}

		boolean possible = false;
		for (int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			if (nx < 0 || nx > r - 1 || map[nx][y + 1] != '.') {
				continue;
			} else {
				map[nx][y + 1] = 'o';
				if (check(map, r, c, nx, y + 1)) {
					possible = true;
					return possible;
				}
			}
		}

		return possible;
	}

}