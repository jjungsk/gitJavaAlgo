package online.day2_220804_순열조합부분집합;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_diceTest {
	
	static int N, totalCnt, start;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int mode = sc.nextInt();
		
		totalCnt = 0;
		numbers = new int[N];
		
		switch(mode) {
		// 중복순열
		case 1:
			dice1(0);
			break;
		// 순열
		case 2:
			isSelected = new boolean[7]; // 1~6 주사위눈 선택여부
			dice2(0);
			break;
		// 중복 조합
		case 3:
			dice3(0, 1);
			break;
		// 조합
		case 4:
			dice4(0, 1);
			break;
		default:
			System.out.println("잘못된 입력");
			return;
		}
		
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	// 주사위 던지기 1 : 중복 순열
	private static void dice1 (int cnt) {
		// 기저조건
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
			 // 가능한 모든 수 시도 (주사위 눈 1~6)
		for (int i = 1; i <= 6; i++) {
			// 수의 중복 선택이 가능하므로 중복체크 필요없음
			// 해당 수 선택
			numbers[cnt] = i;
			// 다음 주사위던지러 가기
			dice1(cnt + 1);
		}
	}

	// 주사위 던지기 2 : 중복 순열
	private static void dice2(int cnt) {
		// 기저조건
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
			 // 가능한 모든 수 시도 (주사위 눈 1~6)
		for (int i = 1; i <= 6; i++) {
			// 중복 체크 필요
			if (isSelected[i]) continue;
			isSelected[i] = true;
			// 해당 수 선택
			numbers[cnt] = i;
			// 다음 주사위던지러 가기
			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	// 주사위 던지기 3 : 중복 조합
	private static void dice3 (int cnt, int start) {
		// 기저조건
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
			 // 가능한 모든 수 시도 (주사위 눈 1~6)
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt + 1, i);
		}
	}
	
	// 주사위 던지기 4 : 조합
	private static void dice4 (int cnt, int start) {
		// 기저조건
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
			 // 가능한 모든 수 시도 (주사위 눈 1~6)
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}
	
	
}