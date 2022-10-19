package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크_SK {
	
	static int N, idx;
	static int[] players;
	static int[] choosed;
	static List<Integer> agiSum;
	static int[][] agi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
				
		N = Integer.parseInt(br.readLine());
		players = new int[N];
		choosed = new int[N/2];
		agiSum = new ArrayList<>();
		agi = new int[N][N];
		for (int i = 0; i < N; i++) {
			players[i] = i;
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				agi[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		int ans = Integer.MAX_VALUE;
		int dif = 0;
		int len = agiSum.size();
		for (int i = 0; i < len/2; i++) {
			dif = Math.abs(agiSum.get(i)-agiSum.get(len-i-1));
			if (dif == 0) {
				ans = 0;
				break;
			}
			ans = (dif > ans)? ans: dif;
		}
		System.out.println(ans);
		
	}

	private static void comb(int cnt, int startIdx) {
		if (cnt == N/2) {
			int tempSum = 0;
			for (int i = 0; i < N/2-1; i++) {
				for (int j = i+1; j < N/2; j++) {
					tempSum += agi[choosed[i]][choosed[j]] + agi[choosed[j]][choosed[i]];
				}
			}
			agiSum.add(tempSum);
			return;
		}
		
		for (int i = startIdx; i < N; i++) {
			choosed[cnt] = players[i];
			comb(cnt+1, i+1);
		}
		
	}

}
