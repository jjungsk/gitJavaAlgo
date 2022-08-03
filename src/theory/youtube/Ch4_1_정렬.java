package theory.youtube;

import java.util.Arrays;

public class Ch4_1_정렬 {
	
	/*
	 [선택 정렬의 시간 복잡도]
	 
	 선택 정렬은 N번 만큼 가장 작은 수를 찾아서 맨 앞으로 보내야 합니다.
	 구현 방식에 따라서 사소한 오차는 있을 수 있지만, 전체 연산 횟수는 다음과 같다.
	 	N + (N - 1) + (N - 2) + ... + 2
	 이는 (N^2 + N - 2) / 2 로 표현하며, 빅오 표기법에 따라서 O(N^2) 이다.
	 */
	
	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
		
		for (int i = 0; i < n; i++) {
			int minI = i; // 가장 작은 원소의 인덱스
			for (int j = i + 1; j < n; j++) {
				if (arr[minI] > arr[j]) {
					minI = j;
				}
			}
			// swap -> 첫번째 원소와 가장 작은 값 변환 -> 두번째 원소와 두번째로 작은 값 변환 -> 세번째 ...
			int temp = arr[i];
			arr[i] = arr[minI];
			arr[minI] = temp;
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
		System.out.println(Arrays.toString(arr));
		
	}

}
