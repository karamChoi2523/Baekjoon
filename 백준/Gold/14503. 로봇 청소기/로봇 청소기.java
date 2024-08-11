import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] board;	//1이 벽, 0이 빈 칸
	static boolean[][] clean;
	static int[] dx = new int[] {-1,0,1,0};
	static int[] dy = new int[] {0,1,0,-1};
	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		board = new int[n][m];
		clean = new boolean[n][m];
	
		//북(위.0) 동(오.1) 남(아래.2) 서(왼.3)
		st = new StringTokenizer(br.readLine());
		//로봇 청소기
		int r = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());
		int d = Integer.valueOf(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				board[i][j] = Integer.valueOf(st.nextToken());				
			}
		}
		
		answer = 1;
		dfs(r,c,d);
		
		System.out.println(answer);
	}
	
	private static void dfs(int r, int c, int dir) {
		clean[r][c] = true;
		//방 체크
		//현재 기준으로 반시계 방향 90도씩 돌다가 청소x칸 있으면 바로 전진
		for(int i=0;i<4;i++) {
			dir = (dir+3)%4;	//반시계 방향으로 회전
			int nx = r+dx[dir];
			int ny = c+dy[dir];
						
			if(nx>=0&&nx<n&&ny>=0&&ny<m)
				if(!clean[nx][ny] && board[nx][ny]==0) {
					answer++;
					dfs(nx, ny, dir);
					return;
				}
		}

		//후진
		int nx = r+dx[dir]*(-1);
		int ny = c+dy[dir]*(-1);
		
		if(nx>=0 && nx<n && ny>=0 && ny<m)
			if(board[nx][ny]==0) {
				dfs(nx, ny, dir);
			}
	}
}
