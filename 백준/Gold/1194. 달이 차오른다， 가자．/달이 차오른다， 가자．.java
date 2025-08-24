import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M;
	static int sx, sy;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		initialize(br);
		
		sol();
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	static class State{
		int x, y, cnt;
		int key;
		
		State(int x, int y, int cnt, int key){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}
	static void sol() {
		Queue<State> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][1<<6];	//열쇠가 6개니까 6bit
		q.add(new State(sx,sy,0,0));
		visited[sx][sy][0] = true;
		
		while(!q.isEmpty()) {
			State curr = q.poll();
			int cx = curr.x;
			int cy = curr.y;
			
			if(board[cx][cy]=='1') {
				min = Math.min(min, curr.cnt);
			}
			
			for(int d=0;d<4;d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];
				int nk = curr.key;
				
				if(!checkNext(nx, ny) || visited[nx][ny][nk]) continue;
				if(board[nx][ny]>='a' && board[nx][ny]<='f') {
					nk |= (1<<board[nx][ny]-'a');	//열쇠 획득
				}else if(board[nx][ny]>='A' && board[nx][ny]<='F') {
					if((nk & (1<<board[nx][ny]-'A'))==0) continue;
					//문에 해당하는 열쇠가 1로 표시되어 있는지
					//0이면 열쇠가 없는 것임
				}
				
				visited[nx][ny][nk] = true;
				q.add(new State(nx, ny, curr.cnt+1, nk));
			}
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		if(board[x][y]=='#') return false;
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			board[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++)
				if(board[i][j]=='0') {
					sx = i;
					sy = j;
				}
		}
	}
}
