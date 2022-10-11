package online.day8_220829_정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PCSTest {
	
	static int N, R, input[], numbers[]; // input : 입력 수배열, numbers : 순열, 조합에 선택된 수배열
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N]; // 부분집합 구성에 포함여부
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println("======== 순열 ==========");
		
		System.out.println("======== 조합 ==========");
		
		System.out.println("======== 부분 집합 ==========");
		
	}
	
	public static void permutation(int cnt, int flag) {
		
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ( (flag & 1 << i) != 0) continue; // 비트확인 -> 조건체크 (사용 확인)
			numbers[cnt] = input[i]; 
			permutation(cnt+1, flag | 1<<i); // 비트 합치기 -> 사용 처리
		}
	}
	
	public static void combination (int cnt, int start) {
		
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
	
	public static void subset(int cnt) {
		
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.println( (isSelected[i] ? input[i]: "X") + " ");
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
	}

}
