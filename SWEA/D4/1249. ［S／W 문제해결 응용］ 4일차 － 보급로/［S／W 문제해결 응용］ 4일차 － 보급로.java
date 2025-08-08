import java.util.*;
import java.io.*;

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
				for(int j=0;j<N;j++) {
					board[i][j] = temp[j]-'0';
				}
			}
			
			System.out.printf("#%d %d\n",tc, dijkstra());
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static long dijkstra() {
		Queue<int[]> q = new LinkedList<>();
		long[][] dist = new long[N][N];
		
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], Long.MAX_VALUE);
		q.add(new int[] {0,0});
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			
			for(int i=0;i<4;i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					long cost = dist[cx][cy]+board[nx][ny];
					
					if(cost >= dist[nx][ny]) continue;
					dist[nx][ny] = cost;
					q.add(new int[] {nx, ny});
				}
			}
		}
		
		return dist[N-1][N-1];
	}
}