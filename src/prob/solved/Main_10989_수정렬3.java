package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_10989_수정렬3 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		int temp;
		int[] arr = new int[10_001];
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(in.readLine());
			arr[temp]++;
//			System.out.println("temp : " + temp + ", arr[temp] : " + arr[temp]);
		}
		
		for (int i = 0; i <= 10_000; i++)
			if (arr[i] != 0) {
				int cnt = arr[i]; 
				while(cnt!=0) {
					sb.append(i).append("\n");
					cnt--;
				}
			}
		
		out.write(sb.toString());
		out.flush();
		out.close();
		
	}

}
