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
			return this.cost-o.cost;
		}
	}
	static class Node implements Comparable<Node>{
		int node;
		int cost;
		
		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	static int m, n;
	static ArrayList<Node>[] adj;
	static PriorityQueue<Edge> kpq;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true){
			st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if(m==0 && n==0) break;

			int total = 0;
			adj = new ArrayList[m];
			kpq = new PriorityQueue<>();
			parent = new int[m];
			for(int i=0;i<m;i++)
				parent[i] = i;
			for(int i=0;i<m;i++)
				adj[i] = new ArrayList<>();
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				total+=z;
				
				adj[x].add(new Node(y, z));
				adj[y].add(new Node(x, z));
				
				kpq.add(new Edge(x,y,z));
			}
			
			//int ans = prim();
			int ans = kruskal();
			
			sb.append((total-ans)+"\n");
		}
		System.out.println(sb.toString());
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
		while(x!=parent[x]) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		
		return x;
	}
	static int kruskal() {
		int sum = 0;
		
		while(!kpq.isEmpty()) {
			Edge curr = kpq.poll();
			
			if(findParent(curr.from)!=findParent(curr.to)) {
				union(curr.from, curr.to);
				sum += curr.cost;
			}
		}
		return sum;
	}
	static int prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[m];
		
		for(Node next : adj[0])
			pq.add(next);
		
		visited[0] = true;
		int sum = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.node]) continue;
			visited[curr.node] = true;
			
			sum+=curr.cost;
			for(Node next : adj[curr.node]) {
				pq.add(next);
			}
		}
		
		return sum;
	}
}