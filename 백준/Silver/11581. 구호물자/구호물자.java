import java.io.*;
import java.util.*;


public class Main {
	static List<List<Integer>> adj;
	static boolean[] visited;
	static boolean[] finished;
	static int n;
	static boolean check = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.valueOf(br.readLine());
		
		adj = new ArrayList<>();
		visited = new boolean[n+1];
		finished = new boolean[n+1];
		
		for(int i=0;i<n+1;i++)
			adj.add(new ArrayList<>());
		
		for(int i=1;i<n;i++) {
			int m = Integer.valueOf(br.readLine());	//i번째 교차로와 연결된 교차로 수

			String[] str = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				adj.get(i).add(Integer.valueOf(str[j]));
			}
		}
		
		dfs(1);
				
		if(!check)
			System.out.println("NO CYCLE");
		else
			System.out.println("CYCLE");
	}
	private static void dfs(int node) {
		if(check) return;
		
		visited[node] = true;
		finished[node] = true;
		
		for(Integer e : adj.get(node)) {
			if(!visited[e])
				dfs(e);
			else if(finished[e]) {
				check = true;
				return;
			}
		}
		finished[node] = false;
	}
}
