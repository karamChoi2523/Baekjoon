import java.io.*;
import java.util.*;


public class Main {
	static int V,E,K;
	static class Edge implements Comparable<Edge>{
		int cost, node;
		
		public Edge(int cost, int node) {
			this.cost = cost;
			this.node = node;
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.cost==o.cost)
				return this.node-o.node;
			return this.cost-o.cost;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] graph = new ArrayList[V+1];
		for(int i=1;i<V+1;i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(w, v));
		}
		
		dijkstra(graph);
	}
	static void dijkstra(ArrayList<Edge>[] graph) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(dist, (int)1e9);
		pq.add(new Edge(0, K));
		dist[K]=0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(visited[curr.node])
				continue;
			visited[curr.node] = true;
			
			for(Edge next : graph[curr.node]) {
				int cost = dist[curr.node]+next.cost;
				if(dist[next.node]<=cost) continue;
				dist[next.node] = cost;
				pq.add(new Edge(cost, next.node));
			}
		}
		
		for(int i=1;i<V+1;i++)
			System.out.println(dist[i]==(int)1e9?"INF":dist[i]);
	}
}
