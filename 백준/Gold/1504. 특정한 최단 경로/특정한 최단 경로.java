import java.io.*;
import java.util.*;


public class Main {
	static class Node implements Comparable<Node>{
		int e;
		int cost;
		
		public Node(int e, int c) {
			this.e = e;
			cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	static int n,e;
	static ArrayList<Node>[] adj;
	static int[] dist;
	static boolean[] check;
	static int INF = (int)2e8;
	//다익스트라 - 한 노드에서 모든 노드 사이의 최단거리
	//1->v1->v2->N
	//1->v2->v1->N
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		e = Integer.valueOf(st.nextToken());
		
		adj = new ArrayList[n+1];
		dist = new int[n+1];
		check = new boolean[n+1];
		
		Arrays.fill(dist, INF);
		
		for(int i=1;i<n+1;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.valueOf(st.nextToken());
		int v2 = Integer.valueOf(st.nextToken());
		
		//(1) 1->v1->v2->N
		int first=0;
		first+=dijkstra(1, v1);
		first+=dijkstra(v1, v2);
		first+=dijkstra(v2, n);
		
		//(2) 1->v2->v1->N
		int second=0;
		second+=dijkstra(1, v2);
		second+=dijkstra(v2, v1);
		second+=dijkstra(v1, n);
		
		int ans = (first >= INF && second>=INF)?-1 : Math.min(first, second);
		
		System.out.println(ans);
	}
	private static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		boolean[] check = new boolean[n+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(!check[curr.e]) {
				check[curr.e] = true;
				
				for(Node node : adj[curr.e]) {
					if(!check[node.e] && dist[node.e] > dist[curr.e]+node.cost) {
						dist[node.e] = dist[curr.e]+node.cost;
						pq.add(new Node(node.e, dist[node.e]));
					}
				}
			}
		}
		
		return dist[end];
	}
}
