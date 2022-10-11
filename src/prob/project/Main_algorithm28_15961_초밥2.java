package prob.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_algorithm28_15961_초밥2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
		int k = Integer.parseInt(st.nextToken()); // 연속
		int c = Integer.parseInt(st.nextToken()); // 쿠폰
		
		Deque<Integer> dq = new ArrayDeque<>();
		Map<Integer, Integer> hm = new HashMap<>();
		
		int[] dishes = new int[N+k-1];
		for (int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
			dq.add(dishes[i]);
		}
		for (int i = N; i < N+k-1; i++) {
			dishes[i] = dishes[i-N];
			dq.add(dishes[i]);
		}
		
		int cur = 0;
		for (int i = 0; i < k; i++) {
			cur = dq.poll();
			hm.put(cur, hm.getOrDefault(cur, 0)+1);
		}
		int maxD = hm.containsKey(c)? hm.size(): hm.size()+1;
		
		int cnt = 0;
		int temp = 0;
		while(!dq.isEmpty()) {
			// (0) maxD가 이미 최댓 값 이라면 
			if (maxD == k+1) break;
			
			// (1) head 삭제
			cur = dishes[cnt++];
			if (hm.get(cur)>1) hm.put(cur, hm.get(cur)-1);
			else hm.remove(cur);
			
			// (2) tail 추가
			cur = dq.poll();
			hm.put(cur, hm.getOrDefault(cur, 0)+1);
			
			// (3) 크기 update
			temp = hm.containsKey(c)? hm.size(): hm.size()+1;
			maxD = maxD > temp? maxD: temp;
		}
		
		
		System.out.println(maxD);
		
		
	}

}
