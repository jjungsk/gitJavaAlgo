package routine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
	
	private static char[] src = {'A', 'B', 'C', 'D'};
	private static int total = 0;
	
	public static void main(String[] args) {

//		(1)powerset
		System.out.println("powerset");
		powerset();
		
//		(2) combination
//		System.out.println("comb");
//		comb(3, new char[3], 0);
//		System.out.println(total);
		
//		(3) permutation
//		System.out.println("permutation");
//		perm(3, new char[3], new boolean[src.length]);
//		System.out.println(total);
	}
	
	
	private static void powerset() {
		for (int i=0; i<(1<<src.length);i++) {
			List<Character> includes = new ArrayList<>();
			List<Character> excludes = new ArrayList<>();
			for (int j=0; j < src.length;j++) {
				if ((i& (1<<j)) > 0) // ( != 0 )
					includes.add(src[j]);
				else
					excludes.add(src[j]);
			}
			total++;
			System.out.println("i : " + includes + " : " + excludes);
			
		}
		System.out.println(total);
				
		
	}
	
	
	private static void comb(int cnt, char[] choosed, int startIdx) {
		if (cnt == 0) {
			total++;
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int i=startIdx; i<src.length; i++) {
			choosed[choosed.length-cnt] = src[i];		
			comb(cnt-1, choosed, i+1);
		}
		
	}
	
	
	private static void perm(int cnt, char[] choosed, boolean[] visited) {
		
		if  (cnt == 0) {
			total++;
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for (int i =0; i <src.length; i++)
			if (!visited[i]) {
				visited[i] = true;
				choosed[choosed.length-cnt] = src[i];
				perm(cnt-1, choosed, visited);
				visited[i] = false;
			}
		
		
	}

}
