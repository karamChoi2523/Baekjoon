import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int cnt;
	static int[][] board;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		board = new int[n][n];
		
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			for(int j=0;j<n;j++)
				board[i][j] = s.charAt(j)-'0';
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				if(board[i][j]!=0) {
					cnt=1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int e : list)
			System.out.println(e);
	}


	private static void dfs(int x, int y) {
		board[x][y]=0;
		
		for(int i=0;i<4;i++) {
			int dx = dr[i]+x;
			int dy = dc[i]+y;
			
			if(dx>=0 && dy>= 0 && dx<n && dy<n)
				if(board[dx][dy]==1) {
					cnt++;
					dfs(dx, dy);
				}
		}
	}

}