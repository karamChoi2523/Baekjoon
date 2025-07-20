import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		long cost;
		
		public Node(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.cost==o.cost)
				return this.to-o.to;
			return (int)(this.cost-o.cost);
		}
	}
	static int n, m;
	static int start, end;
	static ArrayList<Node>[] adj;
	static int[] route;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n+1];
		
		for(int i=1;i<n+1;i++)
			adj[i] = new ArrayList<>();
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			
			adj[from].add(new Node(to, cost));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		route = new int[n+1];
		dijkstra();
		
		Stack<Integer> routes = new Stack<>();
		int curr = end;
		while(curr!=0) {
			routes.add(curr);
			curr = route[curr];
		}
		
		System.out.println(routes.size());
		while(!routes.isEmpty())
			System.out.print(routes.pop()+" ");
	}
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		boolean[] visited = new boolean[n+1];
		long[] dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;
		
		route[start] = 0;
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.to]) continue;
			
			visited[curr.to] = true;
			
			for(Node next : adj[curr.to]) {
				long cost = dist[curr.to]+next.cost;
				
				if(dist[next.to]<=cost) continue;
				
				dist[next.to] = cost;
				pq.add(new Node(next.to, cost));
				route[next.to] = curr.to;
			}
		}
		
		System.out.println(dist[end]);
	}
}