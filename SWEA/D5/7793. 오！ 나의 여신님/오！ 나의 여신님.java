import java.io.*;
import java.util.*;

public class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M;
	static char[][] board;
	static int sx, sy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {			
			initialize(br);
			int res = sol();
			System.out.printf("#%d %s\n",tc,res>=(int)1e9?"GAME OVER":String.valueOf(res));
		}
	}
	static int[][] devilCheck(){
		Queue<int[]> devils = new ArrayDeque<>();
		int[][] dist = new int[N][M];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], (int)1e9);
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(board[i][j]=='*') {
					devils.add(new int[] {i,j});
					dist[i][j] = 0;
				}
		while(!devils.isEmpty()){
			int[] devil = devils.poll();
		
			for(int d=0;d<4;d++) {
				int nx = devil[0]+dx[d];
				int ny = devil[1]+dy[d];
				
				if(checkNext(nx, ny)) {
					if(board[nx][ny]=='D') continue;
					if(dist[nx][ny]!=(int)1e9) continue;
					devils.add(new int[] {nx, ny});
					dist[nx][ny] = dist[devil[0]][devil[1]]+1;
				}
			}
		}
		return dist;
	}
	static int sol() {
		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(sx, sy, 0));
		boolean[][] visited = new boolean[N][M];
		visited[sx][sy] = true;
		int[][] devilDist = devilCheck();

		while(!pq.isEmpty()) {
			//이동
			Node curr = pq.poll();
						
			if(board[curr.x][curr.y]=='D') {
				return curr.time;
			}
			
			for(int d=0;d<4;d++) {
				int nx = curr.x+dx[d];
				int ny = curr.y+dy[d];
				
				if(!checkNext(nx, ny)||visited[nx][ny]) continue;
				if(board[nx][ny]=='*') continue;
				if(curr.time+1<devilDist[nx][ny]) {
					visited[nx][ny] = true;
					pq.add(new Node(nx, ny, curr.time+1));
				}
			}
		}
		
		return (int)1e9;
	}
	static class Node implements Comparable<Node>{
		int x, y, time;
		
		Node(int x, int y, int t){
			this.x = x;
			this.y = y;
			time = t;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.time-o.time;
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		if(board[x][y]=='X') return false;
		
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		
		for(int i=0;i<N;i++) {
			board[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++)
				if(board[i][j]=='S') {
					sx = i;
					sy = j;
				}
		}
	}
}
