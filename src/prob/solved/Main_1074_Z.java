package prob.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		cnt = N;
		int end = (int)(Math.pow(2, cnt));
		
//		for (int i = 0; i < end; i++) {
//			for (int j = 0; j < end; j++) {
//				r = i;
//				c = j;
//				getVisited(cnt, 0, end, 0, end);
//				System.out.print(ans + " ");
//				ans = 0;
//			}
//			System.out.println();
//		}
		
//		System.out.println(end-1);
		ans = 0;
		getVisited(cnt, 0, end, 0, end);
		System.out.println(ans);
		
		
		
	}
	
	static int ans, cnt, r, c;
	
	private static void getVisited(int cnt, int startR, int endR, int startC, int endC) {
		
//		long midR = (endR+startR)/2;
//		long midC = (endC+startC)/2;
		int sum = (int)Math.pow(4, cnt-1);
		
		if (cnt == 1) {
			if ( startR == r ) {
				if ( startC != c) ans += 1;
			} else {
				if ( startC == c) ans += 2;
				else ans += 3;
			}
			return;
		}
		
		// section 1, 2, 3, 4로 나누기
		if ( startR<=r && r<(endR+startR)/2 ) {
			if ( startC<=c && c<(endC+startC)/2) {
				getVisited(cnt-1, startR, (endR+startR)/2, startC, (endC+startC)/2);
				return;
			}
			else {
				ans += sum;
				getVisited(cnt-1, startR, (endR+startR)/2, (endC+startC)/2, endC);
				return;
			}
		} else if ( (endR+startR)/2<=r && r<endR ) {
			if ( startC<=c && c<(endC+startC)/2) {
				ans += sum*2;
				getVisited(cnt-1, (endR+startR)/2, endR, startC, (endC+startC)/2);
				return;
			}
			else {
				ans += sum*3;
				getVisited(cnt-1, (endR+startR)/2, endR, (endC+startC)/2, endC);
				return;
			}
		}
		
		return;
	}
	
	
	

}
