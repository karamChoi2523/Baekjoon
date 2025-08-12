import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] board;
	static int max = -1;
	static ArrayList<int[]>[] wormhole;

	static final int RIGHT = 0;
	static final int LEFT = 1;
	static final int UP = 2;
	static final int DOWN = 3;

	static int[][] bounce = {
			{},
			{LEFT, UP, DOWN, RIGHT},
			{LEFT, DOWN, RIGHT, UP},
			{DOWN, RIGHT, LEFT, UP},
			{UP, RIGHT, DOWN, LEFT},
			{LEFT, RIGHT, DOWN, UP}
	};
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine().trim());
			board = new int[N][N];
			wormhole = new ArrayList[6];
			for(int i=0;i<6;i++)
				wormhole[i] = new ArrayList<>();

			StringTokenizer st;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int t = Integer.parseInt(st.nextToken());
					board[i][j] = t;
					if(t>=6) {	
						wormhole[t-6].add(new int[] {i,j});
					}
				}
			}

			max = 0;
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) {
					if(board[i][j]!=0) continue;
					for(int dir=0; dir<4; dir++) {
						int score = simulate(i, j, dir);
						max = Math.max(max, score);
					}
				}

			System.out.printf("#%d %d\n",tc,max);
		}
	}
	static int simulate(int sx, int sy, int dir) {
		int score = 0;
		int x = sx;
		int y = sy;
		
		while(true) {
            x += dx[dir];
            y += dy[dir];
            
            if(x<0 || x>=N || y<0 || y>=N) {
            	x -= dx[dir];
            	y -= dy[dir];
            	dir = opposite(dir);
            	score++;
            }
			
			if(board[x][y]==-1 || ((x==sx && y==sy)))
				break;
			else if(board[x][y]>0 && board[x][y]<6) {
				int block = board[x][y];
				score++;
				dir = bounce[block][dir];
			}else if(board[x][y]>=6) {
				int block = board[x][y];
				int[] pos1 = wormhole[block-6].get(0);
				int[] pos2 = wormhole[block-6].get(1);

				if(x==pos1[0] && y==pos1[1]) {
					x = pos2[0];
					y = pos2[1];
				}else {
					x = pos1[0];
					y = pos1[1];
				}
			}
		}
		
		return score;
	}
	static int opposite(int dir) {
		return dir == UP ? DOWN : dir == DOWN ? UP : dir == LEFT ? RIGHT : LEFT;
	}
}