import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static int N, M;
	static boolean[][][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		
		int sx=0, sy=0;
		for(int i=0;i<N;i++) {
			board[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++)
				if(board[i][j]=='0') {
					sx = i;
					sy = j;
				}
		}
		
		min = Integer.MAX_VALUE;
		bfs(sx, sy);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	private static void bfs(int sx, int sy) {
		Queue<Person> q = new ArrayDeque<>();
		//a b c d e f
		boolean[][][] visited = new boolean[N][M][1<<6];
		
		q.add(new Person(sx, sy, 0, 0));	//board[x][y]-'a'
		visited[sx][sy][0] = true;
		
		while(!q.isEmpty()) {
			Person curr = q.poll();
			
			int x = curr.x;
			int y = curr.y;
			int len = curr.len;
			
			if(board[x][y]=='1') {
				min = Math.min(min, len);
				continue;
			}
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				int keys = curr.keys;
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || board[nx][ny]=='#' || visited[nx][ny][keys]) continue;
				
				if(board[nx][ny]>='A' && board[nx][ny]<='F')
					if((keys & (1<<(board[nx][ny]-'A')))==0) continue;				
				if(board[nx][ny]>='a' && board[nx][ny]<='f')
					keys |= (1<<(board[nx][ny]-'a'));
				visited[nx][ny][keys] = true;
				q.add(new Person(nx, ny, len+1, keys));
			}
		}
	}
	static class Person{
		int x, y, len, keys;
		
		Person(int x, int y, int len, int keys){
			this.x = x;
			this.y = y;
			this.len = len;
			this.keys = keys;
		}
	}
}
