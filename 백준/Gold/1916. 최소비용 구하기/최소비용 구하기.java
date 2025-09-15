import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Node>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		for(int i=1;i<N+1;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			adj[s].add(new Node(e, c));
		}
		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());		
		
		int res = dijkstra(N, start, end);
		
		System.out.println(res);
	}
	static int dijkstra(int N, int start, int end) {
		Queue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N+1];
		Arrays.fill(dist, (int)1e9);
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
//		boolean[] visited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
//			
//			if(visited[curr.node]) continue;
//			visited[curr.node] = true;
			
			if(curr.node==end)
				return curr.cost;
			
			for(Node next : adj[curr.node]) {
				int cost = dist[curr.node]+next.cost;
				
				if(dist[next.node] > cost) {
					dist[next.node] = cost;
					pq.add(new Node(next.node, cost));
				}
			}
		}
		return dist[end];
	}
	static class Node implements Comparable<Node>{
		int node, cost;

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
}
