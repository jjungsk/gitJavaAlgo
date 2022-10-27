package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_15654_N과M5_SK_s3 {
	
	static int N, R;
	static Integer[] src, choosed;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		src = new Integer[N];
		choosed = new Integer[R];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		perm(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void perm(int cnt) {
		if (cnt == R) {
			for (Integer a: choosed) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
//			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			choosed[cnt] = src[i];
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
		
	}

}
