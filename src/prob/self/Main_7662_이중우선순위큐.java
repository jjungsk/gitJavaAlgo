package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> tm = new TreeMap<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String comS = st.nextToken();
				int comI = Integer.parseInt(st.nextToken());
				
				if ("I".equals(comS)) {
					tm.put(comI, tm.getOrDefault(comI, 0)+1);
				} else {
					if (tm.size()==0) continue;
					
					if (comI==-1) {
						if (tm.get(tm.firstKey())>1) {
							tm.put(tm.firstKey(), tm.getOrDefault(tm.firstKey(), 0)-1);
						} else {
							tm.remove(tm.firstKey());
						}
					} else {
						if (tm.get(tm.lastKey())>1) {
							tm.put(tm.lastKey(), tm.getOrDefault(tm.lastKey(), 0)-1);
						} else {
							tm.remove(tm.lastKey());
						}
					}
				}
			}
			
			
			if (tm.size()!=0) {
				sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
			} else {
				sb.append("EMPTY").append("\n");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
		
	}

}
