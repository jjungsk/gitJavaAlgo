package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_kyuskal {
	
	private static int number, calculation;
	private static int[] parents;
	private static int[][] calArr;
	private static boolean[] visited;

	private static void make() {
		parents = new int[number+1];
		
		for (int i = 1; i <= number; i++)
			parents[i] = i;
	}
	
	private static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		parents[bRoot] = aRoot;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			number = Integer.parseInt(st.nextToken());
			calculation = Integer.parseInt(st.nextToken());
			
			List<Integer> ansList = new ArrayList<>();
			calArr = new int[calculation][3];
			for (int i = 0; i < calculation; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				calArr[i][0] = Integer.parseInt(st.nextToken());
				calArr[i][1] = Integer.parseInt(st.nextToken());
				calArr[i][2] = Integer.parseInt(st.nextToken());
			}
			
			// 구현부
			make(); // 자기 자신이 부모인 parents arr 생성
			
			for (int[] cal: calArr) {
				if (cal[0] == 0) { // 합집합인 경우 union 실행
					union(cal[1], cal[2]);
					System.out.println(Arrays.toString(parents));
				}
				if (cal[0] == 1) {
					int aRoot = find(cal[1]);
					int bRoot = find(cal[2]);
					System.out.println(aRoot + " : " + bRoot);
					if (aRoot == bRoot)
						ansList.add(1);
					else
						ansList.add(0);
				}
			}
			int root = find(6);
			System.out.println(root);
			sb.append("#").append(tc).append(" ");
			while(!ansList.isEmpty())
				sb.append(ansList.remove(0));
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}
