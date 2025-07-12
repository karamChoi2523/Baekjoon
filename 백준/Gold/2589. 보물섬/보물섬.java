import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max = 0;
	static char[][] map;
	static int n, m;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for(int i=0;i<n;i++)
			map[i] = br.readLine().toCharArray();
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(map[i][j]=='L') {
					visited = new boolean[n][m];
					max = Math.max(max, bfs(i,j));
				}
		System.out.println(max);
	}
	
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y,0});
		visited[x][y] = true;
		
		int len = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			int cost = curr[2];
			
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(!visited[nx][ny] && map[nx][ny]=='L') {
						visited[nx][ny] = true;
						q.add(new int[] {nx, ny, cost+1});
						len = Math.max(len, cost+1);
					}
				}
			}
		}
		
		return len;
	}
}