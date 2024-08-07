import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] board = new int[19][19];
	static int[] dx = new int[] {0,1,1,-1};
	static int[] dy = new int[] {1,0,1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0;j < 19;j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		for(int j=0;j<19;j++)
			for(int i=0;i<19;i++) {
				if(board[i][j]!=0) {
					boolean check = solution(i, j, board[i][j]);
					if(check)
						return;
				}
			}
		
		System.out.println(0);
	}

	private static boolean solution(int x, int y, int target) {		
		for(int i=0;i<4;i++) {
			int nx = x;
			int ny = y;
			int sum=1;
			
			while(true) {
				nx+=dx[i];
				ny+=dy[i];
				
				if(nx>=0 && nx<19 && ny>=0 && ny<19) {
					if(board[nx][ny] == target)
						sum++;
					else
						break;
				}else
					break;
			}
			nx = x;
			ny = y;
			
			while(true) {
				nx-=dx[i];
				ny-=dy[i];
				
				if(nx>=0 && nx<19 && ny>=0 && ny<19) {
					if(board[nx][ny] == target)
						sum++;
					else
						break;
				}else
					break;
			}
			

			if(sum==5) {
				System.out.println(target);
				System.out.println((x+1)+" "+(y+1));
				return true;
			}
		}
		
		return false;
	}

}
