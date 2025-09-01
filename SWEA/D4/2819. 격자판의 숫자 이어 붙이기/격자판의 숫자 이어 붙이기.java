import java.io.*;
import java.util.*;


public class Solution {
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Set<String> hSet;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		//int T = 10;
		for(int tc=1;tc<=T;tc++) {
			initialize(br);
			
			for(int i=0;i<4;i++)
				for(int j=0;j<4;j++)
					sol(i,j,0,"");
			
			System.out.printf("#%d %d\n", tc,hSet.size());
		}
	}
	static void sol(int x, int y, int idx, String curr) {
		if(idx==7) {
			hSet.add(curr);
			return;
		}
		
		curr += String.valueOf(board[x][y]);
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
			sol(nx, ny, idx+1, curr);
		}
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		
		board = new int[4][4];
		hSet = new HashSet<>();
		
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
	}
}
