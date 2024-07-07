import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int cost;
		int node;
		
		public Node(int c, int n) {
			cost = c;
			node = n;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static int[] dist;
	static int start, end;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		dist = new int[n+1];
		
		for(int i=0;i<n+1;i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			
			graph[s].add(new Node(cost, e));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.valueOf(st.nextToken());
		end = Integer.valueOf(st.nextToken());
		
		Arrays.fill(dist, 100000001);
		
		dijkstra(start);
		
		System.out.println(dist[end]);
	}
	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, start));
		dist[start]=0;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if(visited[curr.node])
				continue;
			
			visited[curr.node] = true;
			
			if(dist[curr.node] < curr.cost)
				continue;
			
			for(Node next : graph[curr.node]) {
				int cost = next.cost+curr.cost;
				
				if(cost < dist[next.node]) {
					dist[next.node] = cost;
					q.add(new Node(cost, next.node));
				}				
			}
		}
	}

}
