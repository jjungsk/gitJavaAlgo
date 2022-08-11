package routine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodMorning {
	static char[] src = {'a', 'b', 'c', 'd'};
	static int total = 0;

    public static void main(String[] args) {
//        // 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
//        System.out.println("부분집합");
//        powerset();
//        System.out.println("----------------------------------");
//        
//        // 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
//        System.out.println("조합");
//         makeCombination(3,new char[3], 0);
//         System.out.println("----------------------------------");
//         
        // 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("순열");
         makePermutation(3, new char[3], new boolean[src.length]);
    }

    static void powerset() {
        for(int i=0; i< (1<<src.length); i++) {
            List<Character> includes = new ArrayList<>();
            List<Character> excludes = new ArrayList<>();
            for(int j=0; j < src.length; j++) {
                if((i & (1<<j)) > 0 ) {
                    includes.add(src[j]);
                }else {
                    excludes.add(src[j]);
                }
            }
            total++;
            System.out.println(i + " : " + includes+" : "+excludes);
        }
        System.out.println(total);
    }
    
    static void makeCombination(int toChoose, char [] choosed, int startIdx) {
        if(toChoose == 0) {
            System.out.println(Arrays.toString(choosed));
            return;
        }
        for(int i = startIdx; i < src.length; i++) {
            choosed[choosed.length-toChoose] = src[i];
            makeCombination(toChoose-1, choosed, i+1);
        }
    }
    
    static void makePermutation(int toChoose, char [] choosed, boolean [] visited) {
        if(toChoose == 0) {
            System.out.println(Arrays.toString(choosed));
            return;
        }
        for(int i = 0; i < src.length; i++) {
            if(!visited[i]) {
                visited[i]=true;
                choosed[choosed.length-toChoose] = src[i];
                makePermutation(toChoose-1, choosed, visited);
                visited[i]=false;
            }
        }
    }
}