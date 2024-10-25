import java.io.*;
import java.util.*;


public class Main {
	static class Edge{
		int from, to, cost;
		
		public Edge(int f, int t, int c) {
			from = f;
			to = t;
			cost = c;
		}
	}
	static int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			int w = Integer.valueOf(st.nextToken());
			
			ArrayList<Edge> a = new ArrayList<>();
			int[] dist = new int[n+1];
			
			int i;
			for(i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.valueOf(st.nextToken());
				int e = Integer.valueOf(st.nextToken());
				int t = Integer.valueOf(st.nextToken());

				a.add(new Edge(s,e,t));
				a.add(new Edge(e,s,t));
			}
			
			for(;i<m+w;i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.valueOf(st.nextToken());
				int e = Integer.valueOf(st.nextToken());
				int t = Integer.valueOf(st.nextToken());
			
				a.add(new Edge(s,e,-t));
			}
			
			boolean negativeCycle = false;
			
			for(int k=1;k<n+1;k++) {
				if(negativeCycle) break;
				
				Arrays.fill(dist, INF);
				
				dist[k] = 0;
				boolean update = false;
				
				for(i=1;i<n+1;i++) {
					update = false;
					for(Edge curr : a) {
						if(dist[curr.from]!=INF && dist[curr.to]>dist[curr.from]+curr.cost) {
							dist[curr.to] = dist[curr.from]+curr.cost;
							update = true;
							
							if(i==n) negativeCycle = true;
						}
					}
					if(!update) break;
				}
			}

			if(negativeCycle) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb.toString());
	}
}
