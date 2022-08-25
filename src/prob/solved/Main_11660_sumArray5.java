package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11660_sumArray5 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[(N + 1) * (N + 1) + 1];
		int[] arrS = new int[(N + 1) * (N + 1) + 1];
		
		for (int j = 1; j < N + 1; j++) {
			st = new StringTokenizer(in.readLine(), " ");
			int[] tmpA = new int[N + 1];
			int tmpI = 1;
			for (int i = j * (N + 1) + 2; i < (j + 1) * (N + 1) + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				tmpA[tmpI] = tmpA[tmpI-1] + arr[i];
				arrS[i] = arrS[i - N - 1] + tmpA[tmpI - 1] + arr[i];
				tmpI++;
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arrS));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
//			int so1 = arrS[x2 * (N + 1) + y2 + 1];
//			int so2 = arrS[x2 * (N + 1) + y1];
//			int so3 = arrS[(x1 - 1) * (N + 1) + y2 + 1];
//			int so4 = arrS[(x1 - 1) * (N + 1) + y1];
//			System.out.println(so1);
//			System.out.println(so2);
//			System.out.println(so3);
//			System.out.println(so4);
			
 			int sum = arrS[x2 * (N + 1) + y2 + 1] - arrS[x2 * (N + 1) + y1] - arrS[(x1 - 1) * (N + 1) + y2 + 1] + arrS[(x1 - 1) * (N + 1) + y1];
			sb.append(sum).append("\n");
		}
//		System.out.println(sb.toString());
		out.write(sb.toString() + "\n");
		out.flush();
		out.close();
	}

}
