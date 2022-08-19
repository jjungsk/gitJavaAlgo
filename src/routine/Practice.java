package routine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Practice {
	
	static int[] arr = {1,2,3,4};
	
	public static void main(String[] args) {
		
		powerset();
		
	}
	
	private static void powerset() {
		
		for (int i = 0; i < (1<<arr.length); i++) {
			List<Integer> includes = new ArrayList<>();
			List<Integer> excludes = new ArrayList<>();
			
			for (int j = 0; j < arr.length; j++) {
				if ( (i & (1<<j)) > 0) {
					includes.add(arr[j]);
				} else {
					excludes.add(arr[j]);
				}
			}
			
			System.out.println(includes + " : " + excludes);
			
		}
		
	}


}
