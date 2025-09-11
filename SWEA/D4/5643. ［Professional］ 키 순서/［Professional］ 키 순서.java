import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[][] graph;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			graph = new int[N+1][N+1];
			for(int i=1;i<N+1;i++)
				Arrays.fill(graph[i], (int)1e9);
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			
				graph[a][b] = 1;	//a보다 b가 크다
			}
			
			int answer = 0;
			
			//모든 학생에 대해 자신보다 키가 큰/작은 학생 탐색
			for(int i=1;i<N+1;i++) {
				count = 0;
				boolean[] visited = new boolean[N+1];
				gtDFS(i, visited);	//수행이 끝나면 나보다 큰 학생 count
				ltDFS(i, visited);
				
				if(count==N-1)
					answer++;
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
	static void gtDFS(int curr, boolean[] visited) {
		visited[curr] = true;
		for(int i=1;i<N+1;i++)
			if(graph[curr][i]==1 && !visited[i]) {
				++count;
				gtDFS(i, visited);
			}
	}
	static void ltDFS(int curr, boolean[] visited) {
		visited[curr] = true;
		for(int i=1;i<N+1;i++)
			if(graph[i][curr]==1 && !visited[i]) {
				++count;
				ltDFS(i, visited);
			}
	}
}
