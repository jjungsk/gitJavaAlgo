package prob.study;

import java.util.Scanner;

public class BOJ_17626_FourSquares_SK {
	
	static int answer = 4;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		
		findSquare(0, 0, num);
			
		
		System.out.println(answer);
	}

	private static void findSquare(int cnt, int start, int num) {
		
		if (num==0) {
			answer = Math.min(answer, cnt);
		}
		if (cnt>=4) {
			return;
		}
		
		int sq = (int)Math.sqrt(num);
		for (int i = sq; i >= sq/2-1; i--) {
			findSquare(cnt+1, i, num-i*i);
		}
		
		return;
	}

}
