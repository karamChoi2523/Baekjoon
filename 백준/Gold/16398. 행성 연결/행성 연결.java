import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int N;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static long min = Long.MAX_VALUE;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		for(int i=0;i<N;i++)
			parent[i] = i;
		
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split(" ");
			
			for(int j=0;j<N;j++) {
				int cost = Integer.parseInt(temp[j]);
				pq.add(new Edge(i, j, cost));
			}
		}
		
		long sum = 0;
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(findParent(curr.from)!=findParent(curr.to)) {
				union(curr.from, curr.to);
				sum += curr.cost;
			}
		}
		System.out.println(sum);
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(px!=py)
			parent[py] = px;
	}
	static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}
}
