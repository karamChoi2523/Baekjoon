import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int answer = 0;
	static char[][] board;
	static int R, C, K;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			board[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++)
				if(board[i][j]=='T')
					visited[i][j]=true;
		}
		
		dfs(R-1,0, 1);
		
		
		System.out.println(answer);
	}
	
	static void dfs(int x, int y, int depth) {
		visited[x][y] = true;
		
		if(depth>K) return;
		
		if(x==0 && y==C-1) {
			if(depth==K)
				answer++;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<R && ny>=0 && ny<C)
				if(!visited[nx][ny]) {
					dfs(nx, ny, depth+1);
					visited[nx][ny] = false;
				}
		}
	}
}