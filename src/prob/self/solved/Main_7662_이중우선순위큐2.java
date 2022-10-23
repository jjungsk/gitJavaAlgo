package prob.self.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐2 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			
			Map<Integer, Integer> tm = new TreeMap<>();
			
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			
			String[] commandStr = new String[K];
			int[] commandInt = new int[K];
			
			int cntI = 0;
			int cntD = 0;
			boolean flag = true;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String comS = st.nextToken();
				int comI = Integer.parseInt(st.nextToken());
				
				commandStr[i] = comS;
				commandInt[i] = comI;
			}
			
			for (int i = 0 ; i < K; i++) {
				String comS = commandStr[i];
				int comI = commandInt[i];
				if ("I".equals(comS)) {
					minHeap.add(comI);
					maxHeap.add(comI);
					++cntI;
				} else {
					if (cntI==cntD && flag) {
						sb.append("EMPTY").append("\n");
						flag = false;
						break;
					}
					if (comI==-1) {
						while (!maxHeap.contains(minHeap.poll())) {
							if (minHeap.isEmpty()) break;
						}
						++cntD;
					} else {
						while (!minHeap.contains(maxHeap.poll())) {
							if (maxHeap.isEmpty()) break;
						}
						++cntD;
					}
				}
			}
			
			if (flag) {
				sb.append(maxHeap.poll()).append(" ").append(minHeap.poll()).append("\n");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
		
	}

}
