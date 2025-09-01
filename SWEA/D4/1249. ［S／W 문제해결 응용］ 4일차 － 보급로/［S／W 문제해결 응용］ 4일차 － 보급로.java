import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			for(int i=0;i<N;i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j=0;j<N;j++)
					board[i][j] = temp[j]-'0';
			}
			
			
			int res = dijkstra();
			
			System.out.printf("#%d %d\n",tc, res);
		}
		
		
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int dijkstra() {
		Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		int[][] dist = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		boolean[][] visited = new boolean[N][N];
		pq.add(new int[] {0,0,0});
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int x = curr[0];
			int y = curr[1];
			int time = curr[2];
			
			if(visited[x][y]) continue;
			visited[x][y] = true;
			
			if(x==N-1 && y==N-1)
				return time;
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(!checkNext(nx, ny)||visited[nx][ny]) continue;
				int cost = dist[x][y]+board[nx][ny];
				if(dist[nx][ny] < cost) continue;
				dist[nx][ny] = cost;
				pq.add(new int[] {nx, ny, cost});
			}
		}
		return dist[N-1][N-1];
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		return true;
	}
}
