package prob.self.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279_최대힙 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				if (maxHeap.isEmpty()) sb.append(0).append("\n");
				else sb.append(maxHeap.poll()).append("\n");
			} else {
				maxHeap.add(num);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
