package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_3234_양팔저울 {
	
	private static int n, ans;
	private static int[] arr, permA;
	private static List<int[]> result;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <T+1; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			permA = new int[n];
			visited = new boolean[n];
			result = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i <n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			ans = 0;
			perm(0);
			powerSet();
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void powerSet() {
		
		for (int i = 0; i < (1 << n); i++) {
			int leftW = 0;
			int rightW = 0;
			List<Integer> leftA = new ArrayList<>();
			List<Integer> rightA = new ArrayList<>();
			Map<Integer, String> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				if ( (i & (1<<j)) > 0) {
					leftA.add(arr[j]);
					leftW += arr[j];
				}
				else {
					rightA.add(arr[j]);
					rightW += arr[j];
				}
			}
			
			if (leftW >= rightW) {
				
				for (int[] tempA: result) {
					int tempL = 0;
					int tempR = 0;
					boolean flag = true;
					loop:
					for (int a: tempA) {
						for (int l: leftA) {
							if (l == a) {
								tempL += a;
							} else
								tempR += a;
							
							if (tempR > tempL) {
								flag = false;
								break loop;
							}
						}

					}
					if (flag)
						ans++;
				}
			}
			
			
		}
	}
	
	private static void perm(int cnt) {
		if (cnt == n) {
			int[] temp = new int[n];
			for (int i = 0; i < n; i++)
				temp[i] = permA[i];
			result.add(temp);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permA[cnt] = arr[i];
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}

}
