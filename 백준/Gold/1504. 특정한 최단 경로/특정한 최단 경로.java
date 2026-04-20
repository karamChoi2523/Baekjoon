import java.io.*;
import java.util.*;

public class Main {
	static int N, E;
	static int v1, v2;
	static ArrayList<Node>[] adj;
	
	static class Node implements Comparable<Node>{
		int node;
		long cost;
		
		public Node(int node, long c) {
			this.node = node;
			this.cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return (int)(this.cost - o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		
		for(int i=1;i<N+1;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			adj[a].add(new Node(b,c));
			adj[b].add(new Node(a,c));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		long res1 = -1, res2 = -1;

		// 1-> v1 -> v2 -> N
		long r1 = dijkstra(1, v1);
		if(r1 != -1) {
			long r2 = dijkstra(v1, v2);
			if(r2 != -1) {
				long r3 = dijkstra(v2, N);
				if(r3 != -1)
					res1 = r1 + r2 + r3;
			}
		}
		res1 = res1==-1?Integer.MAX_VALUE:res1;
		
		if(v2!=N) {
			// 1-> v2 -> v1 -> N
			long rr1 = dijkstra(1, v2);
			if(rr1 != -1) {
				long rr2 = dijkstra(v2, v1);
				if(rr2 != -1) {
					long rr3 = dijkstra(v1, N);
					if(rr3 != -1)
						res2 = rr1 + rr2 + rr3;
				}
			}
		}
		res2 = res2==-1?Integer.MAX_VALUE:res2;		
		
		long answer = Math.min(res1, res2);
		System.out.println(answer == Integer.MAX_VALUE?-1:answer);
	}
	static long dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[] visited = new int[N+1];
		long[] dist = new long[N+1];
		
		Arrays.fill(visited, 2);
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.node]==0) continue;
			visited[curr.node]--;
			
			if(curr.node == end) {
				break;
			}
			
			for(Node next : adj[curr.node]) {
				long cost = next.cost + dist[curr.node];
				
				if(cost >= dist[next.node]) continue;
				dist[next.node] = cost;
				pq.add(new Node(next.node, cost));
			}
		}
		
		return dist[end]==Integer.MAX_VALUE?-1:dist[end];
	}

}
