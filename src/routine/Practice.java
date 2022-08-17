package routine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Practice {
	
	public static void main(String[] args) {
		
		Integer[] arr = {3,4,2,1};
		
		Arrays.sort(arr, new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		do {
			System.out.println(Arrays.toString(arr));
		} while (np(arr));
		
	}
	
	private static boolean np(Integer[] numbers) {
		int N = numbers.length;
		
		// 1
		int i = N-1;
		while (i>0 && numbers[i-1] >= numbers[i]) --i;
		if (i == 0) return false;
		
		// 2
		int j = N-1;
		while (numbers[i-1]>= numbers[j]) j--;
		swap(numbers, i-1, j);
		
		// 2
		int k = N-1;
		while (i<k) swap(numbers, i++, k--);
		
		return true;
		
	}
	
	private static void swap(Integer[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		
	}


}
