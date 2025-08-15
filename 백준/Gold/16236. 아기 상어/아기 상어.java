import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int size = 2;
	static int sizeUp;
	static ArrayList<int[]> fishes = new ArrayList<>();
	static int minLen = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x = -1, y=-1;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==9) {
					x = i;
					y = j;
					board[i][j] = 0;
				}
			}
		}
		eat(x, y, 0);
	}
	static void eat(int x, int y, int time) {
		while(true) {
			fishes = new ArrayList<>();
			minLen = Integer.MAX_VALUE;
			findFish(x, y);
			
			if(fishes.size()==0)
				break;

			//위, 왼 기준 정렬
			Collections.sort(fishes, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0])
						return o1[1]-o2[1];
					return o1[0]-o2[0];
				}
			});
			int[] target = fishes.get(0);
			sizeUp++;
			board[target[0]][target[1]] = 0;
			time += target[2];
			x = target[0];
			y = target[1];
			
			if(sizeUp >= size) {
				sizeUp-=size;
				size++;
			}
		}
		System.out.println(time);
	}
	static void findFish(int x, int y) {	//bfs
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y,0});
		boolean[][] visited = new boolean[N][N];
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			int cx = curr[0];
			int cy = curr[1];
			int dist = curr[2];
			
			if(board[cx][cy]!=0 && board[cx][cy]<size)
				if(dist < minLen) {
					fishes = new ArrayList<>();
					minLen = dist;
					fishes.add(new int[] {cx, cy, dist});
				}else if(dist == minLen) {
					fishes.add(new int[] {cx, cy, dist});
				}
			
			for(int d=0;d<4;d++) {
				int nx = cx+dx[d];
				int ny = cy+dy[d];
				
				if(checkNext(size, nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny,dist+1});
				}
			}
		}
	}
	static int calDist(int cx, int cy, int tx, int ty) {
		return Math.abs(cx-tx)+Math.abs(cy-ty);
	}
	static boolean checkNext(int size, int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) return false;
		
		if(size < board[x][y]) return false;
		
		return true;
	}
}
