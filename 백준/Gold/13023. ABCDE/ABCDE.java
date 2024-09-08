import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int n;
	static boolean res = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		adj = new ArrayList[n];
		
		for(int i=0;i<n;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
		
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for(int i=0;i<n;i++) {
			visited = new boolean[n];
			dfs(i, 1);
			if(res) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

	private static void dfs(int start, int depth) {
		if(depth == 5) {
			res = true;
			return;
		}
		
		visited[start] = true;
		
		for(int e : adj[start]) {
			if(!visited[e]) {
				dfs(e, depth+1);
			}
		}
		visited[start] = false;
	}

}
