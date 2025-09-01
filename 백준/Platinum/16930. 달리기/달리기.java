import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static char[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min;
	static int sx, sy, ex, ey;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		initialize(br);

		int res = sol();

		System.out.println(res);
	}
	static int sol() {
		Queue<int[]> q = new ArrayDeque<>();
		int[][] dist = new int[N][M];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		q.add(new int[] {sx, sy});
		dist[sx][sy] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			int x = curr[0];
			int y = curr[1];
			
			if(x==ex && y==ey)
				return dist[x][y];
			
			for(int d=0;d<4;d++) {
				for(int i=1;i<=K;i++) {
					int nx = x+dx[d]*i;
					int ny = y+dy[d]*i;
					
					if(!checkNext(nx, ny)) break;
					if(dist[nx][ny]<dist[x][y]+1) break;
                    if(dist[nx][ny]==dist[x][y]+1) continue;
					dist[nx][ny] = dist[x][y]+1;
					q.add(new int[] {nx, ny});
				}
			}
			
		}
		
		return -1;
	}

	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		if(board[x][y]=='#') return false;
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		min = Integer.MAX_VALUE;

		for(int i=0;i<N;i++)
			board[i] = br.readLine().toCharArray();	

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken())-1;
		sy = Integer.parseInt(st.nextToken())-1;
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
	}
}

