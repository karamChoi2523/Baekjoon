import java.util.Scanner;
//분할정복
public class B2630 {
	static int[][] board;
	static boolean[][] visited;
	static int cntA=0;	//white
	static int cntB=0;	//blue

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		board = new int[n][n];

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				board[i][j] = sc.nextInt();
		}
		
		solution(0,0, n);
		
		System.out.println(cntA);
		System.out.println(cntB);
	}

	private static void solution(int row, int col, int m) {
		if(paperCheck(row, col, m)) {
			if(board[row][col]==1)
				cntB++;
			else
				cntA++;
			
			return;
		}
		
		int newM = m/2;
		solution(row, col, newM);
		solution(row, col+newM, newM);
		solution(row+newM, col, newM);
		solution(row+newM, col+newM, newM);
	}

	private static boolean paperCheck(int row, int col, int m) {
		int start = board[row][col];

		for(int i=row;i<row+m;i++) {
			for(int j=col;j<col+m;j++)
				if(start!=board[i][j])
					return false;
		}
		
		return true;
	}
}
