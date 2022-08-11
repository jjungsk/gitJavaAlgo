package routine.compare;

import java.util.*;

public class StringCompareTest {
	
	public static void main(String[] args) {
		String[] word = {"boy", "Cat", "Lion", "dog", "elephant", "i", "dragon", "Any", "giraffe", "animal", "Dogcat", "girl", "gial"};
		
		List<String> list = Arrays.asList(word);
		System.out.println(list);
		
		// String 사전순 정렬은 아스키 코드 순서로
		// String class의 compareTo() 는 ASCII를 비교.
		// 오름차순 정렬
		Collections.sort(list);
		System.out.println(list);
		
		// 내림차순 정렬
		Collections.reverse(list);
		System.out.println(list);
		
		// Q. 문자열의 길이로 내림차순 정렬 후 사전 순 정렬 (길이 -> 사전) 즉, Comparator 사용!!! <-> Comparable
		
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String s1, String s2) {
				int len1 = s1.length();
				int len2 = s2.length();
				if (len1 != len2)
					return len1 - len2; // 문자열 길이에 따른 오름차순 정렬
				// String s1.compareTo(s2) return int = this.charAt(k)-anotherString.charAt(k) by ASCII code 첫 문자 비교
				return s1.compareTo(s2) * -1; // 문자열 길이가 같을때 내림차순으로 정렬 (gial -> girl 이 girl -> gial로 순서 변경);
			}
			
		});
		System.out.println(list);
		
//		Collections.sort(list, new Comparator<String>() {
//			
//			@Override
//			public int compare(String s1, String s2) {
//				s1.charAt(0)
//				return 1;
//			}
//			
//		});
		
		
	}

}
