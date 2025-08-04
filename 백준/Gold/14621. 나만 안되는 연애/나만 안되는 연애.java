import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	static int N, M;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		char[] school = new char[N+1];
		for(int i=1;i<N+1;i++)
			school[i] = st.nextToken().charAt(0);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
		
			pq.add(new Edge(u,v,d));
		}
		
		parent = new int[N+1];
		for(int i=1;i<N+1;i++)
			parent[i] = i;
		
		int len = 0;
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(school[curr.from]==school[curr.to]) continue;
			
			if(findParent(curr.from)!=findParent(curr.to)) {
				union(curr.from, curr.to);
				len += curr.cost;
			}
		}
		
		ArrayList<Integer> pList = new ArrayList<>();
		for(int i=1;i<N+1;i++) {
			int px = findParent(parent[i]);
			if(!pList.contains(px)) pList.add(px);
		}
		System.out.println(pList.size()==1?len:-1);
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		if(px<py) parent[py] = px;
		else parent[px] = py;
	}
	static int findParent(int x) {
		if(parent[x]==x) return x;
		
		return parent[x] = findParent(parent[x]);
	}
}