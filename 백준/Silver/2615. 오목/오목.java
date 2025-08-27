import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {0,1,1,-1};
	static int[] dy = {1,1,0,1};
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board = new int[19][19];
		
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		boolean gameOver = false;
		LOOP:for(int i=0;i<19;i++)
			for(int j=0;j<19;j++)
				if(board[i][j]!=0)
					if(check(i,j)) {
						System.out.println(board[i][j]);
						System.out.println((i+1)+" "+(j+1));
						gameOver = true;
						break LOOP;
					}
		
		
		if(!gameOver) {
			System.out.println("0");
		}
	}
	static boolean check(int x, int y) {
		
		for(int d=0;d<4;d++) {
			int cnt = 0;
			int cx = x;
			int cy = y;
			
			//반대 방향 체크
			int px = x-dx[d];
			int py = y-dy[d];
			
			if(checkNext(px, py) && board[px][py]==board[x][y]) continue;
			
			//반대 방향에 같은 색 돌이 없으면
			while(true) {
				if(!checkNext(cx, cy) || board[cx][cy]!=board[x][y])
					break;
				
				cnt++;
				if(cnt>=6) break;
				cx+=dx[d];
				cy+=dy[d];
			}
			if(cnt==5) return true;
		}
		
		return false;
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=19 || y<0 || y>=19) return false;
		return true;
	}
}
