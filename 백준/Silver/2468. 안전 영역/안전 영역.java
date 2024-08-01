import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static boolean[][] visited;
	
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		
		board = new int[n][n];
	
		int maxH = Integer.MIN_VALUE;	//가장 높은 곳도 잠기면 0개이다
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n;j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
				maxH = Math.max(maxH, board[i][j]);
			}
		}
		
		//잠긴 곳이 없으면 안전 영역 개수는 1개
		//모두 잠기면 0개
		int max = 0;
		for(int h=0;h<maxH+1;h++) {
			visited = new boolean[n][n];
			
			int cnt = 0;
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(!visited[i][j] && board[i][j] >h)
						//cnt += dfs(i,j,h);
						cnt+=bfs(i,j,h);
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}

	private static int bfs(int x, int y, int height) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int i=0;i<4;i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n)
					if(!visited[nx][ny] && board[nx][ny] > height) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
			}
		}
		
		return 1;		
	}

	private static int dfs(int x, int y, int height) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<n && ny>=0 && ny<n) {
				if(!visited[nx][ny] && board[nx][ny] > height) {
					dfs(nx, ny, height);
				}
			}
		}
		
		return 1;
	}


}
