import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] board;
	static int max = -1;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int maxCell;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxCell = Math.max(maxCell, board[i][j]);
			}
		}
		
		max = -1;

		boolean[][] visited = new boolean[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				visited[i][j] = true;
				pick(i,j,1,board[i][j],visited);
				visited[i][j] = false;
			}
		
		System.out.println(max);
	}
	//연결된 네 곳을 선택
	private static void pick(int x, int y, int idx, int curr, boolean[][] visited) {
		if(idx == 4) {
			max = Math.max(max, curr);
			return;
		}
		
		//가지치기
		int upper = curr + (4-idx) * maxCell;
		if(upper <= max) return;
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;
			
			if(idx == 2) {	//T체크
				for(int k=d+1;k<4;k++) {
					int kx = x+dx[k];
					int ky = y+dy[k];
					
					if(kx<0 || kx>=N || ky<0 || ky>=M || visited[kx][ky]) continue;
					max = Math.max(max, curr+board[nx][ny]+board[kx][ky]);
				}
			}
			
			visited[nx][ny] = true;
			pick(nx, ny, idx+1, curr+board[nx][ny], visited);
			visited[nx][ny] = false;
		}
	}
}
