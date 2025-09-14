import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {1,0,1};
	static int[] dy = {0,1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][M];
		dp[0][0] = board[0][0];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				for(int d=0;d<3;d++) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					
					if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					dp[nx][ny] = Math.max(dp[nx][ny], dp[i][j]+board[nx][ny]);
				}
		}
		
		
		System.out.println(dp[N-1][M-1]);
	}
}
