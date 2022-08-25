package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2023_신기한소수 {
	
	public static boolean prime(int x) {
		int end = (int) Math.sqrt(x);
		for (int i = 2; i <= end; i++)
			if (x % i == 0) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int cnt = 1;
		int[] initA = {2, 3, 5, 7};
		List<Integer> ansL = new ArrayList<>();
		List<Integer> tempL = new ArrayList<>();
		for (int x: initA)
			ansL.add(x);
		
		boolean flag = true;
		while(cnt != n) {
			for (int x: ansL) {
				for (int i = x*10; i < (x+1)*10; i++) {
					flag = prime(i);
					if (!flag)
						continue;
					tempL.add(i);
				}
			}
			ansL.clear();
			for (int k: tempL)
				ansL.add(k);
			tempL.clear();
			cnt++;
		}
		for (int ans: ansL)
			System.out.println(ans);
	}

}
