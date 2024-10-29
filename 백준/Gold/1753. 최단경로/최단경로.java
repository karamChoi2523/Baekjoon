import java.io.*;
import java.util.*;


public class Main {
	static class Edge implements Comparable<Edge>{
		int to, cost;
		
		public Edge(int t, int c) {
			to = t;
			cost = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.valueOf(st.nextToken());
		int e = Integer.valueOf(st.nextToken());
		
		int k = Integer.valueOf(br.readLine());
	
		int[] dist = new int[v+1];
		Arrays.fill(dist, INF);
		
		ArrayList<Edge>[] graph = new ArrayList[v+1];
		
		for(int i=0;i<v+1;i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			
			graph[from].add(new Edge(to, cost));
		}
		
		dijkstra2(v, e, k, graph, dist);
	}
	private static void dijkstra2(int v, int e, int k, ArrayList<Edge>[] graph, int[] dist){
		boolean[] visited = new boolean[v+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(k, 0));
		
		dist[k] = 0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(visited[curr.to]) continue;
			
			visited[curr.to] = true;
			
			for(Edge next : graph[curr.to]) {
				int cost = dist[curr.to]+next.cost;
				
				if(dist[next.to] > cost) {
					dist[next.to] = cost;
					pq.add(new Edge(next.to, cost));
				}
			}
		}
		for(int i=1;i<v+1;i++)
			if(dist[i]==INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
	}
}