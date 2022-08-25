package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2839_설탕배달 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = -1;
		
		for (int i = N/5, cnt3 = 0; i >=0; i--) {
			int remain = N - i*5;
			cnt3 = remain/3;
			remain -= cnt3*3; 
			if (remain == 0) {
				ans = cnt3 + i;
				break;
			}
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
		bw.close();
		
	}

}
