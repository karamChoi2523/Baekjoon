import java.util.*;
import java.io.*;

public class Main {
	//크루스칼
	static int V, E;
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int a, b;
		long cost;
		
		public Edge(int a, int b, long c) {
			this.a = a;
			this.b = b;
			cost = c;
		}

		@Override
		public int compareTo(Edge o) {
			return (int)(this.cost - o.cost);
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());	//정점 개수
		E = Integer.parseInt(st.nextToken());	//간선의 수
		
		//초기에 부모 = 나 자신
		parent = new int[V+1];
		for(int i=1;i<V+1;i++)
			parent[i] = i;
		
		// 가중치에 따라 오름차순 정렬
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a<=b)
				pq.add(new Edge(a, b, c));
			else
				pq.add(new Edge(b, a, c));
		}
		
		long answer = 0;
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(findParent(curr.a)!=findParent(curr.b)) {
				union(curr.a, curr.b);
				answer += curr.cost;
			}
		}
		
		System.out.println(answer);
	}
	static int findParent(int x) {
		while(x!=parent[x]) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		
		return x;
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(px<=py) parent[py] = px;
		else parent[px] = py;
	}
}
