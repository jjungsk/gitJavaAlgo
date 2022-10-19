package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크_SK2 {
	
	static int N, minV;
	static int[][] agi;
	static List<Integer> listSC, listLC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		N = Integer.parseInt(br.readLine());
		agi = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				agi[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		listSC = new ArrayList<>();
		listLC = new ArrayList<>();
		minV = Integer.MAX_VALUE;
		recursive(0, 0, 0, 0);
		
		System.out.println(minV);
		
	}

	private static void recursive(int player, int teamSC, int teamLC, int ans) {
			if (minV==0) return;
			if (player == N) {
				ans = Math.abs(ans);
				minV = (minV > ans)? ans: minV;
				return;
			}
			
			if (teamSC < N/2) {
				int temp = 0;
				if (listSC.size()>0) {
					for (int a: listSC) {
						temp += agi[player][a] + agi[a][player];
					}
				}
				listSC.add(player);
				recursive(player+1, teamSC+1, teamLC, ans + temp);
				listSC.remove(listSC.indexOf(player));
			}
			
			if (teamLC < N/2) {
				int temp = 0;
				if (listLC.size()>0) {
					for (int a: listLC) {
						temp += agi[player][a] + agi[a][player];
					}
				}
				listLC.add(player);
				recursive(player+1, teamSC, teamLC+1, ans - temp);
				listLC.remove(listLC.indexOf(player));
			}
		
	}

}
