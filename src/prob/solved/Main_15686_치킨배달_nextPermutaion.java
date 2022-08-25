package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_nextPermutaion {
	
	private static int chickenCnt, M;
	private static int minV = Integer.MAX_VALUE;
	private static int[][] arrChicken;
	private static int[][] arrHouse;
	
	private static int[][] combChicken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // map 가로 세로 크기
		M = Integer.parseInt(st.nextToken()); // 최대 치킨집 갯수 M개
		
		int[][] map = new int[N+2][N+2]; // 0으로 map 둘러싸기
		arrHouse = new int[100][2]; // "1"인 house index값 저장
		arrChicken = new int[13][2]; // "2"인 치킨집 index값 저장
		
		int houseCnt = 0; // map에 있는 현재 집 수
		chickenCnt = 0; // map에 있는 현재 치킨 집 수
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					arrHouse[houseCnt][0] = i;
					arrHouse[houseCnt][1] = j;
					houseCnt++;
				}
				if (map[i][j] == 2) {
					arrChicken[chickenCnt][0] = i;
					arrChicken[chickenCnt][1] = j;
					chickenCnt++;
				}
			}
		}
		
		// 빈 배열 버리고 숫자가 저장된 값만 다시 저장하기
		arrHouse = Arrays.copyOfRange(arrHouse, 0, houseCnt);
		arrChicken = Arrays.copyOfRange(arrChicken, 0, chickenCnt);
		
//		for (int[] a: arrHouse) {
//			System.out.println(Arrays.toString(a));
//		}
//		System.out.println("============");
//		for (int[] a: arrChicken) {
//			System.out.println(Arrays.toString(a));
//		}
		
		int cnt = M;
		combChicken = new int[M][2];
		comb(cnt, combChicken, 0);
		
		out.write(minV+"");
		out.flush();
		out.close();
		
	}
	
	// int cnt = 현재 map에 있는 치킨집 수 중 최대 치킨집수 M과 동일, combChicken = M개만 골랐을때 치킨집 위치, startIdx = comb 시작 index
	private static void comb(int cnt, int[][] combChicken, int startIdx) {
		
		if (cnt == 0) {
			int sum = 0; // 고른 치킨집 과 집 사이의 거리 합
			for (int[] house: arrHouse) { // 모든 집
				int temp = Integer.MAX_VALUE;
				for (int[] chi: combChicken) { // comb로 M개 선택된 치킨집
					int distance = Math.abs(house[0]-chi[0])+Math.abs(house[1]-chi[1]); // 집과 치킨집 사이를 distance에 저장
					temp = (distance > temp)? temp: distance; // 집에서 가장 가까운 치킨집을 temp로 저장
				}
				sum += temp; // 집에서 가장 가까운 치킨집을 저장한 모든 집들의 합 = 치킨 거리
			}
			minV = (minV > sum)? sum: minV; // comb로 돌려서 가장 작은 치킨 거리 구하기
			return;
		}
		
		for (int i = startIdx; i<chickenCnt; i++) {
			combChicken[M-cnt][0] = arrChicken[i][0];
			combChicken[M-cnt][1] = arrChicken[i][1];
			comb(cnt-1, combChicken, i+1);
		}
			
	}
	

}
