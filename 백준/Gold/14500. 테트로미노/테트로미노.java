import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int m;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i,j,arr[i][j],1);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	private static void dfs(int x, int y, int sum, int cnt) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}

		for(int i = 0; i < 4; i++) {
			int dx = x + dr[i];
			int dy = y + dc[i];

			if(dx>=0 && dy>=0 && dx<n && dy<m)
			if(!visited[dx][dy]) {
				if(cnt == 2) {
					visited[dx][dy] = true;
					dfs(x, y, sum + arr[dx][dy], cnt + 1);
					visited[dx][dy] = false;
				}

				visited[dx][dy] = true;
				dfs(dx, dy, sum + arr[dx][dy], cnt + 1);
				visited[dx][dy] = false;
			}
		}		
	}

}
