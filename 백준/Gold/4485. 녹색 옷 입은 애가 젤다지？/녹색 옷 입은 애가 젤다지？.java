import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			board = new int[N][N];
			
			StringTokenizer st;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			int res = dijkstra();
			
			System.out.printf("Problem %d: %d\n", cnt++, res);
		}
	}
	static class Node implements Comparable<Node>{
		int x, y, cost;
		
		Node(int x, int y, int c){
			this.x = x;
			this.y = y;
			cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		int[][] dist = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], (int)1e9);
		
		pq.add(new Node(0,0,board[0][0]));
		dist[0][0] = board[0][0];
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.x][curr.y]) continue;
			visited[curr.x][curr.y] = true;
			
			for(int d=0;d<4;d++) {
				int nx = curr.x+dx[d];
				int ny = curr.y+dy[d];
				
				if(!checkNext(nx, ny) || visited[nx][ny]) continue;
				int cost = curr.cost+board[nx][ny];
				if(dist[nx][ny]>cost) {
					dist[nx][ny] = cost;
					pq.add(new Node(nx, ny, cost));
				}
			}
		}
		
		return dist[N-1][N-1];
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
	}
}
