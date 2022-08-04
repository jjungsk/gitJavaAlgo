package online.day2_220804_순열조합부분집합;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest2 {
	
	// cnt : 직전까지 뽑은 순열에 포함된 수의 갯수, cnt+1 번째 해당하는 순열에 포함될 수를 뽑기
	private static void perm(int cnt) {
		
		if (cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 가능한 모든 수에 대해 시도
		for (int i = 0; i < N; i++) {		// 선택지
			// 시도하는 수가 선택되었는지 판단
			if (isSelected[i]) continue;
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];
			isSelected[i] = true;
			// 다음수 뽑으러 가기
			perm(cnt + 1);
			// 사용했던 수에 대해 선택 되돌리기
			isSelected[i] = false;
		}
				
	}
	
	static int N, R, cnt, totalCnt;
	static int[] numbers, input;
	static boolean[] isSelected;
	
	// nPn : 1부터 n까지의 수 중 n개를 모두 뽑아 순서적으로 나열한것 (입력 수 1 ~ 100_000)
	// nPr : 1부터 n까지의 수 중 r개를 모두 뽑아 순서적으로 나열한것 (1 <= r <= n)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N]; // 수가 1부터 시작해서 인데스도 1부터 논리적 매칭 사용
		
		for (int i = 0; i< N; i++) {
			input[i] = sc.nextInt();
		}
		
		perm(0);
		System.out.println("총 경우의 수 : " + totalCnt);
		
	}

}
