import java.io.*;
import java.util.*;

public class Solution {
	static int N, K;
	static int[][] board;
	static ArrayList<int[]> startPosList;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int res;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {			
			initialize(br);
			
			res = -1;
			for(int[] start : startPosList) {
				visited = new boolean[N][N];
				visited[start[0]][start[1]] = true;
				dfs(start[0], start[1], 1, false);
			}
			
			System.out.printf("#%d %d\n",tc,res);
		}
	}
	static void dfs(int x, int y, int len, boolean dig) {
		res = Math.max(res, len);
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(!checkNext(nx, ny) || visited[nx][ny]) continue;
			if(board[nx][ny]>=board[x][y]) {
				int diff = board[nx][ny]-board[x][y];
				if(diff+1<=K && !dig) {
					board[nx][ny] -= (diff+1);
					visited[nx][ny] = true;
					dfs(nx, ny, len+1, true);
					board[nx][ny] += (diff+1);
					visited[nx][ny] = false;
				}
			}else {
				visited[nx][ny] = true;
				dfs(nx, ny, len+1, dig);
				visited[nx][ny] = false;
			}
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		startPosList = new ArrayList<>();
		int max = -1;
		
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]>max) {
					startPosList = new ArrayList<>();
					max = board[i][j];
					startPosList.add(new int[] {i,j});
				}else if(board[i][j]==max)
					startPosList.add(new int[] {i,j});
			}
		}
	}
}
