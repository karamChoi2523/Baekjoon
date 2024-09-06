import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m, t;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] board;
	static int shortest;
	static boolean[][] visited;
	static int[][] record;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		t = Integer.valueOf(st.nextToken());
	
		board = new int[n][m];
		visited = new boolean[n][m];
		shortest = n+m-1;
		record = new int[n][m];
		int sx=-1, sy=-1;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(record[i], (int)1e9);
			for(int j=0;j<m;j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
				
				if(board[i][j]==2) {
					shortest = n-i-1+m-j-1;
					sx = i;
					sy = j;
				}
			}
		}
		
		bfs();
		
		int res = record[n-1][m-1];
		
		if(res <= t)
			System.out.println(res);
		else
			System.out.println("Fail");
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		visited[0][0] = true;
		record[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				
				if(nx>=0&&nx<n&&ny>=0&&ny<m)
					if(!visited[nx][ny] && board[nx][ny]!=1) {
						q.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						record[nx][ny] = Math.min(record[nx][ny], record[cx][cy]+1);
						
						if(board[nx][ny]==2) {
							record[n-1][m-1] = Math.min(record[n-1][m-1], record[nx][ny] + shortest);
						}
					}
				
			}
		}
	}

}
