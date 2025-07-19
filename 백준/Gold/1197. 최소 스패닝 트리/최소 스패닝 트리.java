import java.util.*;
import java.io.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		long cost;
		
		public Edge(int a, int b, long c) {
			this.a = a;
			this.b = b;
			cost = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (int)(this.cost-o.cost);
		}
	}

	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		
		for(int i=1;i<V+1;i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long C = Long.parseLong(st.nextToken());
			
			if(A<=B)
				pq.add(new Edge(A,B,C));
			else
				pq.add(new Edge(B,A,C));
		}
		
		long answer = 0;
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(findParent(curr.a)!=findParent(curr.b)) {
				union(curr.a,curr.b);
				answer += curr.cost;
			}
		}
		System.out.println(answer);
	}
	static void union(int x, int y) {
		int a = findParent(x);
		int b = findParent(y);
		
		if(a!=b)
			parent[b] = a;
	}
	
	static int findParent(int x) {
		if(parent[x]==x) return x;
		
		return parent[x] = findParent(parent[x]);
	}
}