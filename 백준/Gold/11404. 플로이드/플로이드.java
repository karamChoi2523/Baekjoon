import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		
		int[][] adj = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			Arrays.fill(adj[i], (int)1e9);
			adj[i][i] = 0;
		}
		
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
		
			adj[s][e] = Math.min(adj[s][e], cost);
		}
		
		for(int k=1;k<n+1;k++)
			for(int i=1;i<n+1;i++)
				for(int j=1;j<n+1;j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++)
				System.out.print(adj[i][j]>=(int)1e9?0+" ":adj[i][j]+" ");
			System.out.println();
		}
	}
}
