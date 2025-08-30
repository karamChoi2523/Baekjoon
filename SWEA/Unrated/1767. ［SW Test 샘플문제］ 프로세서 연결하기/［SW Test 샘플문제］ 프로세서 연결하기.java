import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<int[]> cores;
	static int maxCnt;
	static int minTotal;
	static boolean[][] visited;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {			
			initialize(br);

			dfs(0, 0, 0);

			System.out.printf("#%d %d\n",tc,minTotal);
		}
	}
	static void dfs(int idx, int cnt, int total) {
		if(idx==cores.size()) {
			if(cnt > maxCnt) {
				maxCnt = cnt;
				minTotal = total;
			}else if(cnt==maxCnt) {
				minTotal = Math.min(minTotal, total);
			}
			return;
		}

		int[] curr = cores.get(idx);
		int x = curr[0];
		int y = curr[1];
		for(int d=0;d<4;d++) {
			int len = check(x, y, d);
			if(len==-1) {
				dfs(idx+1, cnt, total);
			}else {
				toggle(x, y, d);
				dfs(idx+1, cnt+1, total+len);
				toggle(x, y, d);
			}
		}
	}
	static void toggle(int x, int y, int d) {
		while(true) {			
			x+=dx[d];
			y+=dy[d];
			if(x<0 || y<0 || x>=N || y>=N) break;
			visited[x][y] = !visited[x][y];
		}
	}
	static int check(int x, int y, int d) {
		int cnt = 0;
		
		while(true) {			
			x+=dx[d];
			y+=dy[d];
			if(x<0 || y<0 || x>=N || y>=N) break;
			if(visited[x][y] || board[x][y]==1) return -1;
			cnt++;
		}
		return cnt;
	}
	private static void initialize(BufferedReader br) throws IOException {		
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;

		maxCnt = 0;
		minTotal = Integer.MAX_VALUE;
		visited = new boolean[N][N];
		cores = new ArrayList<>();
		board = new int[N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1 && i!=0 && j!=0 && i!=N-1 && j!=N-1)
					cores.add(new int[] {i,j});
			}
		}
	}
}
