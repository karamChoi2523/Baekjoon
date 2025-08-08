import java.io.*;
import java.util.*;

public class Main {
	static int[] papers = {5,5,5,5,5};
	static int[][] board = new int[10][10];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
//		
//		int cnt = 0;
//		for(int i=0;i<10;i++)
//			for(int j=0;j<10;j++) {
//				if(board[i][j]==1) {
//					for(int k=5;k>=1;k--)
//						if(papers[k-1]>0 && check(i, j, k)) {
//							toggle(i, j, k);
//							papers[k-1]-=1;
//							cnt++;
//						}
//				}
//			}
	
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static void dfs(int x, int y, int cnt) {
		if(y>=10) {
			x++;
			y=0;
		}
		
		if(x>=10) {
			min = Math.min(min, cnt);
			return;
		}
		
		if(board[x][y]==0) {
			dfs(x, y+1, cnt);
			return;
		}
		
		for(int i=5;i>0;i--) {
			if(papers[i-1]>0 && check(x, y, i)) {
				toggle(x, y, i);
				papers[i-1]--;
				dfs(x, y+i, cnt+1);
				toggle(x, y, i);
				papers[i-1]++;
			}
		}
	}
	static boolean check(int x, int y, int size) {
		if(x+size>10 || y+size>10) return false;
		
		for(int i=x;i<x+size;i++)
			for(int j=y;j<y+size;j++)
				if(board[i][j]!=1)
					return false;
		
		return true;
	}
	static void toggle(int x, int y, int size) {
		for(int i=x;i<x+size;i++)
			for(int j=y;j<y+size;j++)
				board[i][j] = board[i][j]==0?1:0;
	}
}