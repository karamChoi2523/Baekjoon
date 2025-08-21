import java.io.*;
import java.util.*;

public class Main {
	//우 하 좌 상 우 하 좌 상 우 하
	static int[] dx = {0,1,0,-1,0,1,0,-1,0,1};
	static int[] dy = {1,0,-1,0,1,0,-1,0,1,0};
	
	static class Camera implements Comparable<Camera> {
		int x, y, num;

		public Camera(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
		@Override
		public int compareTo(Camera o) {
			return this.num - o.num;
		}
	}
	static int N, M;
	static int[][] board;	//0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호
	static ArrayList<Camera> cameras;
	static ArrayList<int[]> walls;
	static boolean[][] visited;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		cameras = new ArrayList<>();
		walls = new ArrayList<>();
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]!=0) {
					if(board[i][j]==6)
						walls.add(new int[] {i,j});
					else
						cameras.add(new Camera(i,j,board[i][j]));
				}
			}
		}
		min = Integer.MAX_VALUE;
		sol();

		System.out.println(min);
	}
	static void sol() {
		for(int d=0;d<4;d++) {
			visited = new boolean[N][M];
			int cnt = 0;
			Collections.sort(cameras);
			
			for(int i=0;i<cameras.size();i++) {
				Camera c = cameras.get(i);
				rotate(c.x, c.y, c.num, d);
			}
			for(int[] wall : walls)
				visited[wall[0]][wall[1]] = true;
			
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(!visited[i][j]) cnt++;
			
			min = Math.min(min, cnt);

			visited = new boolean[N][M];
			cnt = 0;
			Collections.reverse(cameras);
			for(int i=0;i<cameras.size();i++) {
				Camera c = cameras.get(i);
				rotate(c.x, c.y, c.num, d);
			}
			for(int[] wall : walls)
				visited[wall[0]][wall[1]] = true;
			
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(!visited[i][j]) cnt++;
			
			min = Math.min(min, cnt);
		}
	}
	static void rotate(int x, int y, int num, int dir) {
		int max = -1;
		int mIdx = -1;
		if(num==1) {
			for(int i=dir;i<dir+4;i++) {
				int curr = count(x,y,i);
				if(max<curr) {
					max = curr;
					mIdx = i;
				}
			}
			flag(x, y, mIdx);
		}else if(num==2) {
			for(int i=dir;i<dir+2;i++) {
				int curr = count(x,y,i) + count(x,y,i+2);
				if(max<curr) {
					max = curr;
					mIdx = i;
				}
			}
			flag(x, y, mIdx);
			flag(x, y, mIdx+2);
		}else if(num==3) {
			for(int i=dir;i<dir+4;i++) {
				int curr = count(x,y,i) + count(x,y,i+1) ;
				if(max<curr) {
					max = curr;
					mIdx = i;
				}
			}
			flag(x, y, mIdx);
			flag(x, y, mIdx+1);
		}else if(num==4) {
			for(int i=dir;i<dir+4;i++) {
				int curr = count(x,y,i) + count(x,y,i+1) + count(x,y,i+2);
				if(max<curr) {
					max = curr;
					mIdx = i;
				}
			}
			flag(x, y, mIdx);
			flag(x, y, mIdx+1);
			flag(x, y, mIdx+2);
		}else {
			flag(x, y, 0);
			flag(x, y, 1);
			flag(x, y, 2);
			flag(x, y, 3);
		}
	}
	static int count(int x, int y, int d) {
		int cnt = 0;
		while(true) {
			x += dx[d];
			y += dy[d];
			
			if(x<0 || x>=N || y<0 || y>=M) break;
			if(board[x][y]==6) break;
			
			if(board[x][y]==0 && !visited[x][y]) cnt++;
		}
		return cnt;
	}
	static void flag(int x, int y, int d) {
		visited[x][y] = true;
		while(true) {
			x += dx[d];
			y += dy[d];
			
			if(x<0 || x>=N || y<0 || y>=M) break;
			if(board[x][y]==6) break;
			
			if(board[x][y]==0 && !visited[x][y]) visited[x][y] = true;
		}
	}
}
