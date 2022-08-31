package prob.self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_day2_1_1724_연결요소_kruskal {
	
	static class Node implements Comparable<Node> {
		
		int to;
		Node next;
		
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
		
		@Override{
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		
		
	}
	
	static int V, N;
	

}
