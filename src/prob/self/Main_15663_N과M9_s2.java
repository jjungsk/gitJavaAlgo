package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15663_N과M9_s2 {
	
	static int N, R;
	static int[] src, choosed;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		choosed = new int[R];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(src);
		
		
		setComb(0, 0);
		
		for (int[] a: list) {
			for (int b: a) {
				sb.append(b).append(" ");
			}
			sb.append("\n");
		}
		System.out.println("-------------");
		for (int[] a: list2)
			System.out.println(Arrays.toString(a));
		
		System.out.println("----------");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void setComb(int cnt, int startIdx) {
		if (cnt==R) {
			boolean flag = false; // 다르다 true, 같다 false
			int[] temp = new int[R];
			temp = Arrays.copyOf(choosed, R);
			if (list.isEmpty()) flag = true;
			else {
				for (int i = 0; i < R; i++) {
					if (choosed[i] != list.get(list.size()-1)[i]) {
						flag = true;
						break;
					}
				}
			}
			if (!flag) return;
			list.add(temp);
			list2.add(choosed);
			System.out.println(Arrays.toString(temp));
			
			return;
		}
		
		for (int i = startIdx; i < N; i++) {
			choosed[cnt] = src[i];
			setComb(cnt+1, i+1);
			
		}
		
	}

}
