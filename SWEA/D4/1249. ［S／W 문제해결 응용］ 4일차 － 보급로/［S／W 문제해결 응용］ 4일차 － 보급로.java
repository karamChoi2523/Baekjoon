import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] board = new int[N][N];
			
			for(int i=0;i<N;i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j=0;j<N;j++)
					board[i][j] = temp[j]-'0';
			}
			
			int res = dijkstra2(N, board);
			
			System.out.printf("#%d %d\n", tc, res);
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	private static int dijkstra(int N, int[][] board) {
		Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int[][] dist = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], (int)1e9);
		dist[0][0] = 0;
		pq.add(new int[] {0,0,0});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int x = curr[0];
			int y = curr[1];
			int w = curr[2];
			
			if(x==N-1 && y==N-1)
				return w;
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				int cost = dist[x][y] + board[nx][ny];
				if(cost < dist[nx][ny]) {
					dist[nx][ny] = cost;
					pq.add(new int[] {nx, ny, cost});
				}
			}
		}
		return dist[N-1][N-1];
	}
	private static int dijkstra2(int N, int[][] board) {
			Queue<int[]> q = new ArrayDeque<>();
		
		int[][] dist = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], (int)1e9);
		dist[0][0] = 0;
		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			
			if(x==N-1 && y==N-1){
				continue;
			}
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				int cost = dist[x][y] + board[nx][ny];
				if(cost < dist[nx][ny]) {
					dist[nx][ny] = cost;
					q.add(new int[] {nx, ny});
				}
			}
		}
		return dist[N-1][N-1];
	}
}
