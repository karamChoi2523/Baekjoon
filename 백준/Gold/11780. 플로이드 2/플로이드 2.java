import java.io.*;
import java.util.*;


public class Main {
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
	
		int[][] graph = new int[n+1][n+1];
		int[][] next = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			Arrays.fill(graph[i], INF);
			Arrays.fill(next[i], -1);
			graph[i][i] = 0;
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());

			graph[a][b] = Math.min(graph[a][b], c);
			next[a][b] = b;
		}
		
		for(int k=1;k<n+1;k++)
			for(int i=1;i<n+1;i++)
				for(int j=1;j<n+1;j++)
					if(graph[i][j] > graph[i][k]+graph[k][j]) {
						graph[i][j] = graph[i][k]+graph[k][j];
						next[i][j] = next[i][k];
					}
	
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++)
				System.out.print(graph[i][j]==INF? "0 ":graph[i][j]+" ");
			System.out.println();
		}
		
		for(int i=1;i<n+1;i++)
			for(int j=1;j<n+1;j++)
				if(i==j || graph[i][j]==INF) System.out.println(0);
				else path(next, i, j);
	}

	private static void path(int[][] next, int x, int y) {
		if(next[x][y] == -1) {
			System.out.println(0);
			return;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		
		while(x!=y) {
			x = next[x][y];
			q.add(x);
		}
		
		System.out.println(q.size());
		while(!q.isEmpty()) {
			System.out.print(q.poll()+" ");
		}
		System.out.println();
	}
}