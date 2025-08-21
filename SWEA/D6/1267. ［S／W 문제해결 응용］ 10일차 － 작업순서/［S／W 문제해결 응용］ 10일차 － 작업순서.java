import java.io.*;
import java.util.*;


public class Solution {
	static ArrayList<Integer>[] board;
	static int[] indegree;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		//int T = Integer.parseInt(br.readLine());
		int T = 10;
		sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			board = new ArrayList[V+1];
			for(int i=1;i<V+1;i++)
				board[i] = new ArrayList<>();
			indegree = new int[V+1];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				board[from].add(to);
				indegree[to]++;
			}
			
			sb.append("#"+tc+" ");
			sol(V);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void sol(int V) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[V+1];
		
		for(int i=1;i<V+1;i++)
			if(indegree[i]==0)
				q.add(i);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			sb.append(curr+" ");
			
			for(int e : board[curr]) {
				indegree[e]--;
				
				if(indegree[e]==0 && !visited[e]) {
					q.add(e);
					visited[e] = true;
				}
			}
		}
	}
}
