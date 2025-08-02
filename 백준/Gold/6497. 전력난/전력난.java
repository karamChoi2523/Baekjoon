import java.io.*;
import java.util.*;

public class Main {
	static class KEdge implements Comparable<KEdge>{
		int from, to, cost;
		
		public KEdge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(KEdge o) {
			return this.cost-o.cost;
		}
	}
	static class PEdge implements Comparable<PEdge>{
		int to;
		int cost;
		
		public PEdge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(PEdge o) {
			return this.cost-o.cost;
		}
	}
	static int m, n;
	static ArrayList<PEdge>[] adj;
	static PriorityQueue<KEdge> kpq;
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
				
				adj[x].add(new PEdge(y, z));
				adj[y].add(new PEdge(x, z));
				
				kpq.add(new KEdge(x,y,z));
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
		
		if(px!=py)
			parent[py] = px;
	}
	static int findParent(int x) {
		if(parent[x]==x) return x;
		
		return parent[x] = findParent(parent[x]);
	}
	static int kruskal() {
		int sum = 0;
		
		while(!kpq.isEmpty()) {
			KEdge curr = kpq.poll();
			
			if(findParent(curr.from)!=findParent(curr.to)) {
				union(curr.from, curr.to);
				sum += curr.cost;
			}
		}
		return sum;
	}
	static int prim() {
		PriorityQueue<PEdge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[m];
		
		for(PEdge next : adj[0])
			pq.add(next);
		
		visited[0] = true;
		int sum = 0;
		
		while(!pq.isEmpty()) {
			PEdge curr = pq.poll();
			
			if(visited[curr.to]) continue;
			
			visited[curr.to] = true;			
			sum+=curr.cost;
			for(PEdge next : adj[curr.to]) {
				pq.add(next);
			}
		}
		
		return sum;
	}
}
