import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int r,c,n;
	static class Bomb{
		char state;
		int time;
		
		public Bomb(char s, int t) {
			state = s;
			time = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		
		Bomb[][] board = new Bomb[r][c];
		
		for(int i=0;i<r;i++) {
			String str = br.readLine();
			for(int j=0;j<c;j++)
				board[i][j] = new Bomb(str.charAt(j), 0);
		}
		
		int time = 0;
		
		while(time < n) {
			if(time % 2 == 1) {
				for(int i=0;i<r;i++)
					for(int j=0;j<c;j++)
						if(board[i][j].state != 'O')
							board[i][j] = new Bomb('O', 0);
						else {
							board[i][j].time++;
						}
			}else {
				for(int i=0;i<r;i++)
					for(int j=0;j<c;j++)
						board[i][j].time++;
			}
			
			explosion(board);
			time++;
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++)
				System.out.print(board[i][j].state);
			System.out.println();
		}
	}

	private static void explosion(Bomb[][] board) {
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				if(board[i][j].state=='O' && board[i][j].time == 3)
					list.add(new int[] {i,j});
		
		for(int[] curr : list) {
			int x = curr[0];
			int y = curr[1];
			
			board[x][y] = new Bomb('.', 0);
			if(x-1>=0)
				board[x-1][y] = new Bomb('.', 0);
			if(x+1<r)
				board[x+1][y] = new Bomb('.', 0);
			if(y-1>=0)
				board[x][y-1] = new Bomb('.', 0);
			if(y+1<c)
				board[x][y+1] = new Bomb('.', 0);
		}
	}

}
