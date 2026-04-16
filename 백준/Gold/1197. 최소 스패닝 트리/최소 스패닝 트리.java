import java.util.*;
import java.io.*;

public class Main {
	static int V, E;
	static int[] parent;
	static class Edge implements Comparable<Edge>{
		int a, b;
		long c;
		
		public Edge(int a, int b, long c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (int)(this.c-o.c);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		
		for(int i=1;i<V+1;i++)
			parent[i] = i;

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		while(E-->0) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			pq.add(new Edge(a,b,c));
		}
		
		long answer = 0;
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(findParent(curr.a) != findParent(curr.b)) {
				union(curr.a, curr.b);
				answer += curr.c;
			}
		}
		
		System.out.println(answer);
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(px<py) parent[py] = px;
		else parent[px] = py;
	}
	
	static int findParent(int x) {
		while(x!=parent[x]) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}
}
