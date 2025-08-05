import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=1;j<N+1;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] dp = new int[N+1][N+1][3]; //가 세 대
		dp[1][2][0] = 1;
		
		for(int i=1;i<N+1;i++)
			for(int j=2;j<N+1;j++) {
				if(i==1&&j==2) continue;
				if(board[i][j]==1) continue;
				
				if(board[i][j-1]!=1)
					dp[i][j][0] = dp[i][j-1][2]+dp[i][j-1][0];
				if(board[i-1][j]!=1)
					dp[i][j][1] = dp[i-1][j][2]+dp[i-1][j][1];
				if(board[i-1][j-1]!=1 && board[i][j-1]!=1 && board[i-1][j]!=1)
					dp[i][j][2] = dp[i-1][j-1][2]+dp[i-1][j-1][0]+dp[i-1][j-1][1];
			}
		int answer = 0;
		for(int k=0;k<3;k++)
			answer+=dp[N][N][k];
		
		System.out.println(answer);
	}
}