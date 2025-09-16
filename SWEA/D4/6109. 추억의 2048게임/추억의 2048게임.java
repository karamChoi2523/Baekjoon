import java.io.*;
import java.util.*;

public class Solution {
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			
			board = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0;j<N;j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			move(N, S);
			
			System.out.println("#"+tc);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					System.out.print(board[i][j]+" ");
				System.out.println();
			}
		}
	}
	private static void move(int N, String dir) {
		if(dir.equals("left")) {
			for(int i=0;i<N;i++) {
				Queue<Integer> q = new ArrayDeque<>();
				for(int j=0;j<N;j++)
					if(board[i][j]!=0) {
						q.add(board[i][j]);
						board[i][j] = 0;
					}
				
				int j=0;
				while(!q.isEmpty()) {
					int curr = q.poll();
					if(!q.isEmpty() && q.peek()==curr) {
						q.poll();
						curr *= 2;
					}
					
					board[i][j++] = curr;
				}
			}
		}else if(dir.equals("right")) {
			for(int i=0;i<N;i++) {
				Queue<Integer> q = new ArrayDeque<>();
				for(int j=N-1;j>=0;j--)
					if(board[i][j]!=0) {
						q.add(board[i][j]);
						board[i][j] = 0;
					}
				
				int j=N-1;
				while(!q.isEmpty()) {
					int curr = q.poll();
					if(!q.isEmpty() && q.peek()==curr) {
						q.poll();
						curr *= 2;
					}
					
					board[i][j--] = curr;
				}
			}
		}else if(dir.equals("up")) {
			for(int j=0;j<N;j++) {
				Queue<Integer> q = new ArrayDeque<>();
				for(int i=0;i<N;i++)
					if(board[i][j]!=0) {
						q.add(board[i][j]);
						board[i][j] = 0;
					}
				
				int i=0;
				while(!q.isEmpty()) {
					int curr = q.poll();
					if(!q.isEmpty() && q.peek()==curr) {
						q.poll();
						curr *= 2;
					}
					
					board[i++][j] = curr;
				}
			}
		}else {
			for(int j=0;j<N;j++) {
				Queue<Integer> q = new ArrayDeque<>();
				for(int i=N-1;i>=0;i--)
					if(board[i][j]!=0) {
						q.add(board[i][j]);
						board[i][j] = 0;
					}
				
				int i=N-1;
				while(!q.isEmpty()) {
					int curr = q.poll();
					if(!q.isEmpty() && q.peek()==curr) {
						q.poll();
						curr *= 2;
					}
					
					board[i--][j] = curr;
				}
			}
		}
	}
}
