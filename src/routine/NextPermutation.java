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
		while (i > 0 && numbers[i-1] > numbers[i]) --i;/
		
		return true;
		
	}
	
	
	
}
