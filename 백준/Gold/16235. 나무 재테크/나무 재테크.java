import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static class Point{
		int x, y;
		int power;
		//ArrayList<Tree> trees;
		PriorityQueue<Integer> trees;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
			power = 5;
			trees = new PriorityQueue<>();
		}
	}
	static int N,M,K;
	static Point[][] board;
	static int[][] A;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new Point[N][N];
		A = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] = new Point(i,j);
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			board[x][y].trees.add(z);
		}
		
		cnt = M;
		for(int time=0;time<K;time++) {
			//봄 : 나이만큼 양분을 먹고 age+1(어린 나무부터)
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) {
					PriorityQueue<Integer> ts = board[i][j].trees;
					ArrayList<Integer> alive = new ArrayList<>();
					//ArrayList<Integer> dead = new ArrayList<>();
					int dead = 0;
					while(!ts.isEmpty()) {
						int curr = ts.poll();
						if(board[i][j].power>=curr) {
							board[i][j].power-=curr;
							curr++;
							alive.add(curr);
						}else {
							cnt--;
							dead += curr/2;
							//dead.add(curr);
						}
					}
					
					for(int t : alive) ts.add(t);
					//여름 : 봄에 죽은 나무 -> 양분 (age/2)
					board[i][j].power += dead;
				}

			//가을 : 번식. 나이가 5배수인 나무만. 인접한 8개 칸에 나이가 1인 나무들 추가
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) {
					//겨울 : 양분 추가. 각 칸에 +A[r][c]
					board[i][j].power += A[i][j];
					PriorityQueue<Integer> ts = board[i][j].trees;
					ArrayList<Integer> tList = new ArrayList<>();
					while(!ts.isEmpty()) {
						int curr = ts.poll();
						if(curr%5==0)
							add(i,j);
						tList.add(curr);
					}
					for(int t : tList) ts.add(t);
				}
		}
		
		System.out.println(cnt);
	}
	static void add(int x, int y) {
		for(int d=0;d<8;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			board[nx][ny].trees.offer(1);
			cnt++;
		}
	}
}
