import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15723 {
	static int[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		graph = new int[26][26];
		visited = new boolean[26][26];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			
			int a = str.charAt(0)-'a';
			int b = str.charAt(5)-'a';
			
			graph[a][b] = 1;
			visited[a][b] = true;
		}
		
		for(int k=0;k<26;k++)
			for(int i=0;i<26;i++)
				for(int j=0;j<26;j++)
					if(graph[i][j]==1 || graph[i][k]+graph[k][j]>=2) {	//visited[i][k] && visited[k][j]
						graph[i][j]=1;
						visited[i][j] = true;
					}

		StringBuilder sb = new StringBuilder();
		int m = Integer.valueOf(br.readLine());
		for(int i=0;i<m;i++) {
			String str = br.readLine();
			
			int a = str.charAt(0)-'a';
			int b = str.charAt(5)-'a';
			
			if(visited[a][b]) sb.append("T\n");
			else sb.append("F\n");
		}
		
		System.out.println(sb.toString());
	}

}
