package prob.solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {
	
	private static int[] arrN;
	private static int[] cnt;
	private static int result;
	
	private static void add(char c) {
		switch(c) {
		case 'A':
			cnt[0] += 1;
			if (cnt[0] == arrN[0])
				result++;
			break;
		case 'C':
			cnt[1] += 1;
			if (cnt[1] == arrN[1])
				result++;
			break;
		case 'G':
			cnt[2] += 1;
			if (cnt[2] == arrN[2])
				result++;
			break;
		case 'T':
			cnt[3] += 1;
			if (cnt[3] == arrN[3])
				result++;
			break;
		}
	}
	
	private static void del(char c) {
		switch(c) {
		case 'A':
			if (cnt[0] == arrN[0])
				result--;
			cnt[0] -= 1;
			break;
		case 'C':
			if (cnt[1] == arrN[1])
				result--;
			cnt[1] -= 1;
			break;
		case 'G':
			if (cnt[2] == arrN[2])
				result--;
			cnt[2] -= 1;
			break;
		case 'T':
			if (cnt[3] == arrN[3])
				result--;
			cnt[3] -= 1;
			break;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// input n, m
		st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		cnt = new int[4];
		result = 0;
		int ans = 0;
		
		String str = in.readLine();
		char[] arr = new char[n];
		for (int i = 0; i < n; i++)
			arr[i] = str.charAt(i);
		arrN = new int[4];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
			if (arrN[i] == 0)
				result++;
		}
		
		// m열 arr로 초기
		for (int i = 0; i < m; i++) {
			add(arr[i]);
		}
		if (result == 4)
			ans++;
//		System.out.println(Arrays.toString(cnt));
//		System.out.println("만족 조건 : " + result + ", 정답 : " + ans);
		
		// slideWindow
		for (int i = 0; i < n - m; i++) {
//			System.out.println(Arrays.toString(arr));
			del(arr[i]);
			
			add(arr[i + m]);
//			System.out.println("-----------------------");
//			System.out.println("i : " + i + ", arr[i] : " + arr[i] + ", arr[i + m] : " + arr[i + m]);
			if (result == 4)
				ans++;
//			System.out.println(Arrays.toString(cnt));
//			System.out.println("만족 조건 : " + result + ", 정답 : " + ans);
		}
		
//		System.out.println(result);
//		System.out.println(ans);
		
		out.write(Integer.toString(ans));
		out.flush();
		out.close();

	}

}
