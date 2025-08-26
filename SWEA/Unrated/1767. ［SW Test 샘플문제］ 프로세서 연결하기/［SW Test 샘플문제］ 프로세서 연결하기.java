import java.io.*;
import java.util.*;


public class Solution {
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int maxCnt = 0;
	static ArrayList<int[]> cores;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		//int T = 10;
		for(int tc=1;tc<=T;tc++) {
			initialize(br);

			visited = new boolean[N][N];
			min = Integer.MAX_VALUE;
			maxCnt = 0;
			sol(0, 0, 0);

			System.out.printf("#%d %d\n",tc,min);
		}
	}
	static void sol(int idx, int curr, int cnt) {
		if(idx==cores.size()) {
			if(cnt > maxCnt) {
				maxCnt = cnt;
				min = curr;
			}else if(cnt == maxCnt) {
				min = Math.min(min, curr);
			}
			return;
		}

		int[] pos = cores.get(idx);

		int x = pos[0];
		int y = pos[1];

		for(int d=0;d<4;d++) {
			int len = check(x,y, d);
			if(len==-1) {
				sol(idx+1, curr, cnt);
			}else {
				toggle(x, y, d);
				sol(idx+1, curr+len, cnt+1);
				toggle(x, y, d);
			}
		}

	}
	static void toggle(int x, int y, int dir) {
		if(dir==0) {
			while(x-->0) {
				visited[x][y] = visited[x][y]?false:true;
			}
		}else if(dir==1) {
			while(x++<N-1) {
				visited[x][y] = visited[x][y]?false:true;
			}
		}else if(dir==2) {
			while(y-->0) {
				visited[x][y] = visited[x][y]?false:true;
			}
		}else if(dir==3) {
			while(y++<N-1) {
				visited[x][y] = visited[x][y]?false:true;
			}
		}
	}
	static int check(int x, int y, int dir) {
		int cnt = 0;
		if(dir==0) {
			while(x-->0) {
				if(board[x][y]==1 || visited[x][y]) return -1;
				cnt++;
			}
		}else if(dir==1) {
			while(x++<N-1) {
				if(board[x][y]==1 || visited[x][y]) return -1;
				cnt++;
			}
		}else if(dir==2) {
			while(y-->0) {
				if(board[x][y]==1 || visited[x][y]) return -1;
				cnt++;
			}
		}else if(dir==3) {
			while(y++<N-1) {
				if(board[x][y]==1 || visited[x][y]) return -1;
				cnt++;
			}
		}
		return cnt;
	}
	private static void initialize(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		cores = new ArrayList<>();
		StringTokenizer st;
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1)
					if(board[i][j]==1) {
						if(i==0 || j==0 || i==N-1 || j==N-1) continue;
						cores.add(new int[] {i,j});
					}
			}
		}
	}
}
