package prob.self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_세수의합_self {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // arr 배열 수
		int K = Integer.parseInt(st.nextToken()); // target 수
		
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 5; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
			map.put(cur, map.getOrDefault(cur, 0)+1); // map에 넣어 준다
			
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
//			if (!map.containsKey(arr[i])) map.put(arr[i], -1);
//			else map.put(arr[i], map.get(arr[i])-1);
			map.put(arr[i], map.get(arr[i])-1);
			for (int j = 0; j < i; j++) {
				if (!map.containsKey(K-arr[i]-arr[j])) continue;
				cnt += map.get(K-arr[i]-arr[j]);
				System.out.println(map);
				System.out.println(arr[i] + " : " + arr[j] + " : " + (K-arr[i]-arr[j]) + " : " + map.get(K-arr[i]-arr[j]));
			}
			System.out.println("--------------");
		}
	
		System.out.println(cnt);
		
	}

}
