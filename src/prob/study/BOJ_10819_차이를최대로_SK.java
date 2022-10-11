package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로_SK {
	
	static int N, ans, src[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		src = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			src[i] = Integer.parseInt(st.nextToken());
		
		ans = 0;
		perm(0, new boolean[N], new int[N]);
		
		System.out.println(ans);
		
	}

	private static void perm(int cnt, boolean[] visited, int[] temp) {
		
		if (cnt == N) {
			int tempSum = 0;
			for (int i = 0; i < N-1; i++) 
				tempSum += Math.abs(temp[i]-temp[i+1]);
			
			if (tempSum <= ans) return;
			ans = tempSum;
//			System.out.println(Arrays.toString(temp) + " : " + ans);
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			temp[cnt] = src[i];
			perm(cnt+1, visited, temp);
			visited[i] = false;
		}
		
	}

}
