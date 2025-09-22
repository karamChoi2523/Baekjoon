import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;
	static int N, M;
	static int G,R;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max;
	static ArrayList<int[]> points;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		points = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==2)
					points.add(new int[] {i,j});
			}
		}
		
		max = -1;
		comb(0,0,0,0, new Fuel[R+G]);
		
		System.out.println(max);
	}
	private static void comb(int idx, int k, int green, int red, Fuel[] arr) {
		if(green==G && red==R) {
			bfs(arr);
			return;
		}
		
		if(idx==points.size()) return;

		int[] point = points.get(idx);
		if(green<G) {
			arr[k] = new Fuel(point[0], point[1], 'g');
			comb(idx+1, k+1, green+1, red, arr);
		}
		if(red<R) {
			arr[k] = new Fuel(point[0], point[1], 'r');
			comb(idx+1, k+1, green, red+1, arr);
		}
		comb(idx+1, k, green, red, arr);
	}
	private static void bfs(Fuel[] list) {
		Queue<Fuel> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		for(Fuel f : list) {
			q.add(f);
			visited[f.x][f.y] = true;
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			Map<Pair, Set<Character>> hMap = new HashMap<>();
			for(int i=0;i<size;i++) {
				Fuel curr = q.poll();
				
				for(int d=0;d<4;d++) {
					int nx = curr.x+dx[d];
					int ny = curr.y+dy[d];
					
					if(!checkNext(nx, ny) || visited[nx][ny]) continue;
					
					Pair key = new Pair(nx, ny);
					hMap.computeIfAbsent(key, k->new HashSet<>()).add(curr.type);
				}
			}
			
			for(Pair p : hMap.keySet()) {
				Set<Character> cs = hMap.get(p);
				
				if(cs.size()==2) cnt++;
				else {
					q.add(new Fuel(p.x, p.y, cs.iterator().next()));
				}
				visited[p.x][p.y] = true;
			}
		}
		
		max = Math.max(max, cnt);
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		if(board[x][y]==0) return false;
		return true;
	}
	static class Pair{
		int x, y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			Pair p = (Pair)obj;
			return this.x==p.x && this.y==p.y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
	static class Fuel{
		char type;
		int x, y;
		
		Fuel(int x, int y, char type){
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
}
