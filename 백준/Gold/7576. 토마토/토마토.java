import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] board;
	static ArrayList<int[]> list;
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		
		board = new int[n][m];
		list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<m;j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
				if(board[i][j] == 1)
					list.add(new int[] {i,j});
			}
		}
		
		int answer = bfs() - 1;
		
		LOOP:for(int i=0;i<n;i++)				
				for(int j=0;j<m;j++) {
					if(board[i][j]==0) {
						answer = -1;
						break LOOP;
					}
				}
		
		System.out.println(answer);
		
		
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<list.size();i++)
			q.offer(list.get(i));
		
		int x=0;
		int y=0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			x = curr[0];
			y = curr[1];
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m)
					if(board[nx][ny]==0) {
						board[nx][ny] = board[x][y]+1;
						q.offer(new int[]{nx, ny});
					}
			}
		}
		return board[x][y];
	}

}
