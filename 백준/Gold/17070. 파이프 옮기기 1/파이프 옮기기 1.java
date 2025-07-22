import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];

		for(int i=1;i<N+1;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=1;j<N+1;j++)
				board[i][j] = Integer.parseInt(temp[j-1]);
		}
		
		int[][][] dp = new int[N+1][N+1][3];
		dp[1][2][0] = 1;

		for(int i=1;i<N+1;i++) {
			for(int j=3;j<N+1;j++) {
				if(i==1 && j==1) continue;
				if(i==1 && j==2) continue;
				
				if(board[i][j]!=0) continue;
				
				if(j>1 && board[i][j-1]==0)
					dp[i][j][0] += (dp[i][j-1][0]+dp[i][j-1][2]);	//가로
				if(i>1 && board[i-1][j]==0)
					dp[i][j][1] += (dp[i-1][j][1]+dp[i-1][j][2]);	//세로
				if(i>1 && j>1 && board[i-1][j-1]==0 && board[i-1][j]==0 && board[i][j-1]==0)
					dp[i][j][2] += Arrays.stream(dp[i-1][j-1]).sum();	//대각선
			}
		}

		System.out.println(Arrays.stream(dp[N][N]).sum());
	}
}
