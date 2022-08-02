package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1244_Switch {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine(), " ");
		
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// 남성
			if (gender == 1) {
				for (int m = num - 1; m < n; m += num)
					arr[m] = (arr[m] == 1)? 0: 1;
			} else { 										// 여성
				int idL = num - 1;
				int idR = num - 1;
				for (int inc = 0; idL-inc >=0 && idR+inc <= n-1 && arr[idL-inc] == arr[idR+inc]; inc++) {
					arr[idL-inc] = (arr[idL-inc] == 1)? 0: 1;
					arr[idR+inc] = arr[idL-inc];
//				while (arr[idL-inc] == arr[idR+inc] && idR+inc <= n && idL-inc >= 0) {
//					arr[idL-inc] = (arr[idL-inc] == 1)? 0: 1;
//					arr[idR+inc] = arr[idL-inc];
//					inc++;
				}
			}
		}
		
		for (int ans = 0; ans < arr.length; ans++)
			sb.append(arr[ans]).append((ans+1) % 20 == 0? "\n": " ");
		System.out.println(sb);
		
	}

}
