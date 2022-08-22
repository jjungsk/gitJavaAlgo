package online.day5_220818_그래프;

import java.util.ArrayList;
import java.util.List;

public class PartialSet {
	
	static int ans, target;
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		int[] arr = {5,21,11,16,6,10};
		
		target = 21;
		
		getTarget(0, 0, arr, list);
		
		System.out.println(ans);
		
	}
	
	private static void getTarget(int startIdx, int sum, int[] arr, List<Integer> list) {
		
		if (sum > target) return;
		
		if (sum == target) {
			System.out.println(list);
			ans++;
			return;
		}
		
		for (int i = startIdx; i < arr.length; i++) {
			
			list.add(arr[i]);
			getTarget(i+1, sum+arr[i], arr, list);
			
			int temp = list.size();
			list.remove(temp - 1);
		}
		
	}

}
