import java.util.*;
import java.io.*;

public class Main {
	static int R, C, N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] res;
	static char[][] res3;
	static char[][] res5;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		res = new char[R][C];
		res3 = new char[R][C];
		res5 = new char[R][C];
		for(int i=0;i<R;i++)
			res[i] = br.readLine().toCharArray();

		if(N==1) {
			print(res);
			return;
		}

		if(N%2==0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++)
					System.out.print('O');
				System.out.println();
			}
			return;
		}

		res3 = explode(res);
		res5 = explode(res3);

		if(N%4==3) {
			print(res3);
		}else {
			print(res5);
		}
	}
	static char[][] explode(char[][] board) {
		boolean[][] visited = new boolean[R][C];

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j]=='O') {
					visited[i][j] = true;
					for(int d=0;d<4;d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];

						if(checkNext(nx, ny))
							visited[nx][ny] = true;
					}
				}
			}
		}
		
		char[][] ans = new char[R][C];

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++)
				ans[i][j] = visited[i][j]?'.':'O';
		}
		
		return ans;
	}
	static void print(char[][] result) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++)
				System.out.print(result[i][j]);
			System.out.println();
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=R || y<0 || y>=C) return false;
		return true;
	}
}
