import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18243 {
	static int[][] graph;
	static boolean[][] visited;
	static int INF = 999999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		graph = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		for(int i=0;i<n+1;i++)
			for(int j=0;j<n+1;j++)
				if(i!=j)
					graph[i][j] = INF;
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
			visited[a][b] = true;
			visited[b][a] = true;
		}
		
		for(int l=1;l<n+1;l++)
			for(int i=1;i<n+1;i++)
				for(int j=1;j<n+1;j++)
					if(i!=j && visited[i][l] && visited[l][j]) {
						graph[i][j] = Math.min(graph[i][j], graph[i][l]+graph[l][j]);
						//graph[j][i] = graph[i][j];
						visited[i][j] = true;
					}
		boolean small = true;
		LOOP:for(int i=1;i<n+1;i++)
			for(int j=1;j<n+1;j++)
				if(graph[i][j] > 6|| (i!=j && graph[i][j]==0)) {
					small = false;
					break LOOP;
				}
		
		if(small)
			System.out.println("Small World!");
		else
			System.out.println("Big World!");
	
	}

}
