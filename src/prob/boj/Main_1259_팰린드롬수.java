package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수 {  
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "1";
		loop:
		while (true) {
			str = in.readLine();
			int n = str.length();
			
			if (str.equals("0"))
				break loop;
			
			boolean flag = true;
			for (int i = 0; i < n / 2; i++) {
				if (str.charAt(i) != str.charAt(n-1-i)) {
					flag = false;
					break;
				}
			}
			if (flag) System.out.println("yes");
			else System.out.println("no");
		}
		
	}

}
