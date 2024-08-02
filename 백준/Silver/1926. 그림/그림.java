import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static boolean[][] visited;
	static int n,m;
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());	//행
		m = Integer.valueOf(st.nextToken());	//열
		
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				board[i][j] = Integer.valueOf(st.nextToken());
		}
		
		int max = 0;
		int cnt = 0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(!visited[i][j] && board[i][j] == 1) {
					sum = 1;
					cnt += dfs(i, j);
					
					max = Math.max(max, sum);
				}
		System.out.println(cnt+"\n"+max);
	}

	private static int dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<n && ny>=0 && ny<m)
				if(!visited[nx][ny] && board[nx][ny] == 1) {
					sum++;
					dfs(nx, ny);
				}
		}
		return 1;
	}

}
