package routine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Daily {
	static char[] src = {'a', 'b', 'c', 'd'};
	static char[] choosed = new char[3];
	static int total = 0;

    public static void main(String[] args) {
    	// 
    	
        // 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
         System.out.println("부분집합");
//         powerset();
         System.out.println("----------------------------------");
        
        // 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
    	 System.out.println("조합");
//    	 comb(3, 0, new char[3]);
         System.out.println("----------------------------------");
         
        // 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
         System.out.println("순열");
//         permutation(3, new char[3], new boolean[src.length]);
//         System.out.println(total);
         
         // 3-2. permutaionBitMasking
//         System.out.println("순열 : 비트마스킹");
//         permutationBitMasking(0, 0);
//         System.out.println(total);
         
         // 4. nextPermutaion
         System.out.println("nextPermutation");
         int[] input = {1,2,4,3};
         Arrays.sort(input);
         do {
        	 System.out.println(Arrays.toString(input));
         } while(np(input));
    }
    
    private static boolean np(int[] numbers) {
    	int N = numbers.length;
    	
    	int i = N-1;
    	while (i>0 && numbers[i-1]>=numbers[i]) --i;
    	if (i == 0) return false;
    	
    	int j = N-1;
    	while( numbers[i-1]>=numbers[j]) j--;
    	swap(numbers, i-1, j);
    	
    	int k = N-1;
    	while(i<k) swap (numbers, i++, k--);
    	
    	return true;
    }
    
    private static void swap(int[] numbers, int i, int j) {
    	int temp = numbers[i];
    	numbers[i] = numbers[j];
    	numbers[j] = temp;
    }
    
    
    private static void permutationBitMasking(int cnt, int flag){
    	if (cnt == 3) {
    		total++;
    		System.out.println(Arrays.toString(choosed));
    		return;
    	}
    	
    	for (int i = 0; i < src.length; i++) {
    		// 시도하는 수가 선택되었는지 판단 (0이 아니라면 즉 겹친다면 continue) 
    		if ( (flag & (1<<i)) != 0 ) continue;
    		choosed[cnt] = src[i];
    		permutationBitMasking(cnt+1, flag | 1<<i);
    	}
    }
    
    private static void powerset() {
    	
    	for (int i = 0; i < (1<<src.length); i++) {
    		List<Character> includes = new ArrayList<>();
    		List<Character> excludes = new ArrayList<>();
    		for (int j = 0; j < src.length; j++) {
    			if ( (i & (1<<j)) > 0)
    				includes.add(src[j]);
    			else
    				excludes.add(src[j]);
    		}
    		System.out.println(includes + " : " + excludes);
    	}
    	
    }
    
    private static void comb(int cnt, int startIdx, char[] choosed) {
    	if (cnt == 0) {
    		total++;
    		System.out.println(Arrays.toString(choosed));
    		return;
    	}
    	
    	for (int i = startIdx; i<src.length; i++) {
    		choosed[choosed.length-cnt] = src[i];
    		comb(cnt-1, i+1, choosed);
    	}
    	
    }
    
    
    private static void permutation(int cnt, char[] choosed, boolean[] visited) {
    	if (cnt == 0) {
    		total++;
    		System.out.println(Arrays.toString(choosed));
    		return;
    	}
    	
    	for (int i=0; i<src.length; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			choosed[choosed.length-cnt] = src[i];
    			permutation(cnt-1, choosed, visited);
    			visited[i] = false;
    		}
    	}
    	
    }

}