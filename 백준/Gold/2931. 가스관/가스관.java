import java.util.*;
import java.io.*;

public class Main {
	static int R,C;
	static char[][] board;
	static char[] pipes = {' ','|','-','+','1','2','3','4'};
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean isSolved = false;
	static int ex, ey;
	static int tx, ty;
	static char pipe;
	static boolean[][] visited;
	static int pCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int sx=-1, sy=-1;
		board = new char[R][C];
		visited = new boolean[R][C];
		pCnt = 1;
		isSolved = false;

		for(int i=0;i<R;i++) {
			board[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(board[i][j]=='M') {
					sx = i;
					sy = j;
				}
				if(board[i][j]!='.' && board[i][j]!='Z' && board[i][j]!='M')
					pCnt++;
			}
		}

		for(int d=0;d<4;d++) {
			int nx = sx+dx[d];
			int ny = sy+dy[d];

			if(!checkNext(nx, ny)) continue;
			dfs(nx, ny, d, 0, false);
		}

		System.out.println((ex+1)+" "+(ey+1)+" "+pipe);
	}
	static void dfs(int x, int y, int d, int cnt, boolean use) {
		if(isSolved) return;
		if(cnt==pCnt) {
			ex = tx;
			ey = ty;
			pipe = board[ex][ey];
			isSolved = true;
			return;
		}

		int dir = change(d, board[x][y]);
		if(dir==-1) return;

		int nx = x+dx[dir];
		int ny = y+dy[dir];

		if(!checkNext(nx, ny)) return;

		if(board[nx][ny]=='.') {
			if(!use) {
				for(int i=1;i<pipes.length;i++) {
					tx = nx;
					ty = ny;
					board[nx][ny] = pipes[i];
					visited[nx][ny] = true;
					dfs(nx, ny, dir, cnt+1, true);
					board[nx][ny]='.';
					visited[nx][ny] = false;
				}
			}
		}else {
			if(visited[nx][ny])
				dfs(nx, ny, dir, cnt, use);
			else {
				visited[nx][ny] = true;
				dfs(nx, ny, dir, cnt+1, use);
				visited[nx][ny] = false;
			}
		}
	}
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	static int change(int d, char pipe) {
		if(pipe=='|')
			if(d==UP || d==DOWN) return d;
		if(pipe=='-')
			if(d==LEFT||d==RIGHT) return d;
		if(pipe=='+')
			return d;
		if(pipe=='1')
			if(d==LEFT) return DOWN;
			else if(d==UP) return RIGHT;
		if(pipe=='2')
			if(d==DOWN) return RIGHT;
			else if(d==LEFT) return UP;
		if(pipe=='3')
			if(d==RIGHT) return UP;
			else if(d==DOWN) return LEFT;
		if(pipe=='4')
			if(d==RIGHT) return DOWN;
			else if(d==UP) return LEFT;

		return -1;
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=R || y<0 || y>= C) return false;
		return true;
	}
}
