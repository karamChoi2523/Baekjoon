import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static class Pos{
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			Pos p = (Pos)o;
			return (this.x==p.x && this.y==p.y);
		}
		
		@Override
		public int hashCode() {
			return 31*x+y;
		}
	}
	static int N, M, D;
	static int[][] board;
	static Set<Pos> attackPosSet;
	static int row;
	static int[] select;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//궁수 배치
		select = new int[3];
		combination(0,0);
		
		System.out.println(max);
	}
	static int[][] deepCopy(){
		int[][] copy = new int[N][M];
		for(int i=0;i<N;i++)
			System.arraycopy(board[i], 0, copy[i], 0, M);
		return copy;
	}
	static void attack(int col, int[][] copy) {
		int x=-1, y=-1;	//적 위치
		int minD = D;
		
		int preCol = M;
		for(int i=row-1;i>=0;i--)
			for(int j=0;j<M;j++) {
				if(copy[i][j]==1) {
					int d = calDist(row, col, i, j);
					if(d<minD) {
						minD = d;
						preCol = j;
						x = i;
						y = j;
					}else if(d==minD && j<preCol) {
						preCol = j;
						x = i;
						y = j;
					}
				}
			}
		
		if(x==-1 && y==-1) return;
		attackPosSet.add(new Pos(x, y));
	}
	static void combination(int idx, int k) {
		if(k==3) {
			row = N; //시작 궁수 행
			int total = 0;
			int[][] copy = deepCopy();
			while(true) {
				if(row<=0 || gameOver(copy)) break;
				attackPosSet = new HashSet<>();	//각 턴의 공격하는 적 위치
				for(int i=0;i<k;i++)
					attack(select[i],copy); //궁수가 [row][select[i]]에서 공격
				
				total+=attackPosSet.size();
				for(Pos pos : attackPosSet) {
					copy[pos.x][pos.y] = 0;
				}
				
				row--;
			}
			max = Math.max(max, total);
			return;
		}
		
		if(idx==M) return;
		
		select[k] = idx;
		combination(idx+1, k+1);
		combination(idx+1, k);
	}
	static int calDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
	static boolean gameOver(int[][] copy) {
		for(int i=row-1;i>=0;i--)
			for(int j=0;j<M;j++)
				if(copy[i][j]==1) return false;
		
		return true;
	}
}