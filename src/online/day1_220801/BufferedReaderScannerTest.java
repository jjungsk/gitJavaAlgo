package online.day1_220801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferedReaderScannerTest {
	
	// Scanner
//	public static void main(String[] args) throws FileNotFoundException {
//		
//		System.setIn(new FileInputStream("src\\com\\ssafy\\algorithm\\day1_0801\\inputTC.txt"));
//		Scanner sc = new Scanner(System.in);
//		
//		long start = System.nanoTime(); // 프로그램 돌아가는 시간
//		
//		int TC = sc.nextInt();
//		for (int tc = 1; tc <= TC; tc++) {
//			int N = sc.nextInt();
//			int sum = 0;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++)
//					sum += sc.nextInt();
//			}
//			System.out.println("#" + tc + " : " + sum);
//		}
//		long end = System.nanoTime();
//		System.out.println((end-start) / 1_000_000_000.0 + "s");
//	}
	
	// BufferedReader
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\com\\ssafy\\algorithm\\day1_0801\\inputTC.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime(); // 프로그램 돌아가는 시간
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(in.readLine());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++)
					sum += Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + tc + " : " + sum);
		}
		long end = System.nanoTime();
		System.out.println((end-start) / 1_000_000_000.0 + "s");
	}
	
	

}