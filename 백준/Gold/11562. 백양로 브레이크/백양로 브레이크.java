import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			Arrays.fill(graph[i], (int)1e9);
			graph[i][i] = 0;
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[u][v] = 0;
			graph[v][u] = b==0?1:0;
		}
		for(int k=1;k<n+1;k++)
			for(int i=1;i<n+1;i++)
				for(int j=1;j<n+1;j++)
					if(graph[i][j] > graph[i][k] + graph[k][j])
						graph[i][j] = graph[i][k] + graph[k][j];

		int k = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(graph[s][e]+"\n");
		}
		System.out.println(sb.toString());
	}
}
