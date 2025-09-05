import java.io.*;
import java.util.*;

public class Main {
	//우 하 좌 상 우 하 좌 상 우 하
	static int[] dx = {0,1,0,-1,0,1,0,-1,0,1};
	static int[] dy = {1,0,-1,0,1,0,-1,0,1,0};
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
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]>=1 && board[i][j]<=5)
					cameras.add(new Camera(board[i][j],i,j));
				else if(board[i][j]==6)
					walls.add(new int[] {i,j});
			}
		}
		min = Integer.MAX_VALUE;
		sol(0);

		System.out.println(min);
	}
	static void sol(int idx) {
		for(int d=0;d<4;d++) {
			for(int step=0;step<2;step++) {
				visited = new boolean[N][M];
				if(step==0)	Collections.sort(cameras);
				else Collections.reverse(cameras);
				int cnt = 0;
				
				for(Camera c : cameras)
					rotate(c.x, c.y, c.id, d);
				
				for(int[] wall : walls)
					visited[wall[0]][wall[1]] = true;
				
				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++)
						if(!visited[i][j])
							cnt++;
				min = Math.min(min, cnt);
			}
		}
	}
	private static void rotate(int x, int y, int id, int dir) {
		int max = -1;
		int mIdx = -1;
		
		if(id==1) {
			for(int d=dir;d<dir+4;d++) {
				int curr = count(x,y,d);
				if(curr>max) {
					max = curr;
					mIdx = d;
				}
			}
			checkVisit(x, y, mIdx);
		}else if(id==2) {
			for(int d=dir;d<dir+2;d++) {
				int curr = count(x,y,d)+count(x,y,d+2);
				if(curr>max) {
					max = curr;
					mIdx = d;
				}
			}
			checkVisit(x,y,mIdx);
			checkVisit(x,y,mIdx+2);
		}else if(id==3) {
			for(int d=dir;d<dir+4;d++) {
				int curr = count(x,y,d)+count(x,y,d+1);
				if(curr>max) {
					max = curr;
					mIdx = d;
				}
			}
			checkVisit(x,y,mIdx);
			checkVisit(x,y,mIdx+1);
		}else if(id==4) {
			for(int d=dir;d<dir+4;d++) {
				int curr = count(x,y,d)+count(x,y,d+1)+count(x,y,d+2);
				if(curr>max) {
					max = curr;
					mIdx = d;
				}
			}
			checkVisit(x,y,mIdx);
			checkVisit(x,y,mIdx+1);
			checkVisit(x,y,mIdx+2);
		}else if(id==5) {
			checkVisit(x,y,0);
			checkVisit(x,y,1);
			checkVisit(x,y,2);
			checkVisit(x,y,3);
		}
	}
	private static void checkVisit(int x, int y, int d) {
		visited[x][y] = true;
		while(true) {
			x += dx[d];
			y += dy[d];
			if(!checkNext(x,y)||board[x][y]==6) break;
			if(board[x][y]==0 && !visited[x][y])
				visited[x][y] = true;
		}
	}
	private static int count(int x, int y, int d) {
		int cnt = 0;
		while(true) {
			x += dx[d];
			y += dy[d];
			
			if(!checkNext(x,y)||board[x][y]==6) break;
			if(board[x][y]==0 && !visited[x][y])
				cnt++;
		}
		return cnt;
	}
	
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		return true;
	}
	static class Camera implements Comparable<Camera>{
		int id, x, y;

		public Camera(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Camera o) {
			return this.id-o.id;
		}
	}
}
