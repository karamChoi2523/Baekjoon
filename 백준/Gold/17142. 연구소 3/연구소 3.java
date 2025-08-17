import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] board;
	static int[][] select;
	static ArrayList<int[]> list;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==2)
					list.add(new int[] {i,j});
			}
		}
		select = new int[M][2];
		combination(0, 0);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static void combination(int idx, int k) {
		if(k==M) {
			bfs();
			return;
		}
		
		if(idx==list.size()) return;
		
		select[k] = list.get(idx);
		combination(idx+1, k+1);
		combination(idx+1, k);
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		int[][] map = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(map[i], -1);
		for(int[] pick : select) {
			q.add(pick);
			map[pick[0]][pick[1]] = 0;
			visited[pick[0]][pick[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int d=0;d<4;d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];
				
				if(checkNext(nx, ny) && map[nx][ny]==-1) {
					map[nx][ny] = map[cx][cy]+1;
					q.add(new int[] {nx, ny});
				}
			}
		}
		int time = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(board[i][j]==0) {
					if(map[i][j]==-1) return;
					time = Math.max(time, map[i][j]);
				}
		min = Math.min(time, min);
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		
		if(board[x][y]==1) return false;
		
		return true;
	}
}
