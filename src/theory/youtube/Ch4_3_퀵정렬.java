package theory.youtube;

import java.util.Arrays;

public class Ch4_3_퀵정렬 {
	/*
		[퀵 정렬]
		기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
		일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나
		병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리릐 근간
		가장 기본적인 퀵 정렬은 첫 번째 데이터를 기준 데이터(pivot)로 설정
		
		이상적인 경우 분할이 절반씩 일어난다면 전체 연산 횟수로 O(N*logN)을 기대할 수 있다
			-> 너비 * 높이
	 */
	
	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end ) return; // 원소가 1개인 경우 종료
		int pivot = start; // 피벗은 첫번째 index
		int left = start + 1;
		int right = end;
		
		while (left <= right) {
			// 피벗보다 큰 데이터를 찾을 때까지 반복
			while (left <= end && arr[left] <= arr[pivot])
				left++;
			// 피벗보다 작은 데이터를 찾을 때까지 반복
			while (right > start && arr[right] >= arr[pivot])
				right--;
			
			// 엇갈렸다면 작은 데이터와 피벗을 교체 -> while문 탈출
			if (left > right) {
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
				System.out.println("엇갈림 : " + Arrays.toString(arr));
			}
			// 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
			else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				System.out.println("엇갈리지 않음 : " + Arrays.toString(arr));
			}
		}
		// 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
		quickSort(arr, start, right - 1);
		quickSort(arr, right + 1, end);
	}
	
	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
		
		quickSort(arr, 0, 9);
//		System.out.println(Arrays.toString(arr));
	}

}
