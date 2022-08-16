package prob.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<>();
		
		for (int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] temp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			list.add(temp);
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[1]-o2[1] == 0) ?o1[0]-o2[0]:o1[1]-o2[1];
			}
		});
		
//		for(int[] a: list)
//			System.out.println(Arrays.toString(a));
		
		int ans = 1;
		int init = list.get(0)[1];
		for (int i = 1; i < N; i++) {
			if (init >= list.get(i)[0]) continue;
			
			init = list.get(i)[1];
			ans++;
		}
				
		System.out.println(ans);
		
	}

}
