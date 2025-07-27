import java.io.*;
import java.util.*;

public class Main {
	static int[] papers = {5,5,5,5,5};
	//static int[][] board = new int[10][10];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[10][10];
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<10;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dfs(board, 0,0,0);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static void dfs(int[][] board, int x, int y, int cnt) {
		if(x==10) {
			for(int i=0;i<10;i++)
				for(int j=0;j<10;j++)
					if(board[i][j]==1)
						return;
			min = Math.min(min, cnt);
			return;
		}
		
		if(y==10) {
			dfs(board, x+1, 0, cnt);
			return;
		}
		
		if(board[x][y]==1) {
			for(int i=5;i>=1;i--) {
				if(papers[i-1]>0 && check(board, i, x, y)) {
					attach(board, i, x, y, 0);
					papers[i-1]--;
					dfs(board, x, y+i, cnt+1);
					attach(board, i, x, y, 1);
					papers[i-1]++;
				}
			}
		}else
			dfs(board, x, y+1, cnt);
	}
	static boolean check(int[][] board, int size, int x, int y) {
		if(x+size>10 || y+size>10)
			return false;
		
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				if(board[x+i][y+j]!=1)
					return false;
		
		return true;
	}
	static void attach(int[][] board, int size, int x, int y, int state) {
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				board[x+i][y+j] = state;
	}
}
