import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int sx, sy;
	static char[][] board;
	static int[][] devilTime;
	static Queue<int[]> devils;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st;
			
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			board = new char[N][M];
			devils = new ArrayDeque<>();
			devilTime = new int[N][M];
			for(int i=0;i<N;i++)
				Arrays.fill(devilTime[i], Integer.MAX_VALUE);
			
			for(int i=0;i<N;i++) {
				board[i] = br.readLine().toCharArray();
				for(int j=0;j<M;j++)
					if(board[i][j]=='S') {
						sx = i;
						sy = j;
					}else if(board[i][j]=='*') {
						devils.add(new int[] {i,j});
						devilTime[i][j] = 0;
					}
			}			
			
			goDevils();
			
			int res = move();
			
			System.out.printf("#%d %s\n",tc,res==-1?"GAME OVER":String.valueOf(res));
		}
	}
	static int move() {
		Queue<int[]> q = new ArrayDeque<>();
		int[][] dist = new int[N][M];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[sx][sy] = 0;
		boolean[][] visited = new boolean[N][M];
		
		q.add(new int[] {sx, sy});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			if(board[x][y]=='D')
				return dist[x][y];
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(!checkNext(nx, ny)||visited[nx][ny]) continue;
				int cost = dist[x][y]+1;
				if(dist[nx][ny]>cost && cost<devilTime[nx][ny]) {
					dist[nx][ny] = cost;
					q.add(new int[] {nx, ny});
				}
			}
		}
		return -1;
	}
	private static void goDevils() {
		while(!devils.isEmpty()) {
			int[] curr = devils.poll();
			
			int x = curr[0];
			int y = curr[1];
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(!checkNext(nx, ny)) continue;
				if(board[nx][ny]=='D') continue;
				
				int cost = devilTime[x][y]+1;
				if(devilTime[nx][ny] > cost) {
					devilTime[nx][ny] = cost;
					devils.add(new int[] {nx, ny});
				}
			}
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		if(board[x][y]=='X') return false;
		
		return true;
	}
}
