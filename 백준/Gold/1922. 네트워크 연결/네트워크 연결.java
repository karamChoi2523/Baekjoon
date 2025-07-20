import java.util.*;
import java.io.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int nodeA;
		int nodeB;
		int value;
		
		public Edge(int a, int b, int c) {
			nodeA = a;
			nodeB = b;
			value = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.value-o.value;
		}
	}
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			pq.add(new Edge(a,b,c));
		}
		
		parent = new int[N+1];
		
		for(int i=1;i<N+1;i++)
			parent[i] = i;
		
		int answer = 0;
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(findParent(curr.nodeA)!=findParent(curr.nodeB)) {
				union(curr.nodeA, curr.nodeB);
				answer+=curr.value;
			}
		}
		
		System.out.println(answer);
	}
	
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(px!=py)
			parent[py] = px;
	}
	
	static int findParent(int x) {
		if(parent[x]==x) return x;
		
		return parent[x] = findParent(parent[x]);
	}
}