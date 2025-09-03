import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;
	static boolean[][] visited;
	static ArrayList<int[]> checked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[12][6];

		for(int i=0;i<12;i++)
			board[i] = br.readLine().toCharArray();

		int cnt = 0;
		while(true) {
			boolean gameOver = true;
			visited = new boolean[12][6];
			//탐색
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++)
					if(board[i][j]!='.'&&!visited[i][j]) {
						checked = new ArrayList<>();
						check(i,j);
						
						if(checked.size()>=4) {
							gameOver = false;
							for(int[] pos : checked) {
								board[pos[0]][pos[1]] = '.';
							}
						}
					}
			}
			if(gameOver)
				break;

			//터트리기 & 떨구기 -> visited인 곳,,
			for(int col=0;col<6;col++) {
				for(int row=11;row>=0;row--) {
					if(board[row][col]=='.') {
						for(int k=row-1;k>=0;k--)
							if(board[k][col]!='.') {
								board[row][col] = board[k][col];
								board[k][col] = '.';
								break;
							}
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static void check(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		checked.add(new int[] {x, y});

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for(int d=0;d<4;d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];

				if(nx<0 || nx>=12 || ny<0 || ny>=6 || visited[nx][ny]) continue;
				if(board[nx][ny]==board[x][y]) {
					checked.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
}
