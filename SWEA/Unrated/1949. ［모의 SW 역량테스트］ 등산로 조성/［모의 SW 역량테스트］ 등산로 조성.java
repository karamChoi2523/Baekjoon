import java.util.*;
import java.io.*;

public class Solution {
	static int N, K;
	static int[][] board;
	static int res = -1;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			
			int max = -1;
			ArrayList<int[]> posList = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j]==max) {
						posList.add(new int[] {i,j});
					}else if(board[i][j]>max) {
						max = board[i][j];
						posList = new ArrayList<>();
						posList.add(new int[] {i,j});
					}
				}
			}
			res = -1;
			for(int[] start : posList) {
				boolean[][] visited = new boolean[N][N];
				visited[start[0]][start[1]] = true;
				backt(start[0], start[1], 1, visited, false);
			}
			System.out.printf("#%d %d\n", tc, res);
		}
	}
	private static void backt(int x, int y, int len, boolean[][] visited, boolean dig) {
		res = Math.max(res, len);
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(!checkNext(nx, ny) || visited[nx][ny]) continue;
			
			if(board[nx][ny]>=board[x][y]) {
				int diff = board[nx][ny] - board[x][y];
				
				if(diff+1<=K && !dig) {
					board[nx][ny] -= (diff+1);
					visited[nx][ny] = true;
					backt(nx, ny, len+1, visited, true);
					board[nx][ny] += (diff+1);
					visited[nx][ny] = false;
				}
			}else{
				visited[nx][ny] = true;
				backt(nx, ny, len+1, visited, dig);
				visited[nx][ny] = false;
			}
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		return true;
	}
}
