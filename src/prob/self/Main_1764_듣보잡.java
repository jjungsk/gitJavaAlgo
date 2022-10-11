package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = n+m;
		Map<String, Integer> hm = new HashMap<>();
		List<String> result = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			if (hm.containsKey(str)) {
				result.add(str);
				++cnt;
				continue;
			}
			hm.put(str, 1);
		}
		
		Collections.sort(result, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		
		sb.append(cnt).append("\n");
		for (String str: result)
			sb.append(str).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
