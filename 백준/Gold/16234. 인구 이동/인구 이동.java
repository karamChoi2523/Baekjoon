import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] board;
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
			boolean isMove = false;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					if(!visited[i][j]) {
						if(bfs(i, j))
							isMove = true;
					}
			if(!isMove) break;
			day++;
		}
		System.out.println(day);
	}
	private static boolean bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new int[] {x, y});
		
		List<int[]> posList = new ArrayList<>();
		posList.add(new int[] {x, y});
		
		int size = 1;
		int total = board[x][y];
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = curr[0]+dx[i];
				int ny = curr[1]+dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(!visited[nx][ny] && isOpen(curr[0],curr[1],nx,ny)) {
						q.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						posList.add(new int[] {nx, ny});
						size++;
						total += board[nx][ny];
					}
				}
			}
		}
		
		if(size<=1) return false;
		
		int res = total/size;
		for(int[] pos : posList) {
			board[pos[0]][pos[1]] = res;
		}
		
		return true;
	}
	static boolean isOpen(int fx, int fy, int sx, int sy) {
		int diff = Math.abs(board[fx][fy]-board[sx][sy]);
		if(diff>=L && diff<=R)
			return true;
		return false;
	}
}