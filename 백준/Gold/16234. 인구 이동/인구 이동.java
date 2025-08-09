import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int day = 0;
		while(true) {
			boolean isMoved = false;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					if(!visited[i][j]) {
						if(bfs(i,j))
							isMoved = true;
					}
			if(!isMoved) break;
			day++;
		}
		
		System.out.println(day);
	}
	static boolean bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		int total = board[x][y];
		int size = 1;
		ArrayList<int[]> posList = new ArrayList<>();
		posList.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for(int d=0;d<4;d++) {
				int nx = curr[0]+dx[d];
				int ny = curr[1]+dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(!visited[nx][ny] && isUnion(curr[0],curr[1],nx,ny)) {
						q.add(new int[] {nx, ny});
						total += board[nx][ny];
						size++;
						visited[nx][ny] = true;
						posList.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		if(size<=1) return false;
		
		makeUnion(posList, total/size);
		return true;
	}
	
	static void makeUnion(ArrayList<int[]> posList, int num) {
		for(int[] pos : posList) {
			board[pos[0]][pos[1]] = num;
		}
	}
	
	static boolean isUnion(int r1, int c1, int r2, int c2) {
		int diff = Math.abs(board[r1][c1]-board[r2][c2]);
		
		return diff>=L && diff<=R;
	}
}