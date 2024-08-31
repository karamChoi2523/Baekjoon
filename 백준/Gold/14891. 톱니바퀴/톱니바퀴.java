import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] board = new int[4][8];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<4;i++) {
			String str = br.readLine();
			for(int j=0;j<8;j++)
				board[i][j] = (int)str.charAt(j)-'0';
		}
		
		int k = Integer.valueOf(br.readLine());
		
		ArrayList<int[]> rotation = new ArrayList<>();
		for(int i=0;i<k;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			rotation.add(new int[] {a,b});
		}
		
		
		for(int[] rot : rotation) {
			int num = rot[0]-1;
			int dir = rot[1];

			int a = board[0][2];	//1
			int b = board[1][6];	//2
			
			int c = board[1][2];	//2
			int d = board[2][6];	//3
			
			int e = board[2][2];	//3
			int f = board[3][6];	//4
			
			rotateWheel(num , dir);
			
			if(num == 0) {
				if(a!=b) {
					rotateWheel(num+1, dir*(-1));
					if(c!=d) {
						rotateWheel(num+2, dir);
						if(e!=f) {
							rotateWheel(num+3, dir*(-1));
						}
					}
				}
			}else if(num==1) {
				if(a!=b) {
					rotateWheel(num-1, dir*(-1));
				}
				if(c!=d) {
					rotateWheel(num+1, dir*(-1));
					if(e!=f)
						rotateWheel(num+2, dir);
				}
			}else if(num==2) {
				if(e!=f) {
					rotateWheel(num+1, dir*(-1));
				}
				if(c!=d) {
					rotateWheel(num-1, dir*(-1));
					if(a!=b)
						rotateWheel(num-2, dir);
				}
			}else if(num == 3) {
				if(e!=f) {
					rotateWheel(num-1, dir*(-1));
					if(c!=d) {
						rotateWheel(num-2, dir);
						if(a!=b)
							rotateWheel(num-3, dir*(-1));
					}
				}
			}
		}
		
		int sum = 0;
		int[] scores = new int[] {1,2,4,8};
		for(int i=0;i<4;i++) {
			if(board[i][0]==1)
				sum += scores[i];
		}
		
		System.out.println(sum);
	}
	private static void rotateWheel(int num, int dir) {
		if(dir == 1) {
			int temp = board[num][7];
			
			for(int i=7;i>0;i--) {
				board[num][i] = board[num][i-1];
			}
			board[num][0] = temp;
		}else {
			int temp = board[num][0];
			
			for(int i=0;i<7;i++) {
				board[num][i] = board[num][i+1];
			}
			board[num][7] = temp;
		}
	}

}
