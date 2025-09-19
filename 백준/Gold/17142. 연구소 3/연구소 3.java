import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] board;
	static ArrayList<int[]> pos;
	static Cell[] cells;
	static int N, M;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		pos = new ArrayList<>();
		cells = new Cell[M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==2)
					pos.add(new int[] {i,j});
			}
		}
		
		min = Integer.MAX_VALUE;
		comb(0,0);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static void comb(int idx, int k) {
		if(k==M) {
			int res = play();
			min = Math.min(min, res);
			return;
		}
		
		if(idx>=pos.size()) return;
		
		int[] curr = pos.get(idx);
		cells[k] = new Cell(curr[0], curr[1]);
		comb(idx+1,k+1);
		comb(idx+1,k);
	}
	private static int play() {
		Queue<Cell> q = new ArrayDeque<>();
		int[][] visited = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		
		for(Cell cell : cells) {
			q.add(cell);
			visited[cell.x][cell.y] = 0;
		}
		int max = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Cell c = q.poll();
				
				for(int d=0;d<4;d++) {
					int nx = c.x+dx[d];
					int ny = c.y+dy[d];
					
					if(!checkNext(nx,ny)||visited[nx][ny]!=Integer.MAX_VALUE) continue;
					q.add(new Cell(nx, ny));
					visited[nx][ny] = visited[c.x][c.y]+1;
					if(board[nx][ny]==0)
						max = Math.max(max, visited[nx][ny]);
					
					if(max>=min) return Integer.MAX_VALUE;
				}
			}
		}
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(visited[i][j]==Integer.MAX_VALUE && board[i][j]==0)
					return Integer.MAX_VALUE;
		
		return max;
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		if(board[x][y]==1) return false;
		return true;
	}
	static class Cell{
		int x, y;

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
}
