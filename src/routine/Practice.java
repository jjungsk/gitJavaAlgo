package routine;

import java.util.ArrayList;
import java.util.List;

public class Practice {
	
	static int[] arr = {1,2,3,4};
	
	public static void main(String[] args) {
		
<<<<<<< HEAD
		List<Integer>[] list;
		list = new ArrayList[10];
		
		for (int i = 0; i < 10; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		list[0].add(1);
		list[0].add(3);
		list[0].add(11);
		
		System.out.println(list[0]);
=======
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
>>>>>>> 09372973d3984ff666fa6092ffea2df0b29cf6f7
		
	}



}
