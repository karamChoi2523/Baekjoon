import java.io.*;
import java.util.*;


public class Solution {
	static int N;
	static long[] X;
	static long[] Y;
	static double E;
	static PriorityQueue<Edge> pq;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		//int T = 10;
		for(int tc=1;tc<=T;tc++) {
			initialize(br);
			
			makeEdges();
			
			double sum = 0;
			while(!pq.isEmpty()) {
				Edge curr = pq.poll();
				if(findParent(curr.from)!=findParent(curr.to)) {
					sum += curr.cost;
					union(curr.from, curr.to);
				}
			}
			System.out.printf("#%d ", tc);
			System.out.println(Math.round(sum));
			//System.out.printf("#%d %d\n",tc,sum);
		}
	}
	static void union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if(px<py)
			parents[py] = px;
		else parents[px] = py;
	}
	static int findParent(int x) {
		while(x!=parents[x]) {
			parents[x] = parents[parents[x]];
			x = parents[x];
		}
		return x;
	}
	static void makeEdges() {
		pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				pq.add(new Edge(i,j,cal(i,j)));
		}
	}
	static double cal(int a, int b) {
		//환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
		long len = (X[a]-X[b])*(X[a]-X[b])+(Y[a]-Y[b])*(Y[a]-Y[b]);
		return (double)len * E;
	}
	private static void initialize(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		X = new long[N];
		Y = new long[N];
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			Y[i] = Integer.parseInt(st.nextToken());
		}
		E = Double.parseDouble(br.readLine());
		
		parents = new int[N];
		for(int i=0;i<N;i++)
			parents[i] = i;
	}
	static class Edge implements Comparable<Edge>{
		int from, to;
		double cost;
		
		Edge(int f, int t, double c){
			from = f;
			to = t;
			cost = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
}
