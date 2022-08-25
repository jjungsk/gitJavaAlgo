package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11659_arrSum4 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++)
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
//		System.out.println(Arrays.toString(arr));
		for (int cnt = 0; cnt < M; cnt++) {
			st = new StringTokenizer(in.readLine(), " ");
			int idI = Integer.parseInt(st.nextToken());
			int idJ = Integer.parseInt(st.nextToken());
			sb.append(arr[idJ] - arr[idI - 1]).append("\n");
		}
		out.write(sb.toString() + "\n");
		out.flush();
		out.close();
	}
}
