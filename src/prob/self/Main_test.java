package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_test {
	
	static int L;
	static int minDist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 전체 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken()); // 마을의 갯수 
			int P = Integer.parseInt(st.nextToken()); // 경찰서 갯수
			L = Integer.parseInt(st.nextToken()); // 마을의 둘레 길이
			
			int[] src = new int[V]; // 마을의 위치
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < V; i++) { // 임의의 마을 위치를 저장
				src[i] = Integer.parseInt(st.nextToken());
			}
			
			// 조합의 수를 통해 거리가 가장 가까운 경찰서의 조합으로 거리가 짧은 거리 구하는 main logic
			minDist = Integer.MAX_VALUE;
			comb(0, 0, src, new int[P]);
			
			sb.append("#").append(tc).append(" ").append(minDist).append("\n");
			
		} // 모든 tc 종료 문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}

	private static void comb(int cnt, int startIdx, int[] src, int[] toChoosed) {
		// 기저 조건 : cnt 갯수와 찾고자 하는 갯수가 같은때 값을 반환
		if (cnt == toChoosed.length) {
//			System.out.println(Arrays.toString(toChoosed));
			int tempSum = 0; // 경찰서부터
			for (int i = 0; i < src.length; i++) {
				int temp = Integer.MAX_VALUE; // 골라진 경찰서부터 src 있는 해당 마을까지 가장 가까운 거리
				for (int j = 0; j < toChoosed.length; j++) {
					
					// 마을이 원형으로 되어있기 때문에 좌우 + 왼쪽 고리 + 오른쪽 고리 방향 모두 탐색
					temp = (temp>Math.abs(src[i]-toChoosed[j]))? Math.abs(src[i]-toChoosed[j]): temp;
					temp = (temp>Math.abs(L+src[i]-toChoosed[j]))? Math.abs(L+src[i]-toChoosed[j]): temp;
					temp = (temp>Math.abs(src[i]-toChoosed[j]-L))? Math.abs(src[i]-toChoosed[j]-L): temp;
					if (temp==0) break; // 최소값 0이 나왔을때는 더 이상의 탐색은 필요 없음
				}	
				tempSum += temp; // 현재 조합에서 가장 최소 거리 값을 저장
			}
			
			minDist = (minDist > tempSum)? tempSum: minDist; // 전체 조합의 경우에서 가장 거리가 짧은 값을 저장
			return;
		}
		
		// startIdx부터 src 전체의 값을 cnt == 찾고자 하는 갯수만큼 탐색
		for (int i = startIdx; i < src.length; i++) {
			toChoosed[cnt] = src[i]; // 골라진 idx는 src의 범위 내에서
			comb(cnt+1, i+1, src, toChoosed); // 갯수는 한개씩 늘려주고 startIdx는 찾고자 하는 이전 범위보다 i+1로 늘린다
		}
				
		return;
	}

}
