import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int i=0;i<N;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				board[i][j] = temp[j]-'0';
			}
		}
		
		bfs();
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1});
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = false;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			int cx = curr[0];
			int cy = curr[1];
			
			if(cx==N-1 && cy==M-1) {
				System.out.println(curr[2]);
				break;
			}
			
			for(int d=0;d<4;d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];
				
				if(checkNext(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny,curr[2]+1});
				}
			}
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		if(board[x][y]==0) return false;
		
		return true;
	}
}
