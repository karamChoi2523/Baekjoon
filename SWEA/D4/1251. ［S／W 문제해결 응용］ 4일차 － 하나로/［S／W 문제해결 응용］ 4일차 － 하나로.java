import java.util.*;
import java.io.*;

public class Solution {
	static int[] parents;
	static class Edge implements Comparable<Edge>{
		int from, to;
		long cost;
		
		public Edge(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=10;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			long[] X = new long[N];
			long[] Y = new long[N];

			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
				X[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
				Y[i] = Integer.parseInt(st.nextToken());
			
			double E = Double.parseDouble(br.readLine());
			
			parents = new int[N];
			for(int i=0;i<N;i++)
				parents[i] = i;
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(int i=0;i<N;i++)
				for(int j=i+1;j<N;j++) {
					long L = (X[i]-X[j])*(X[i]-X[j])+(Y[i]-Y[j])*(Y[i]-Y[j]);
					pq.add(new Edge(i,j,L));
				}
			
			long ans = 0;
			int cnt=0;
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				if(union(edge.from, edge.to))
					continue;
				ans += edge.cost;
				if(++cnt==N-1)
					break;
			}
			
			System.out.printf("#%d %d\n",t, Math.round(ans*E));
		}

		br.close();
	}
	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa!=pb) {
			parents[pb] = pa;
			return false;
		}
		return true;
	}
	private static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x] = find(parents[x]);
	}
}