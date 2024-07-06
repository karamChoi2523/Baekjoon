import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int cost;
		int node;
		
		public Node(int node,int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
	}
	static ArrayList<Node>[] graph;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i=0;i<n+1;i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			
			graph[a].add(new Node(b, cost));
			graph[b].add(new Node(a, cost));
		}
		visited = new boolean[n+1];
		dist = new int[n+1];
		Arrays.fill(dist, 50000001);
		dijkstra();
		
		System.out.println(dist[n]);
	}

	private static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		dist[1] = 0;
		q.add(new Node(1, 0));
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(visited[current.node])
				continue;
			
			visited[current.node] = true;
			
			for(int i=0;i<graph[current.node].size();i++) {
				Node next = graph[current.node].get(i);
				if(dist[next.node] > dist[current.node]+next.cost) {
					dist[next.node] = dist[current.node]+next.cost;
					q.add(new Node(next.node, dist[next.node]));
				}
			}
		}
		
	}

}
