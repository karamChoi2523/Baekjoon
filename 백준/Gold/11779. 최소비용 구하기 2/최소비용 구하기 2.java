import java.io.*;
import java.util.*;


public class Main {
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;

		public Edge(int t, int c) {
			to = t;
			cost = c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}

	static int INF = (int)1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());

		// 인접리스트
		ArrayList<ArrayList<Edge>> a = new ArrayList<>(); 	//인접리스트
		int[] dist = new int[n+1];
		boolean[] visited = new boolean[n+1];

		Arrays.fill(dist, INF);
		
		for(int i=0;i<n+1;i++)
			a.add(new ArrayList<>());

		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());

			a.get(from).add(new Edge(to, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.valueOf(st.nextToken());
		int end = Integer.valueOf(st.nextToken());

		dijkstra2(n,m,a,dist,visited,start,end);
	}
	private static void dijkstra2(int n, int m, ArrayList<ArrayList<Edge>> a, int[] dist, boolean[] visited, int start, int end){
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start, 0));
		
		dist[start] = 0;
		
		int[] from = new int[n+1];
		from[start] = -1;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			int x = curr.to;
			
			if(visited[x]) continue;
			
			visited[x] = true;
			
			for(int i=0;i<a.get(x).size();i++) {
				Edge next  = a.get(x).get(i);
				
				if(dist[next.to]>next.cost+curr.cost) {
					dist[next.to] = next.cost+curr.cost;
					from[next.to] = x;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
		
		System.out.println(dist[end]);
		
		Stack<Integer> st = new Stack<>();
		int x = end;
		while(x!=-1) {
			st.push(x);
			x = from[x];
		}
		System.out.println(st.size());
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
	}
}
