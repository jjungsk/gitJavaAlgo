package online.day10_221004_Dijkstra;

import java.io.IOException;
import java.util.Arrays;

// permTeset
public class Solution_보충_1 {
	
	static int[] p = {1,2,3,4,5};
	static int N=p.length;
	static int R;
	static boolean[] visited;
	static int[] nums;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		R = 3; // 5p3
		count = 0;
		visited = new boolean[N];
		nums = new int[R];
		
		npr(0, 0);
		
		System.out.println(count);
		
	}
	
	private static void npr(int cnt, int start) {
		if (cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		
		for (int i =start; i < N; i++) {
			visited[i] = true;
			nums[cnt] = p[i];
			
			npr(cnt+1, i+1);
			
			visited[i] = false;
			nums[cnt] = 0;
			
		}
		
	}

}
