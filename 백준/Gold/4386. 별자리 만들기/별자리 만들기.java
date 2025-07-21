import java.io.*;
import java.util.*;

public class Main {
	static class Star{
		int num;
		double x, y;
		
		public Star(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Node implements Comparable<Node>{
		Star from;
		Star to;
		double cost;
		
		public Node(Star from, Star to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	static int n;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		
		for(int i=0;i<n+1;i++)
			parent[i] = i;
		
		ArrayList<Star> stars = new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			stars.add(new Star(i+1, x, y));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				Star a = stars.get(i);
				Star b = stars.get(j);
				
				double dist = Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
				pq.add(new Node(a, b, dist));
			}
		}
		
		double answer = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(findParent(curr.from.num)!=findParent(curr.to.num)) {
				union(curr.from.num, curr.to.num);
				answer += curr.cost;
			}
		}
		
		System.out.printf("%.2f\n", answer);
	}
	static int findParent(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = findParent(parent[x]);
	}
	
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(px!=py)
			parent[py] = px;
	}
}
