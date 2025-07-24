import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static int min = Integer.MAX_VALUE;
	static int[] papers = {5,5,5,5,5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[10][10];
		
		for(int i=0;i<10;i++) {	
			String[] s = br.readLine().split(" ");
			for(int j=0;j<10;j++) {
				board[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		dfs(0,0,0);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static void dfs(int x, int y, int cnt) {
		if(cnt>=min)
			return;
		
		if(x>9) {
			min = Math.min(min, cnt);
			return;
		}
		
		if(y>=10) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		if(board[x][y]==1) {
			for(int i=1;i<=5;i++) {
				if(check(x, y, i) && papers[i-1]>0) {
					change(x, y, i, 0);
					papers[i-1]--;
					dfs(x, y+1, cnt+1);
					change(x, y, i, 1);
					papers[i-1]++;
				}
			}
		}else
			dfs(x, y+1, cnt);
	}
	private static void change(int x, int y, int size, int code) {
		for(int i=x;i<x+size;i++)
			for(int j=y;j<y+size;j++)
				board[i][j] = code;
	}
	private static boolean check(int x, int y, int size) {
		if((x+size)>10||(y+size)>10)
			return false;
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++)
				if(board[i][j]==0)
					return false;
		}
		return true;
	}
}
