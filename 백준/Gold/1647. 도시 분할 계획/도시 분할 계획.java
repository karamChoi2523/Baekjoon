import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int cost=0;
		
		public Node() {}
		public Node(int f, int t, int c) {
			from = f;
			to = t;
			cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int[] parent;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		parent = new int[N+1];
		for(int i=1;i<N+1;i++)
			parent[i] = i;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(A,B,C));
		}
		
		
		int answer = 0;
		Node target = new Node();
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(findParent(curr.from) != findParent(curr.to)) {
				union(curr.from, curr.to);
				answer += curr.cost;
				
				if(target.cost<curr.cost)
					target = curr;
			}
		}
		
		System.out.println(answer-target.cost);
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(px!=py)
			parent[py] = px;
	}
	static int findParent(int x) {
		if(parent[x]==x) return x;
		
		return parent[x] = findParent(parent[x]);
	}
}
