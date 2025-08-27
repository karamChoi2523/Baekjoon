import java.io.*;
import java.util.*;


public class Solution {
	static int V, E;
	static PriorityQueue<Node> pq;
	static ArrayList<Node>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		//int T = 10;
		for(int tc=1;tc<=T;tc++) {
			initialize(br);
						
			long[] dist = new long[V+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			boolean[] visited = new boolean[V+1];
			pq = new PriorityQueue<>();
			
			long sum = 0;
			dist[1] = 0;
			pq.add(new Node(1,0));
			
			while(!pq.isEmpty()) {
				Node curr = pq.poll();
				
				if(visited[curr.node]) continue;
				visited[curr.node] = true;
				sum += curr.cost;	//중복으로 더해질 수 있으므로 방문 처리를 할 때 합산을 해야 함
				
				for(Node next : adj[curr.node]) {
					if(visited[next.node] || dist[next.node]<next.cost) continue;
					dist[next.node] = next.cost;
					pq.add(new Node(next.node, next.cost));
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adj = new ArrayList[V+1];
		for(int i=0;i<V+1;i++)
			adj[i] = new ArrayList<>();
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long C = Long.parseLong(st.nextToken());
			
			adj[A].add(new Node(B,C));
			adj[B].add(new Node(A,C));
		}
		
	}
	static class Node implements Comparable<Node>{
		int node;
		long cost;
		
		Node(int n, long c){
			node = n;
			cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}
}
