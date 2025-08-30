import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;

			initialize(br);
			
			int res = dijkstra();

			System.out.println("Problem "+(tc++)+": "+res);
		}
	}
	static int dijkstra() {
		Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		boolean[][] visited = new boolean[N][N];
		int[][] dist = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[0][0] = board[0][0];
		pq.add(new int[] {0,0,board[0][0]});
		//visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int x = curr[0];
			int y = curr[1];
			int total = curr[2];
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			if(x==N-1 && y==N-1) return curr[2];
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(!checkNext(nx, ny)||visited[nx][ny]) continue;
				int cost = total + board[nx][ny];
				if(dist[nx][ny]>cost) {
					dist[nx][ny] = cost;
					pq.add(new int[] {nx, ny, cost});
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;

		board = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
	}
}
