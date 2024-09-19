import java.util.Scanner;

//인접 - 상하좌우
//지렁이가 몇마리 필요한지
//1이 배추

//dfs로 1덩어리 갯수 구하기
public class Main {
	static int dr[]= {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int[][] board;
	
	static void dfs(int i, int j) {
		for(int r=0;r<4;r++) {
			int dx = i+dr[r];
			int dy = j+dc[r];
			
			if(dx>=0 && dx<board.length && dy>=0 && dy<board[0].length)
				if(board[dx][dy]==1) {
					board[dx][dy]=0;
					dfs(dx, dy);
				}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test=0;test<t;test++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			board = new int[m+1][n+1];

			int a,b;
			
			for(int i=0;i<k;i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				
				board[a][b] = 1;
			}
			int res=0;
			
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++) {
					if(board[i][j]==1) {
						res++;
						board[i][j]=0;
						dfs(i,j);
					}
				}
			System.out.println(res);
		}
	}

}
