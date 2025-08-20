import java.io.*;
import java.util.*;

public class Solution {
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		int T = 10;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[101];
			for(int i=1;i<101;i++)
				adj[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adj[from].add(to);
			}
						
			System.out.printf("#%d %d\n",tc,bfs(start));
		}
	}
	static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		boolean[] visited = new boolean[101];
		visited[start] = true;
		
		int res = start;
		while(!q.isEmpty()) {
			int size = q.size();
			int max = -1;
			
			for(int i=0;i<size;i++) {
				int curr = q.poll();
				
				max = Math.max(max, curr);
				
				for(int e: adj[curr])
					if(!visited[e]) {
						visited[e] = true;
						q.add(e);
					}
			}
			res = max;
		}
		return res;
	}
}
