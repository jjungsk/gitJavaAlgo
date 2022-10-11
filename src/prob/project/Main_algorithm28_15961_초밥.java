package prob.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_algorithm28_15961_초밥 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
		int k = Integer.parseInt(st.nextToken()); // 연속
		int c = Integer.parseInt(st.nextToken()); // 쿠폰
		
		Set<Integer> set;
		
		int[] dishes = new int[N+k-1];
		for (int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N+k-1; i++) {
			dishes[i] = dishes[i-N];
		}
		
//		System.out.println(Arrays.toString(dishes));
		
		int maxD = 0;
		for (int i = 0; i < N; i++) {
			set = new HashSet<>();
			for (int j = i; j < i+k; j++) {
				set.add(dishes[j]);
			}
			if (set.contains(c)) {
				maxD = Math.max(maxD, set.size());
			} else {
				maxD = Math.max(maxD, set.size()+1);
			}
		}
		
		System.out.println(maxD);
		
	}

}
