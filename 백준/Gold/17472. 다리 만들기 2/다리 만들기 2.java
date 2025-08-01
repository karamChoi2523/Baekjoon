import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}
	static int N,M;
	static char[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Edge>[] edges;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				board[i][j] = st.nextToken().charAt(0);
		}
		
		//섬 확인
		char c = checkIsland();
		int size = c-'A';
		
		//각 섬 연결되는 경우 모두 구하기
		//가로로 쭉 뻗어보고 세로로도 쭉 뻗어보고...
		edges = new ArrayList[size];
		for(int i=0;i<size;i++)
			edges[i] = new ArrayList<>();
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				if(board[i][j]!='0') {
					checkLeft(i, j, board[i][j]);
					checkRight(i, j, board[i][j]);
					checkUp(i, j, board[i][j]);
					checkDown(i,j, board[i][j]);
				}
			}
		
		//어느 다리를 연결할까		
		int res = sol(0, size);
		System.out.println(res);
	}
	static int sol(int start, int size) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[size];
		pq.add(new Edge(start, 0));
		
		int cnt = 0;
		int sum = 0;
		
		while(!pq.isEmpty()) {
			Edge curr= pq.poll();
						
			if(visited[curr.to]) continue;
			visited[curr.to] = true;
			cnt++;
			sum += curr.cost;
			
			for(Edge next : edges[curr.to])
				if(!visited[next.to])
					pq.add(next);
		}
		
		if(cnt != size)
			return -1;
		
		return sum;
	}
	static void check(int from, int to, int cost) {
	    boolean updated = false;
	    for (int i = 0; i < edges[from].size(); i++) {
	        Edge next = edges[from].get(i);
	        if (next.to == to) {
	            if (next.cost > cost) {
	                edges[from].set(i, new Edge(to, cost));
	            }
	            updated = true;
	            break;
	        }
	    }
	    if (!updated) {
	        edges[from].add(new Edge(to, cost));
	    }

	    updated = false;
	    for (int i = 0; i < edges[to].size(); i++) {
	        Edge next = edges[to].get(i);
	        if (next.to == from) {
	            if (next.cost > cost) {
	                edges[to].set(i, new Edge(from, cost));
	            }
	            updated = true;
	            break;
	        }
	    }
	    if (!updated) {
	        edges[to].add(new Edge(from, cost));
	    }
	}

	private static void checkLeft(int x, int y, char c) {
		y--;
		int cost = 0;
		while(y>=0 && board[x][y]=='0') {
			y--;
			cost++;
		}
		
		if(y>=0 && board[x][y]!='0' && board[x][y]!=c && cost>=2)
			check(c-'A', board[x][y]-'A', cost);
	}
	private static void checkRight(int x, int y, char c) {
		y++;
		int cost = 0;
		while(y<M && board[x][y]=='0') {
			y++;
			cost++;
		}
		
		if(y<M && board[x][y]!='0' && board[x][y]!=c && cost>=2)
			check(c-'A', board[x][y]-'A', cost);
	}
	private static void checkUp(int x, int y, char c) {
		x--;
		int cost = 0;
		while(x>=0 && board[x][y]=='0') {
			x--;
			cost++;
		}
		
		if(x>=0 && board[x][y]!='0' && board[x][y]!=c && cost>=2)
			check(c-'A', board[x][y]-'A', cost);
	}
	private static void checkDown(int x, int y, char c) {
		x++;
		int cost = 0;
		while(x<N && board[x][y]=='0') {
			x++;
			cost++;
		}
		
		if(x<N && board[x][y]!='0' && board[x][y]!=c && cost>=2)
			check(c-'A', board[x][y]-'A', cost);
	}
	static char checkIsland() {
		char c = 'A';
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(board[i][j]=='1')
					bfs(i, j, c++);
		
		return c;
	}
	static void bfs(int x, int y, char num) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		board[x][y] = num;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];

			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M)
					if(board[nx][ny]=='1') {
						board[nx][ny] = num;
						q.add(new int[] {nx, ny});
					}
			}
		}
	}
}
