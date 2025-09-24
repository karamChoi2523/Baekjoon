import java.util.*;
import java.io.*;
public class Main {
	static int[][] board;
	static int M, N;
	//동 서 남 북 -> 우 좌 하 상
	static int[] dx = {0,0,0,1,-1};
	static int[] dy = {0,1,-1,0,0};
	static int ex, ey, eDir;
	static int K = 3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		board = new int[M][N];

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken())-1;
		int sy = Integer.parseInt(st.nextToken())-1;
		int dir = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		eDir = Integer.parseInt(st.nextToken());

		int res = bfs(sx, sy, dir);

		System.out.println(res);
	}
	private static int bfs(int sx, int sy, int dir) {
		boolean[][][] visited = new boolean[M][N][5];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx, sy, dir, 0});
		visited[sx][sy][dir] = true;

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			int cd = curr[2];
			int cnt = curr[3];

			if(cx==ex && cy==ey && cd==eDir)
				return cnt;

			for(int k=1;k<=K;k++) {
				int nx = cx+dx[cd]*k;
				int ny = cy+dy[cd]*k;

				if(!checkNext(nx, ny)) break;
				if(visited[nx][ny][cd]) continue;
				visited[nx][ny][cd] = true;
				q.add(new int[] {nx, ny, cd, cnt+1});
			}		
			//왼
			int nd = cd==1?4:cd==2?3:cd==3?1:2;
			if(!visited[cx][cy][nd]) {
				visited[cx][cy][nd] = true;
				q.add(new int[] {cx, cy, nd, cnt+1});
			}
			//오
			nd = cd==1?3:cd==2?4:cd==3?2:1;
			if(!visited[cx][cy][nd]) {
				visited[cx][cy][nd] = true;
				q.add(new int[] {cx, cy, nd, cnt+1}); 
			}
		}
		return -1;
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=M || y<0 || y>=N) return false;
		if(board[x][y] == 1) return false;
		return true;
	}
}