import java.util.*;
import java.io.*;

public class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int dir;
	static char[][] board;
	static int H, W;
	static int sx, sy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			board = new char[H][W];
			dir = -1;
			sx = -1;
			sy = -1;
			
			char[] crr = {'^','v','<','>'};
			for(int i=0;i<H;i++) {
				board[i] = br.readLine().toCharArray();
				if(dir!=-1) continue;
				loop:for(int j=0;j<W;j++) {
					for(int k=0;k<4;k++) {
						if(board[i][j]==crr[k]) {
							dir = k;
							sx = i;
							sy = j;
							board[i][j]='.';
							break loop;
						}
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			
			String s = br.readLine();
			for(int i=0;i<N;i++)
				play(s.charAt(i));
			
			board[sx][sy] = crr[dir];
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++)
					System.out.print(board[i][j]);
				System.out.println();
			}
		}
	}
	private static void play(char c) {
		if(c=='S') {
			shooting(sx, sy);
		}else {
			char[] crr = {'U','D','L','R'};
			
			for(int i=0;i<4;i++) {
				if(c==crr[i]) {
					dir = i;
					int nx = sx+dx[dir];
					int ny = sy+dy[dir];
					if(checkNext(nx, ny)) {
						sx = nx;
						sy = ny;
					}
					break;
				}
			}
		}
	}
	static void shooting(int x, int y) {
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		
		while(true) {
			if(nx<0 || nx>=H || ny<0 || ny>=W) break;
			if(board[nx][ny]=='#') break;
			if(board[nx][ny]=='*') {
				board[nx][ny] = '.';
				break;
			}
			nx += dx[dir];
			ny += dy[dir];
		}
	}
	private static boolean checkNext(int x, int y) {
		if(x<0 || x>=H || y<0 || y>=W) return false;
		if(board[x][y]=='.') return true;
		return false;
	}
}
