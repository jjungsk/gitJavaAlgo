package routine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// nPn
public class NextPermutation {
	
	private static String input = "4\r\n" + 
								  "1 3 2 4\r\n" +
								  "";
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new StringReader(input));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Integer[] input = new Integer[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 전처리 masking? : 순열에 쓰일 수들을 오름차순 정렬
		Arrays.sort(input, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				// TODO Auto-generated method stub
				return i1-i2;
			}
		});
		
		System.out.println(Arrays.toString(input));
		
	}
	
	public static boolean np(int[] numbers) {
		
		int N = numbers.length;
		
		// 1. 꼭대기 찾기
		int i = N-1;
		// i>0: 첫번째 원소가 안될때 & 뒷 숫자와 바로 앞 숫자 비교
		while (i > 0 && numbers[i-1] > numbers[i]) --i;
		
		// 12345의 배열이 54321로 완전 끝났을때
		if (i==0) return false;
		
		// 2. 꼭대기의 바로 앞자리 (i-1)의 값을 크게 만들 교환 값 찾기
		int j = N-1;
		while (numbers[i-1]>=numbers[j]) j--;
		swap(numbers, i-1, j);
		
		// 3. i 위치부터 맨 뒤까지의 수열을 가장 작은 형태의 오름차순으로 정렬
		int k = N-1;
		while (i<k) swap(numbers, i++, k--);
		
		return true;
		
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	
	
}
