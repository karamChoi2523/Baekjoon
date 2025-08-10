import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N+1][N+1];
		
		for(int i=1;i<N+1;i++)
			Arrays.fill(board[i], (int)1e9);
		for(int i=1;i<N+1;i++)
			board[i][i] = 0;

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(b==0) {
				board[u][v] = 0;
				board[v][u] = 1;
			}else {
				board[u][v] = 0;
				board[v][u] = 0;
			}
		}
		
		for(int k=1;k<N+1;k++)
			for(int i=1;i<N+1;i++)
				for(int j=1;j<N+1;j++)
					if(board[i][j] > board[i][k]+board[k][j])
						board[i][j] = board[i][k]+board[k][j];

					
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			System.out.println(board[s][e]);
		}
	}
}