import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
	static int n, m;
	static int[][] board;
	static int[][] map;
	static int[][] visited;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		board = new int[n][m];
		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			for(int j=0;j<m;j++)
				board[i][j] = s.charAt(j)-'0';
		}
		
		bfs();
		
		System.out.println(map[n-1][m-1]);
			
	}
	static void bfs()
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0});
		map[0][0]=1;
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			
			for(int i=0;i<4;i++) {
				int dx = dr[i]+current[0];
				int dy = dc[i]+current[1];
				
				if(dx>=0 && dx<n && dy>=0 && dy<m)
					if(board[dx][dy]==1 && visited[dx][dy] == 0) {
						map[dx][dy] = map[current[0]][current[1]]+1;
						visited[dx][dy]=1;
						q.add(new int[] {dx, dy});
					}
			}
		}
	}
}
