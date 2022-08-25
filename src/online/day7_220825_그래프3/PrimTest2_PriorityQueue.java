package online.day7_220825_그래프3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest2_PriorityQueue {
	
	static class Node {
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 무향 처리
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		// 프림 알고리즘에 필요한 자료구조
		int[] minEdge = new int[V]; // 각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용 중 최소 비용
		boolean[] visited = new boolean[V]; // 신장트리에 포함 여부
		
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 관리하기 위해 큰 값 셋팅
		
		
		// 1. 임의의 시작점 처리, 0번 정점을 신장트리의 구성의 시작점
		minEdge[0] = 0; // 초기화
		int result = 0; // 최소 신장트리 비용 누적
		
		/////////////////////////////////// 변경 /////////////////////////////
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pQueue.offer(new Vertex(0, minEdge[0]));
		
		int cnt = 0; // 신장트리에 추가된 정점 수
		while (!pQueue.isEmpty()) { // V개의 정점 처리하면 끝
			
			// step 1. 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점 선택
			Vertex minVertex = pQueue.poll();
			
			/////////// 변경 ////////////
			if(visited[minVertex.no]) continue;
			
			// step 2. 신장트리에 추가
			visited[minVertex.no] = true;
			result += minVertex.weight;
			if (++cnt == V) break;
			
			
			// step 3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교해서 갱신
			//         신장트리에 새롭게 추가되는 정점의 모든 인접 정점 들여다보며 처리
			for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pQueue.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
				}
			}
		}
		
		System.out.println(result);
		
	}
	
}
