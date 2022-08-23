package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_3124_스패닝_kruskal_UnionFind {
	
	private static class Node implements Comparable<Node>{
		int from, to, weight;
		
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	private static int[] parents;
	private static int V, N;
	
	// kruskal - unionFind Algorithm _ weight - make, find, union
	
	private static void make() {
		parents = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) { // from, to
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); // Vertex 수
			N = Integer.parseInt(st.nextToken()); // Nodes 수
			
			Node[] nodes = new Node[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			
			// make() 함수를 이용하여 서로소 집합 생성
			make();
			
			// Node[] arr를 가중치 w에 따라 오름차순 정렬
			Arrays.sort(nodes);
//			for (Node node: nodes) {
//				System.out.println(node.from + " : " + node.to +" : " + node.weight);
//			}
			
			
			long totalW = 0L;
			int count = 0;
			for (Node node: nodes) {
				if(union(node.from, node.to)) {
					totalW += (long)node.weight;
//					System.out.println(node.from + " : " + node.to + " : " + Arrays.toString(parents));
					if (++count == V-1) break;
				}
			}
//			System.out.println(totalW);
			sb.append("#").append(tc).append(" ").append(totalW).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
