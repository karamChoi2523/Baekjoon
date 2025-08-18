import java.io.*;
import java.util.*;

public class Main {
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
	static int V, E, K;
	static ArrayList<Node>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V+1];
		for(int i=1;i<V+1;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Node(v,w));
		}
		
		dijkstra();
	}
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		int[] dist = new int[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		pq.add(new Node(K,0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.node]) continue;
			visited[curr.node] = true;
			
			for(Node next : adj[curr.node]) {
				int cost = next.cost+dist[curr.node];
				
				if(cost >= dist[next.node]) continue;
				
				dist[next.node] = cost;
				pq.add(new Node(next.node, cost));
			}
		}
		
		for(int i=1;i<V+1;i++)
			System.out.println(dist[i]==Integer.MAX_VALUE?"INF":dist[i]);
	}
}
