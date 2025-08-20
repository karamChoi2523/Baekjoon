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
	//원숭이와 말을 다른 배열로 관리하면 힘들다 => dx dy를 하나로 짤 것
	//앞에서부터 원숭이 4개, 말 4개
	static int[] dr = {-1,1,0,0,-1,-2,-1,-2,1,2,1,2};
	static int[] dc = {0,0,-1,1,-2,-1,2,1,2,1,-2,-1};
	//한 좌표에 여러 번 올 수 있음 => 3차원 배열로 방문 체크
	
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
		q.add(new int[] {0,0,0,0}); //x,y,horse,len
		
		boolean[][][] visited = new boolean[H][W][K+1];
		visited[0][0][0] = true;

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
			
			for(int d=0;d<(horse==K?4:12);d++) {
				int nx = cx+dr[d];
				int ny = cy+dc[d];
				
				int nHorse = d<4?horse:horse+1;

				if(nx>=0 && nx<H && ny>=0 && ny<W) {
					if(!visited[nx][ny][nHorse] && board[nx][ny]!=1) {
						visited[nx][ny][nHorse] = true;
						q.add(new int[] {nx,ny,nHorse,len+1});
					}
				}
			}
		}
	}
}