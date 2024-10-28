import java.io.*;
import java.util.*;


public class Main {
	static class Edge{
		int to;
		int cost;
		
		public Edge(int t, int c) {
			to = t;
			cost = c;
		}
	}
	
	static int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		
		solutionA(br, n, m);
		solutionB(br, n, m);
	}
	private static void solutionA(BufferedReader br, int n, int m) throws IOException {
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
		
		dist[start] = 0;
		
		for(int k=0;k<n-1;k++) {
			int temp = INF+1;
			int x = -1;
			
			for(int i=1;i<n+1;i++) {
				if(!visited[i] && dist[i] < temp) {
					temp = dist[i];
					x = i;
				}
			}
			
			visited[x] = true;	//선택한 정점
			for(int i=0;i<a.get(x).size();i++) {
				int to = a.get(x).get(i).to;
				int cost = a.get(x).get(i).cost;
				
				if(dist[to] > dist[x]+cost)
					dist[to] = dist[x]+cost;
			}
		}
		
		System.out.println(dist[end]);
	}
	private static void solutionB(BufferedReader br, int n, int m) throws IOException {
		// 인접행렬
	}
}
