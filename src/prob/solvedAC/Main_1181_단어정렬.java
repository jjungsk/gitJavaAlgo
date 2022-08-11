package prob.solvedAC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1181_단어정렬 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < T; i++) {
			list.add(in.readLine());
		}
		
		Collections.sort(list);
				
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int len1 = s1.length();
				int len2 = s2.length();
				if (len1 == len2) {
					return s1.compareTo(s2);
				}
				return len1 - len2;
			}
		});
		
		list.add("A");
//		System.out.println(list);
		
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i).equals(list.get(i+1)))
				continue;
			System.out.println(list.get(i));	
		}
		
	}

}
