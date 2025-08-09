import java.util.*;
import java.io.*;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		long cost;
		
		public Edge(int from, int to, long c) {
			this.from = from;
			this.to = to;
			cost = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	static int V, E;
	static PriorityQueue<Edge> pq;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			pq = new PriorityQueue<>();
			parent = new int[V+1];
			for(int i=1;i<V+1;i++)
				parent[i] = i;
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
			
				pq.add(new Edge(a,b,c));
			}
			
			System.out.printf("#%d %d\n",tc, kruskal());
		}
	}
	private static long kruskal() {
		long sum = 0;
		
		while(!pq.isEmpty()){
			Edge curr = pq.poll();
			if(findParent(curr.from)!=findParent(curr.to)) {
				union(curr.from, curr.to);
				sum += curr.cost;
			}
		}
		return sum;
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(px<py)
			parent[py] = px;
		else
			parent[px] = py;
	}
	static int findParent(int x) {
		while(parent[x]!=x) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		
		return x;
	}
}