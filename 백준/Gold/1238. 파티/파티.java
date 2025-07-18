import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.cost == o.cost)
				return this.to-o.to;
			return this.cost-o.cost;
		}
	}
	
	static int N, M, X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
	
		ArrayList<Edge>[] adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
			adj[i].add(new Edge(i, 0));
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			adj[start].add(new Edge(end, T));
		}
		
		int max = -1;
		for(int i=1;i<=N;i++)
			max = Math.max(max, dijkstra(adj, i, X)+dijkstra(adj, X, i));
		
		System.out.println(max);
	}
	static int dijkstra(ArrayList<Edge>[] adj, int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, (int)1e9);
		dist[start] = 0;
		
		//go
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(curr.to==end) return dist[end];
			
			if(visited[curr.to]) continue;
			
			visited[curr.to] = true;
			
			for(Edge next : adj[curr.to]) {
				int cost = curr.cost+next.cost;
				
				if(dist[next.to]<=cost) continue;
				
				pq.add(new Edge(next.to, cost));
				dist[next.to] = cost;
			}
		}
		
		return dist[end];
	}
}
