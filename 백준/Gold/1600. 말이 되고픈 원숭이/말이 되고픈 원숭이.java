import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	static int K, W, H;
	static int[][] board;

	static int[][] hMoves = {
			{-1,-2},
			{-2,-1},
			{-1,2},
			{-2,1},
			{1,2},
			{2,1},
			{1,-2},
			{2,-1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][W];
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		if(H==1 && W==1) {
			System.out.println(0);
			return;
		}
		bfs();
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,K,0}); //x,y,horse,len

		boolean[][][] visited = new boolean[H][W][K+1];
		visited[0][0][K] = true;

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			int horse = curr[2];
			int len = curr[3];

			if(cx==H-1 && cy==W-1) {
				min = Math.min(min, len);
				continue;
			}

			if(horse>0) {
				for(int[] move : hMoves) {
					int nx = cx+move[0];
					int ny = cy+move[1];

					if(nx>=0 && nx<H && ny>=0 && ny<W) {
						if(!visited[nx][ny][horse-1] && board[nx][ny]!=1) {
							visited[nx][ny][horse-1] = true;
							q.add(new int[] {nx, ny, horse-1, len+1});
						}
					}
				}
			}


			for(int d=0;d<4;d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];

				if(nx>=0 && nx<H && ny>=0 && ny<W) {
					if(!visited[nx][ny][horse] && board[nx][ny]!=1) {
						visited[nx][ny][horse] = true;
						q.add(new int[] {nx,ny,horse,len+1});
					}
				}
			}
		}
	}
}