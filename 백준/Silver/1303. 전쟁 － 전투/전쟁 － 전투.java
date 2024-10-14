import java.io.*;
import java.util.*;


public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] adj;
	static int n,m;
	static boolean[][] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");

		n = Integer.valueOf(str[0]);
		m = Integer.valueOf(str[1]);
		
		adj = new char[m][n];
		visited = new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++)
				adj[i][j] = s.charAt(j);
		}
		
		int w=0,b=0;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++)
				if(!visited[i][j]) {
					cnt = 0;
					dfs(i,j, adj[i][j]);
					
					if(adj[i][j]=='W')
						w+=Math.pow(cnt, 2);
					else
						b+=Math.pow(cnt, 2);
				}
		}
		
		System.out.println(w+" "+b);
	}

	private static void dfs(int x, int y, char target) {
		visited[x][y] = true;
		cnt++;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<m && ny>=0 && ny<n) {
				if(!visited[nx][ny] && adj[nx][ny]==target)
					dfs(nx, ny, target);
			}
		}
	}
}
