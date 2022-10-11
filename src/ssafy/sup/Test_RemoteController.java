package ssafy.sup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test_RemoteController {
	
	static int a, b;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		dfs(0, a);
		
	}
	
	private static void dfs(int cnt, int temp) {
		
		if (cnt >= 40) {
			
			return;
		}
		
		if (temp==b) {
			System.out.println(cnt);
			return;
		}
		
		if (temp < b) {
			dfs(cnt+1, temp+1);
			dfs(cnt+1, temp+5);
			dfs(cnt+1, temp+10);
			
		} else {
			dfs(cnt+1, temp-1);
			dfs(cnt+1, temp-5);
			dfs(cnt+1, temp-10);
		}
		
		
		
	}

}
