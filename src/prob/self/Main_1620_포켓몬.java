package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_포켓몬 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> hm = new HashMap<>();
		Map<Integer, String> hmr = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			hm.put(str, i);
			hmr.put(i, str);
		}
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (hm.containsKey(str)) sb.append(hm.get(str)).append("\n");
			else sb.append(hmr.get(Integer.parseInt(str))).append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}

}
