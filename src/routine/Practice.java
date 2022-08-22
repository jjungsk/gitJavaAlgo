package routine;

import java.util.ArrayList;
import java.util.List;

public class Practice {
	
	public static void main(String[] args) {
		
		List<Integer>[] list;
		list = new ArrayList[10];
		
		for (int i = 0; i < 10; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		list[0].add(1);
		list[0].add(3);
		list[0].add(11);
		
		System.out.println(list[0]);
		
	}



}
