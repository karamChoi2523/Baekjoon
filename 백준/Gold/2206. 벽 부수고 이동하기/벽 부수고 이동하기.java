import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			Pos p = (Pos) obj;
			return this.x==p.x && this.y==p.y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x,y);
		}
	}
	static int N, M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] board;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int i=0;i<N;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<M;j++)
				board[i][j] = temp[j]-'0';
		}
		
		bfs();
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1,0});
		//해당 위치에 여러 번 갈 수 있다면 3차원 배열이 필요
		//bfs는 먼저 온 게 최단경로
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			int cx = curr[0];
			int cy = curr[1];
			int cnt = curr[2];
			int did = curr[3];
			
			if(cx==N-1 && cy==M-1) {
				min = Math.min(min, cnt);
				break;
			}
			
			for(int d=0;d<4;d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];
				
				if(checkNext(nx, ny) &&!visited[nx][ny][did]) {
					if(board[nx][ny]==1 && did==0) {
						visited[nx][ny][1] = true;
						q.add(new int[] {nx, ny,cnt+1, 1});
					}else if(board[nx][ny]!=1){
						visited[nx][ny][did] = true;
						q.add(new int[] {nx, ny,cnt+1,did});
					}
				}
			}
		}
		return -1;
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;

		return true;
	}
}
