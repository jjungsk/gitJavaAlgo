package routine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Daily {
	static char[] src = {'a', 'b', 'c', 'd'};
	static char[] choosed;
	static boolean[] visited;
	static int total, n, r;
	static List<Character> includes;
	static List<Character> excludes;

    public static void main(String[] args) {
    	n = 4;
    	r = 3;
    	choosed = new char[r];
    	visited = new boolean[n];
    	
    	// 순열 (nPr)
    	permutation(0);
    	System.out.println(total);
    	
    	// 조합
    	total = 0;
    	combination(0, 0);
    	System.out.println(total);
    	
    	// 부분 집합
    	total = 0;
    	powerset();
    	
    }
    
    private static void powerset() {
    	for (int i = 0; i < (1<<n); i++) {
    		includes = new ArrayList<Character>();
    		excludes = new ArrayList<Character>();
    		
    		for (int j = 0; j < n; j++) {
    			if ((i & (1<<j)) > 0) {
    				includes.add(src[j]);
    			} else
    				excludes.add(src[j]);
    		}
    		System.out.println(includes + " : " + excludes);
    		total++;
    	}
    }
    
    private static void combination(int cnt, int startIdx) {
    	if (cnt == r) {
    		System.out.println(Arrays.toString(choosed));
    		total++;
    		return;
    	}
    	
    	for (int i = startIdx; i < n; i++) {
    		choosed[cnt] = src[i];
    		combination(cnt+1, i+1);
    	}
    }
    
    private static void permutation(int cnt) {
    	if (cnt == r) {
    		System.out.println(Arrays.toString(choosed));
    		total++;
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			choosed[cnt] = src[i];
    			permutation(cnt+1);
    			visited[i] = false;
    		}
    	}
    	
    }
    
}