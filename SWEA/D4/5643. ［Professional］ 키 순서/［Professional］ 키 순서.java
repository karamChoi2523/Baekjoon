import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] graph;
	static int[][] rGraph;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			graph = new int[N+1][N+1];	//나보다 큰 관계
			rGraph = new int[N+1][N+1];	//나보다 작은 관계
			
			for(int i=1;i<N+1;i++)
				Arrays.fill(graph[i], (int)1e9);
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			
				rGraph[b][a] = graph[a][b] = 1;	//a보다 b가 크다
			}
			
			int answer = 0;
			
			//모든 학생에 대해 자신보다 키가 큰/작은 학생 탐색
			for(int i=1;i<N+1;i++) {
				count = 0;
				boolean[] visited = new boolean[N+1];
				dfs(i, graph, visited);	//수행이 끝나면 나보다 큰 학생 count
				dfs(i, rGraph, visited);//수행이 끝나면 나보다 작은 학생 count
				
				if(count==N-1)
					answer++;
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
	static void dfs(int curr, int[][] adj, boolean[] visited) {
		visited[curr] = true;
		for(int i=1;i<N+1;i++)
			if(adj[curr][i]==1 && !visited[i]) {
				++count;
				dfs(i, adj, visited);
			}
	}
}
