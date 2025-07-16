import java.util.*;
import java.io.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int cost, node;
		
		public Edge(int c, int n) {
			cost = c;
			node = n;
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.cost==o.cost)
				return this.node-o.node;
			return this.cost-o.cost;
		}
	}
	static ArrayList<Edge>[] graph;
	static int[] dist;
	static int V,E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		
		for(int i=1;i<V+1;i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(w, v));
		}
		dist = new int[V+1];
		Arrays.fill(dist, (int)1e9);
		
		dijkstra(start);
	}
	private static void dijkstra(int start) {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(0,start));
		dist[start] = 0;
		
		boolean[] visited = new boolean[V+1];
		
		while(!q.isEmpty()) {
			Edge curr = q.poll();
			
			if(visited[curr.node]) continue;
			
			visited[curr.node] = true;
			
			for(Edge next : graph[curr.node]) {
				if(dist[next.node]<=next.cost+dist[curr.node]) continue;
				
				int cost = next.cost+curr.cost;
				
				if(cost < dist[next.node]) {
					dist[next.node] = cost;
					q.add(new Edge(cost, next.node));
				}
			}
		}
		
		for(int i=1;i<V+1;i++)
			System.out.println(dist[i]==(int)1e9?"INF":dist[i]);
	}
}
