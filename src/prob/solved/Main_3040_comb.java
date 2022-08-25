package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_3040_comb {
	
	private static int overN, wow;
	private static int[] overA = new int[2];
	private static int[] arr = new int[9];
	private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int target = 100;
		int arrS = 0;
		for (int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			arrS += arr[i];
		}
		
		overN = arrS - target;
		// method 구현부분
		
		comb(2, 0, overA, false);

//		System.out.println("wow : " + wow);
		
	}
	
	private static void comb(int cnt, int startIdx, int[] overA, boolean flag) throws IOException {
		
		if (cnt == 0) {
			wow++;
			if (arr[overA[0]]+arr[overA[1]]==overN) {
				for (int i = 0; i <9; i++) {
					if (i==overA[0] || i==overA[1]) continue;
					sb.append(arr[i]).append("\n");
//					System.out.println(arr[i]);
				}
				out.write(sb.toString());
				out.flush();
				out.close();
			}

			return;
		}
		
		for (int i=startIdx; i<9; i++) {
			overA[2-cnt] = i;
			if (cnt==1 && arr[overA[0]]+arr[i] != overN) continue;
			comb(cnt-1, i+1, overA, flag);
		}
		
	}

}
