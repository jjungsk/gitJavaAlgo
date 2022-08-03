package theory.youtube;

import java.util.Arrays;

public class Ch4_2_삽입정렬 {
	/*
		[삽입 정렬]
		
		처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입
		선택 정렬에 비해 구현 난이도가 높은 편이지만, 일반적으로 더 효율적
		삽입 정렬의 시간 복잡도는 O(N^2)이며, 선택 정렬과 마찬가지로 반복문이 두 번 중첩되어 사용
		삽입 정렬은 현재 리스트의 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작
			- 최선의 경우 O(N)의 시간 복잡도
	 */

	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
		
		for (int i = 1; i < n; i++) {
			// 인데스 i 부터 1까지 감소하며 반복하는 문법
			for (int j = i; j > 0; j--) {
				// 한 칸씩 왼쪽으로 이동
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else
					break; // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
			}
		}
		System.out.println(Arrays.toString(arr));

		
		
		// 내가 짠 코드
//		for (int i = 0; i < arr.length - 1; i++) {
//			while (arr[i] > arr[i + 1]) {
//				int temp = arr[i + 1];
//				arr[i + 1] = arr[i];
//				arr[i] = temp;
//				System.out.println(Arrays.toString(arr));
//				if (i == 0)
//					break;
//				i--;
//			}
//					
//		}
		
	}
}
