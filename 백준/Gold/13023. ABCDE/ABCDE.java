import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static Set<Integer> ans = new HashSet<>();
	static int n;
	static boolean res = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		adj = new ArrayList[n];
		//visited = new boolean[n][n];
		
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
			ans.add(i);
			dfs(i);
			if(res)
				break;
			ans.remove(i);
		}
		if(res)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static void dfs(int start) {
		if(ans.size() == 5) {
			res = true;
			return;
		}
		
		for(int e : adj[start]) {
			if(!ans.contains(e)) {
				ans.add(e);
				dfs(e);
				ans.remove(e);
			}
		}
	}

}
