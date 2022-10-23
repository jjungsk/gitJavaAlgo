package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16953_AB_SK_s2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(B);
		
		// Queue 로 넣으면 정답..
		int cur = 0;
		while (!dq.isEmpty()) {
			cur = dq.poll();
			if (cur <= A) break;
			if (cur%2==0) {
				dq.add(cur/2);
				cnt++;
			}
			if (cur%10==1) {
				dq.add(cur/10);
				cnt++;
			}
		}
		
		// 오답..
//		while (B>A) {
//			if (B%2==0) {
//				B /= 2;
//				cnt++;
//			}
//			if (B%10==1) {
//				B /= 10;
//				cnt++;
//			}
//		}
//		if (B==A) sb.append(cnt);
//		else sb.append(-1);
		
		if (cur==A) sb.append(cnt);
		else sb.append(-1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
