import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] board;
	static boolean[] dessert;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	static int max = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine().trim());

			board = new int[N][N];

			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			max = -1;
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) {	
					dessert = new boolean[101];
					dessert[board[i][j]] = true;
					sol(i,j,i,j,0,0);
				}

			System.out.printf("#%d %s\n",tc,max);
		}
	}
	static void sol(int sx, int sy, int x, int y, int d, int sum) {
		if(d>=3 && sx==x && sy==y) {
			max = Math.max(max, sum);
			return;
		}
		
		if(d==4) return;

		//꺾거나 가거나
		int nx = x+dx[d];
		int ny = y+dy[d];

		if(nx==sx && ny==sy) {
			if(d==3 && sum>=3)
				max = Math.max(max, sum+1);
		}else if(checkNext(sx, sy, nx, ny)) {
			dessert[board[nx][ny]] = true;
			sol(sx, sy, nx,ny,d, sum+1);
			dessert[board[nx][ny]] = false;
		}
		if(d<3) {
			nx = x+dx[d+1];
			ny = y+dy[d+1];
			
			if(nx==sx && ny==sy) {
				if(d+1==3 && sum>=3) {
					max = Math.max(max, sum+1);
				}
			}else if(checkNext(sx, sy, nx, ny)) {
				dessert[board[nx][ny]] = true;
				sol(sx, sy, nx,ny,d+1,sum+1);
				dessert[board[nx][ny]] = false;
			}
		}
	}
	static boolean checkNext(int sx, int sy, int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N || dessert[board[x][y]]) return false;
		return true;
	}
}
