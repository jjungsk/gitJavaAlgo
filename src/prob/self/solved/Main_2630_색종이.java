package prob.self.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2630_색종이 {
	
	private static int W, B, N;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursiveMap(0, N, 0, N);
		
		sb.append(W).append("\n").append(B);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void recursiveMap(int rowS, int rowE, int colS, int colE) {
		
		boolean flag = true;
		int cur = map[rowS][colS];
		loop:
		for (int i = rowS; i < rowE; i++) {
			for (int j = colS; j < colE; j++) {
				if (map[i][j] == cur) continue;
				flag = false;
				break loop;
			}
		}
		
		if (flag) {
			if (cur == 0) ++W;
			else ++B;
			return;
		}
		
		int rowH = (rowE+rowS)/2;
		int colH = (colE+colS)/2;
		
		recursiveMap(rowS, rowH, colS, colH);
		recursiveMap(rowS, rowH, colH, colE);
		recursiveMap(rowH, rowE, colS, colH);
		recursiveMap(rowH, rowE, colH, colE);
		
		
	}

}
