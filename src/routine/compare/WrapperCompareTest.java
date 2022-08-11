package routine.compare;

import java.util.*;

public class WrapperCompareTest {

	public static void main(String[] args) {
		// primitive type은 arrays. 가 가진 sort 이용 하면 됨
		int[] num1 = {50, 24, 67, 85, 72, 31, 9, 7, 36};
		Arrays.sort(num1);
		System.out.print("0. [");
		int len = num1.length;
		for (int i = 0; i < len - 2; i++) {
			System.out.print(num1[i] + ", ");
		}
		System.out.println(num1[len - 1] + "]");
		
		
		// Integer 와 같은 class는 Wrapper class (= 기본 class) 이다. (String, Date, Character, File Class들은 Comparable<T>이 구현되어 있다.
		// 사전순 정렬 즉 오름차순 정렬이 default
		// Object Class
		Integer[] num2 = {50, 24, 67, 85, 72, 31, 9, 7, 36};
		// 오른차순
//		Arrays.sort(num2);
		// 내림차순
		List<Integer> numList = Arrays.asList(num2);
//		System.out.println(numList);
		
		// 오름차순
//		Collections.sort(numList);

		
		Collections.sort(numList, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1.intValue() - i2.intValue(); // 오름차순
//				return i2.intValue() - i1.intValue(); // 내림차순
			}
		});
		
		System.out.println(numList);
		
		Collections.reverse(numList); // 내림차순
		System.out.println(numList);
		
	}

}
