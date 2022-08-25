package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_3040_for문 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int target = 100;
		int arrS = 0;
		int[] arr = new int[9];
		for (int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			arrS += arr[i];
		}
		
		int overN = arrS - target;
		// method 구현부분
		loop:
		for (int i = 0; i<8; i++) {
			for (int j = i+1; j<9; j++) {
				if (arr[i]+arr[j] == overN) {
					for (int k=0; k<9; k++) {
						if (k!=i && k!=j)
							sb.append(arr[k]).append("\n");
					}
					break loop;
				}
			}
		}
		
		
		// 출력
		out.write(sb.toString());
		out.flush();
		out.close();
		
		
	}

}
