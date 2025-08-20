import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		//int T = 10;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];

			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j]!=0 && board[i][j]!=1 && board[i][j]!=2)
						board[i][j]=0;
				}
			}

			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;
			int res = bfs(A,B,C,D);

			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
	}
	static int min = Integer.MAX_VALUE;
	static int bfs(int sx, int sy, int fx, int fy) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][N][N*N];
		q.add(new int[] {sx, sy, 0});
		visited[sx][sy][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int step=0;step<size;step++) {
				int[] curr = q.poll();
				int cx = curr[0];
				int cy = curr[1];
				int cnt = curr[2];
				
				for(int d=0;d<4;d++) {
					int nx = cx+dx[d];
					int ny = cy+dy[d];
										
					if(check(nx, ny) && !visited[nx][ny][cnt]) {
						if(nx==fx && ny==fy)
							return cnt+1;
						if(board[nx][ny]==2 && (cnt-2)%3!=0) {
							q.add(new int[] {cx,cy,cnt+1});
							continue;
						}
						visited[nx][ny][cnt] = true;
						q.add(new int[] {nx,ny,cnt+1});
						
					}
				}
			}
		}
		return -1;
	}
	static boolean check(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		if(board[x][y]==1) return false;
		
		return true;
	}
}
