package prob.self;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_백만 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxHeap.add(arr[i]);
			}
			
			Deque<Integer> dq = new ArrayDeque<>();
			int ans = 0;
			int maxV = maxHeap.poll();
			for (int i = 0; i < N; i++) {
				if (maxV > arr[i]) {
					dq.add(arr[i]);
					continue;
				}
				while(!dq.isEmpty()) {
					ans += maxV-dq.poll();
				}
				if (maxHeap.isEmpty()) break;
				maxV = maxHeap.poll();
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
