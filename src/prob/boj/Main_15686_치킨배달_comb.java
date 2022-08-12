package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_comb {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] info = br.readLine().split(" ");
		int size = Integer.parseInt(info[0]);
		int notClosed = Integer.parseInt(info[1]);
		
		int[][] city = new int[size][size];
		List<int[]> chickens = new ArrayList<int[]>();
		List<int[]> houses = new ArrayList<int[]>();
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				int cur = Integer.parseInt(st.nextToken());
				city[i][j] = cur;
				if(cur == 2) {
					int[] pos = {i, j};
					chickens.add(pos);
				}
				if(cur == 1) {
					int[] pos = {i, j};
					houses.add(pos);
				}
			}
		}
		
		int[] masking = new int[chickens.size()];
		for (int i = masking.length-1 ; i >= masking.length - notClosed; i--) {
			masking[i] = 1;
		}
		
//		init fin
		int ans = Integer.MAX_VALUE;
		
		do {
			int[] scores = new int[houses.size()];
			for (int i = 0; i < chickens.size(); i++) {
				if(masking[i] == 1) {
//					시작점을 찾으면 좌표 선택
					int curX = chickens.get(i)[0];
					int curY = chickens.get(i)[1];
					
					for (int j = 0; j < scores.length; j++) {
						int newVal = Math.abs(curX - houses.get(j)[0]) + Math.abs(curY - houses.get(j)[1]);
						scores[j] = scores[j] == 0 ? newVal : Math.min(scores[j], newVal);
					}
					
				}
			}
//			각 조합별 최소 거리를 구하여 결과에 삽입
			int result = 0;
			for (int score : scores) {
				result += score;
			}
			ans = Math.min(ans, result);
			
		} while (np(masking));
		
		System.out.println(ans);
		
		
		
	}
	
	static boolean np(int[] pos) {
		int N = pos.length - 1;
		
		int i = N;
		
		while(i > 0 && pos[i-1] >= pos[i]) --i;
		if(i == 0) return false;
		
		int j = N;
		while(pos[i-1] >= pos[j]) --j;
		
		swap(pos, i-1, j);
		
		int k = N;
		while(i < k) swap(pos, i++, k--);
		return true;
	}
	
	static void swap(int[] pos, int i, int j) {
		int temp = pos[i];
		pos[i] = pos[j];
		pos[j] = temp;
	}
	
}