import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static int w, h;
	static int[][] board;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			board = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			for(int i=0;i<h;i++)
				for(int j=0;j<w;j++)
					if(!visited[i][j] && board[i][j]==1) {
						dfs(i, j);
						answer++;
					}
			
			System.out.println(answer);
		}
	}
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0;i<8;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(!checkBoard(nx, ny)) continue;
			
			if(board[nx][ny]==1)
				dfs(nx, ny);
		}
	}
	static boolean checkBoard(int x, int y) {
		if(x>=0 && x<h && y>=0 && y<w && !visited[x][y]) return true;
		
		return false;
	}
}