import java.io.*;
import java.util.*;

public class Main {
	static final int UP = 0;
	static final int LEFT = 1;
	static final int DOWN = 2;
	static final int RIGHT = 3;
	static class Camera{
		int x, y, num;
		ArrayList<int[]>[] dir;
		int dIdx;

		public Camera(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
			setDir(num);
			dIdx = -1;
		}

		public void setDir(int num) {
			if(num==1) {
				dir = new ArrayList[4];
				for(int i=0;i<4;i++) {
					dir[i] = new ArrayList<>();
					dir[i].add(new int[] {i});
				}
			}else if(num==2) {
				dir = new ArrayList[2];
				for(int i=0;i<2;i++)
					dir[i] = new ArrayList<>();
				dir[0].add(new int[] {LEFT, RIGHT});
				dir[1].add(new int[] {UP, DOWN});
			}else if(num==3) {
				dir = new ArrayList[4];
				for(int i=0;i<4;i++)
					dir[i] = new ArrayList<>();
				dir[0].add(new int[] {UP, LEFT});
				dir[1].add(new int[] {LEFT, DOWN});
				dir[2].add(new int[] {DOWN, RIGHT});
				dir[3].add(new int[] {RIGHT, UP});
			}else if(num==4) {
				dir = new ArrayList[4];
				for(int i=0;i<4;i++)
					dir[i] = new ArrayList<>();
				dir[0].add(new int[] {UP, LEFT, RIGHT});
				dir[1].add(new int[] {LEFT, DOWN, UP});
				dir[2].add(new int[] {DOWN, RIGHT, LEFT});
				dir[3].add(new int[] {RIGHT, UP, DOWN});
			}else {
				dir = new ArrayList[1];
				dir[0] = new ArrayList<>();
				dir[0].add(new int[] {UP, LEFT, RIGHT, DOWN});
			}
		}
		public void rotate() {
			this.dIdx++;
			if(this.dIdx == this.dir.length)
				dIdx = 0;
		}
//		public void rotateRe() {
//			this.dIdx--;
//			if(this.dIdx < 0)
//				dIdx = this.dir.length-1;
//		}
	}
	static int N, M;
	static int[][] board;	//0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호
	static boolean[][] visited;
	static ArrayList<Camera> cameras;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		cameras = new ArrayList<>();
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]>=1 && board[i][j]<=5) {
					cameras.add(new Camera(i,j,board[i][j]));
					visited[i][j] = true;
				}
			}
		}
		min = Integer.MAX_VALUE;
		sol(0);

		System.out.println(min);
	}
	static void sol(int idx) {
		//카메라 따로 돌림.....
		//돌리거나 안 돌리거나

		//(4^camera 개수(8)) 경우의 수
		if(idx == cameras.size()) {
			countNone();
			return;
		}

		for(int i=0;i<4;i++) {
			Camera c = cameras.get(idx);
			c.rotate();
			ArrayList<int[]> change = checkVisit(c);
			sol(idx+1);
			//c.rotateRe();
			for(int[] pos : change) {
				visited[pos[0]][pos[1]] = false;
			}
		}
	}
	static void countNone() {
		int cnt = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(!visited[i][j] && board[i][j]!=6) {
					cnt++;
					if(min<=cnt) return;
				}
		min = Math.min(min, cnt);
	}
	static ArrayList<int[]> checkVisit(Camera c) {
		ArrayList<int[]> change = new ArrayList<>();
		for(int[] dirs : c.dir[c.dIdx]) {
			for(int dir : dirs) {
				int x = c.x;
				int y = c.y;
				if(dir==UP)
					while(board[x][y]!=6) {
						if(!visited[x][y]) change.add(new int[] {x,y});
						visited[x--][y] = true;
						if(x<0) break;
					}
				else if(dir==DOWN)
					while(board[x][y]!=6) {
						if(!visited[x][y]) change.add(new int[] {x,y});
						visited[x++][y] = true;
						if(x>=N) break;
					}
				else if(dir==LEFT)
					while(board[x][y]!=6) {
						if(!visited[x][y]) change.add(new int[] {x,y});
						visited[x][y--] = true;
						if(y<0) break;
					}
				else 
					while(board[x][y]!=6) {
						if(!visited[x][y]) change.add(new int[] {x,y});
						visited[x][y++] = true;
						if(y>=M) break;
					}

			}
		}

		return change;
	}
}
