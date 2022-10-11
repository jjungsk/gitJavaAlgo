package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_11723_집합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if ("all".equals(command)) {
				for (int j = 1; j <= 20; j++) {
					if (set.contains(j)) continue;
					set.add(j);
				}
				continue;
			} else if ("empty".equals(command)) {
				set.clear();
				continue;
			}
			int num = Integer.parseInt(st.nextToken());
			
			if ("add".equals(command)) {
				set.add(num);
			} else if ("remove".equals(command)) {
				set.remove(num);
			} else if ("check".equals(command)) {
				if(set.contains(num)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			} else if ("toggle".equals(command)) {
				if(set.contains(num)) set.remove(num);
				else set.add(num);
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
