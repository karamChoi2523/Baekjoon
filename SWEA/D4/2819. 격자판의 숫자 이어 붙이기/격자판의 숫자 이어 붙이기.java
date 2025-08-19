import java.io.*;
import java.util.*;

public class Solution {
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			board = new int[4][4];
			set = new HashSet<>();
			
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<4;i++)
				for(int j=0;j<4;j++)
					dfs(i,j,new StringBuilder());
			
			System.out.printf("#%d %d\n",tc,set.size());
		}
	}
	static void dfs(int x, int y, StringBuilder sb) {
		if(sb.toString().length()==7) {
			String s = sb.toString();
			set.add(s);
			return;
		}
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append(sb.toString()).append(String.valueOf(board[x][y]));
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(!checkNext(nx, ny)) continue;
			dfs(nx, ny, sb2);
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=4 || y<0 || y>=4) return false;
		
		return true;
	}
}
