import java.io.*;
import java.util.*;

public class Main {
	static char[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		graph = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			
			for(int j=0;j<n;j++) {
					graph[i][j] = str.charAt(j);
					graph[j][i] = str.charAt(j);
				}
			graph[i][i]=0;
		}
		
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++) {
					if(i==j)
						continue;
					if(graph[i][j]=='Y' || (graph[i][k]=='Y' && graph[k][j]=='Y') )
						visited[i][j] = true;
				}
		int max = -999999999;
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=0;j<n;j++)
				if(visited[i][j]==true)
					sum++;
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
