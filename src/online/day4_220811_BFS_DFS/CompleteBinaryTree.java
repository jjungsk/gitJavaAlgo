package online.day4_220811_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 완전 이진트리 (자식노드가 2개로만 구성)
public class CompleteBinaryTree {

	private char[] nodes;
	private int lastIndex; // 마지막 노드의 인덱스
	private final int SIZE;
	
	// Constructor
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new char[size+1]; // 1 인덱스 부터 사용
	}
	
	// Add method
	public boolean add(char e) { // 완전이진트리에 맞게 추가
		if (lastIndex == SIZE) {
			return false;
		}
		nodes[++lastIndex] = e;
		return true;
	}
	
	// BFS(1) 구현 method
	public void bfs() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트노드 인덱스 부터
		
		while (!queue.isEmpty()) { // 방문대상이 있을때까지 반복
			int current = queue.poll(); // 방문차례인 대상 정보 꺼내기
			System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
			
			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if(current*2 <= lastIndex) queue.offer(current*2); // 왼쪽 자식
			if(current*2+1 <= lastIndex) queue.offer(current*2+1); // 오른쪽 자식
			
		}
		System.out.println();
		
	}
	
	// BFS(2) 구현 method
	public void bfs2() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트노드 인덱스 부터
		
		while (!queue.isEmpty()) { // 방문대상이 있을때까지 반복
			int size = queue.size();
			
			while(size-- > 0) { // 반복 진입 전 구한 큐 크기 만큼만 반복
				
				int current = queue.poll(); // 방문차례인 대상 정보 꺼내기
				System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
				
				// 현재 방문노드의 자식노드들을 대기열에 넣기
				if(current*2 <= lastIndex) queue.offer(current*2); // 왼쪽 자식
				if(current*2+1 <= lastIndex) queue.offer(current*2+1); // 오른쪽 자식
				
			}
			System.out.println();
			
		}
		System.out.println();
		
	}
	
	// DFS 구현 method
	public void dfs() {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1); // 루트노드 인덱스 부터
		
		while (!stack.isEmpty()) { // 방문대상이 있을때까지 반복
			int current = stack.pop(); // 방문차례인 대상 정보 꺼내기
			System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
			
			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if(current*2 <= lastIndex) stack.push(current*2); // 왼쪽 자식
			if(current*2+1 <= lastIndex) stack.push(current*2+1); // 오른쪽 자식
			
		}
		System.out.println();
		
	}
	
	public void dfsByPreOrder(int current) {
		
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
		
		// 현재 방문노드의 자식노드들을 대기열에 넣기
		if(current*2 <= lastIndex) dfsByPreOrder(current*2); // 왼쪽 자식
		if(current*2+1 <= lastIndex) dfsByPreOrder(current*2+1); // 오른쪽 자식
		
	}
	
	public void dfsByInOrder(int current) {
		// 기저조건
		if(current >lastIndex) return;
		
		// 현재 방문노드의 자식노드들을 대기열에 넣기
		dfsByInOrder(current*2); // 왼쪽 자식
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
		
		dfsByInOrder(current*2+1); // 오른쪽 자식
		
	}
	
	public void dfsByPostOrder(int current) {
		// 기저조건
		if(current >lastIndex) return;
		
		// 현재 방문노드의 자식노드들을 대기열에 넣기
		dfsByPostOrder(current*2); // 왼쪽 자식
		dfsByPostOrder(current*2+1); // 오른쪽 자식
		
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
		
	}
	
	
	
}
