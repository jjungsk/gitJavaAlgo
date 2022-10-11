package online.day8_220829_정리;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFS_DFS {
	
	static class Node {
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static int V; // 정점수
	static Node[] adjList; // 인접리스트
	static boolean[] visited; // 방문체크 (dfs)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[V];
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		System.out.println("================dfs=================");
		visited = new boolean[V];
		dfs(0);
		
		System.out.println();
		System.out.println("================bfs=================");
		bfs();
		
	}
	
	static void dfs(int cur) {
		
		visited[cur] = true;
		System.out.print(cur + " ");
		
		for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
			if (!visited[temp.vertex]) {
				dfs(temp.vertex);
			}
		}
		
	}

	static void bfs() {
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
		
	}
	
}
