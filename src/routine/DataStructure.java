package routine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class DataStructure {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// List & Set & Map & Stack & Queue & Deque & PriorityQueue
		// (1) List : 순서가 있는 데이터의 집합이며 데이터의 중복을 허용한다.
		System.out.println("-------- List ---------");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(11);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2-o1;
			}
			
		});
		System.out.println(list);
		
		
		// (2) Set : 순서를 유지하지 않는 데이터의 집합이며 데이터의 "중복"을 허용하지 않는다.
		System.out.println("-------- Set ---------");
		Set<Integer> set = new HashSet<>();
		
		set.add(3);
		set.add(3);
		set.add(1);
		set.add(3);
		set.add(4);
		set.add(4);
		set.add(5);
		System.out.println(set);
		
		set.remove(5);
		System.out.println(set);
		
		
		// (3) Map : key&value로 이루어진 데이터의 집합
		//			 키와 값을 통하여 hashing을 가능하게 하여 데이터를 검색하는데 뛰어남
		//			 순서는 유지되지 않으며 키는 중복을 허용하지 않고 값은 중복을 허용함
		System.out.println("-------- Map ---------");
		Map<String, Integer> map = new HashMap<>();
		
		map.put("apple", 1);
		map.put("berry", 2);
		map.put("cherry", 3);
		System.out.println(map);
		
		map.remove("apple");
		System.out.println(map);
		
		// (4) Stack & Queue -> ArrayDeque : 양 끝에서 삽입 삭제가 이루어지는 구조
		// 								 기본 stack 과 queue의 기능을 모두 포함하며 서능도 더 좋음 FIFO
		System.out.println("-------- Deque ---------");
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		Deque<Integer> dq = new ArrayDeque<>();
		
		// add 는 기본적으로 꼬리를 통해 head로 보내 버림
		dq.add(1);
		dq.addLast(2);
		dq.add(3);
		System.out.println(dq);
		
		// poll은 head의 값을 빼버림
		dq.poll();
		dq.pollFirst();
		System.out.println(dq);
		
		
		// (5) PriorityQueue : minHeap & maxHeap 값을 쉽게 구하는
		System.out.println("-------- PriorityQueue ---------");
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		
		// (6) TreeMap : 이중 우선순위 큐로 key를 통해 minHeap과 maxHeap 모두 쉽게 구하는
		System.out.println("-------- PriorityQueue ---------");
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		
	}

}
