import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int v = Integer.valueOf(st.nextToken());
		
		adj = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i=0;i<n+1;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		//여러 정점을 방문 가능할 경우 정점 번호가 작은 것부터 방문
		for(int i=1;i<n+1;i++)
			Collections.sort(adj[i]);
		
		//dfs
		sb = new StringBuilder();
		dfs(v);
		sb.append("\n");
		
		//bfs
		visited = new boolean[n+1];
		bfs(v);
		System.out.println(sb.toString());
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node+" ");
			
			for(int e : adj[node]) {
				if(!visited[e]) {
					q.offer(e);
					visited[e] = true;
				}
			}
		}
	}

	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v+" ");
		
		for(int e : adj[v]) {
			if(!visited[e])
				dfs(e);
		}
	}

}
