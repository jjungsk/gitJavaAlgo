package prob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());

		for (int i = 2; i < 10; i++) {
			recursive(size, i, sb);
		}
		System.out.println(sb);
		
	}
	
	
	static void recursive(int size, int num, StringBuilder sb) {
		if(size == 0) return;
		
		int sqrt = (int)Math.sqrt(num) + 1;
		boolean isPrime = true;
		
		// prime 확인 함수
		for (int i = 2; i < sqrt; i++) {
			if(num % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime && size == 1) {
			sb.append(num).append("\n");
		} else if(isPrime && size != 1){
			for (int i = 1; i < 10; i++) {
					recursive(size - 1, num*10 + i, sb);
			}
		}
		
		
	}
	
}