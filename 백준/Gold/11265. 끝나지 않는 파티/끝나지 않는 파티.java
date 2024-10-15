import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		int[][] adj = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<n+1;j++)
				adj[i][j] = Integer.valueOf(st.nextToken());
		}
		
		for(int k=1;k<n+1;k++)
			for(int i=1;i<n+1;i++)
				for(int j=1;j<n+1;j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			
			if(adj[a][b]<=c)
				sb.append("Enjoy other party\n");
			else
				sb.append("Stay here\n");
		}
		System.out.println(sb.toString());
	}
}
