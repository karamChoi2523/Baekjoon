import java.util.*;
import java.io.*;

public class Main {
	//도시 N개, 케이블 M개, 발전소 K개
	static int N, M, K;
	static int[] parent;
	static ArrayList<Integer> list;
	static class Edge implements Comparable<Edge>{
		int u, v;
		long w;
		
		public Edge(int u, int v, long w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (int)(this.w-o.w);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//발전소 설치된 곳
		list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<K;i++)
			list.add(Integer.parseInt(st.nextToken()));
		
		parent = new int[N+1];
		for(int i=1;i<N+1;i++)
			parent[i] = i;
		
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			
			edges.add(new Edge(u,v,w));
		}
		//모두 연결x 전기 공급망 구축
		
		long answer = 0;
		while(!edges.isEmpty()) {
			Edge curr = edges.poll();
			
			int pu = findParent(curr.u);
			int pv = findParent(curr.v);
			
			if(list.contains(pu) && list.contains(pv)) continue;
			
			if(pu != pv) {
				union(pu, pv);
				answer += curr.w;
			}
		}
		System.out.println(answer);
	}
	static void union(int x, int y) {
		if(list.contains(x) && !list.contains(y))
			parent[y] = x;
		else
			parent[x] = y;
	}
	
	static int findParent(int x) {
		while(x!=parent[x]) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}
}
