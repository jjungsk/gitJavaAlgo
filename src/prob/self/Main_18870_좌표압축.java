package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
			list.add(cur);
		}
		Collections.sort(list);
		
		Map<Integer, Integer> hashMap = new HashMap<>();
		
		int rank = 0;
		for (int i = 0; i < N; i++) {
			if (hashMap.containsKey(list.get(i))) continue;
			hashMap.put(list.get(i), rank++);
		}
		
		for (int a: arr) {
			sb.append(hashMap.get(a)).append(" ");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
