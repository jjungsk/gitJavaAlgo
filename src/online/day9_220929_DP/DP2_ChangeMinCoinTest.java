package online.day9_220929_DP;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest {
	
	public static void main(String[] args) {
		
		// 1, 4, 6원 화폐 단위로 고정, 동전 갯수 무한
		
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt(); // 목표금액
		
		int[] D = new int[money+1]; // D[i] : i 금액을 만드는 최소 동전 수
		
		
		for (int i=1; i <= money; i++) {
			int min = D[i-1] + 1;
			if (i>=4) min = Math.min(min, D[i-4]+1);
			if (i>=6) min = Math.min(min, D[i-6]+1);
			
			D[i] = min;
		}
		
		System.out.println(Arrays.toString(D));
		System.out.println(D[money]);
		
	}

}
