package online.day4_220816_powerSet;

import java.util.Scanner;

public class CoinTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int targetMoney = sc.nextInt();
		
		int[] units = {500, 100, 50, 10, 5, 1};
		int[] cnt = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
		
		int totalMoney = 0;
		// 보유하고 있는 모든 동전들로 만들 수 있는 금액 계산
		for (int i = 0, size = units.length; i < size; i++) {
			totalMoney += units[i]*cnt[i];
		}
		
		// 갖고 있는 동에서 음료수 값을 지불하고 남은 나머지 금액
		int remainMoney = totalMoney - targetMoney;
		
		// 음료수값을 지불하는 데 동전을 최대로 사용하려면, 지불하고 남은 금액의 동전수를 최소로 하면 된다.
		
		int sum = 0, maxCnt, availCnt;
		// 가장 큰 화폐 단위로부터 많이 사용하도록
		for (int i = 0, size = units.length; i < size; i++) {
			maxCnt = remainMoney / units[i]; // 해당 금액 i을 화폐단위를 가장 많이 쓸때의 갯수
			availCnt = maxCnt <= cnt[i]? maxCnt: cnt[i];
			
			cnt[i] -= availCnt; // 쓰고 남은 동전의 갯수를 업데이트
			remainMoney -= availCnt * units[i];
			
			sum += cnt[i]; // 사용되고 남은 동전이 지불하기 위해 사용될 동전 수
		}
		
		System.out.println(sum); // 음료수 값을 지불하기 위해 사용된 동전수
		
		for (int i = 0, size = cnt.length; i < size; i++) {
			System.out.print(cnt[i] + " ");
		}
		
	}

}
