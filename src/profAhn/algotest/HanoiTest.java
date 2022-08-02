package profAhn.algotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTest {
	
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(in.readLine());
		hanoi(cnt, 1, 2, 3);
		System.out.println(result);
	}
	
	private static void hanoi(int cnt, int from, int temp, int to) {
		if (cnt == 0) return;
		
		hanoi(cnt - 1, from, to, temp);
		result.append(cnt + " : " + from + " --> " + to + "\n");
		hanoi(cnt - 1, temp, from, to);
	}

}
