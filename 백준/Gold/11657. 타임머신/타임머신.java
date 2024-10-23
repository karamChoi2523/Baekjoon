import java.io.*;
import java.util.*;


public class Main {	
	static class Edge{
		int from, to, cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	static int INF = (int)1e9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		Edge[] a = new Edge[m+1];
		long[] dist = new long[n+1];
		
		Arrays.fill(dist, INF);
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			
			a[i] = new Edge(from, to, cost);
		}
		
		dist[1] = 0;
		boolean negativeCycle = false;
		
		for(int i=1;i<n+1;i++) {
			for(int j=0;j<m;j++) {
		        Edge curr = a[j];
		        if(dist[curr.from]!=INF && dist[curr.to] > dist[curr.from]+curr.cost) {
		        	dist[curr.to] = dist[curr.from]+curr.cost;
			        
			        if(i==n)
			        	negativeCycle = true;
		        }
			}
		}
		
		if(negativeCycle)
			System.out.println(-1);
		else {
			for(int i=2;i<n+1;i++) {
				if(dist[i]==INF)
					System.out.println(-1);
				else
					System.out.println(dist[i]);
			}
		}
		
	}
}
