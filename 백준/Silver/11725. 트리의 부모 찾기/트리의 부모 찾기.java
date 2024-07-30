import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());

		int[] parent = new int[n+1];
		adj = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i=0;i<n+1;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0;i<n-1;i++) {
			String str = br.readLine();

			int a = Integer.valueOf(str.split(" ")[0]);
			int b = Integer.valueOf(str.split(" ")[1]);
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		dfs(parent, 1);
		
		for(int i=2;i<n+1;i++) {
			System.out.println(parent[i]);
		}
	}

	private static void dfs(int[] parent, int x) {
		visited[x] = true;
		
		for(int next : adj[x]) {
			if(!visited[next]) {
				parent[next] = x;
				dfs(parent, next);
			}
		}
	}
}
