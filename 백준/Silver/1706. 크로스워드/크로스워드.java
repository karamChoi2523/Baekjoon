import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int R = Integer.parseInt(str[0]);
		int C = Integer.parseInt(str[1]);

		char[][] board = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			
			for(int j=0;j<C;j++)
				board[i][j] = s.charAt(j);
		}
		
		ArrayList<String> list = new ArrayList<>();
		//가로
		for(int i=0;i<R;i++) {
			String s = "";
			for(int j=0;j<C;j++) {
				if(board[i][j]=='#') {
					if(s.length()>1)
						list.add(s);
					s = "";
				}else {
					s += String.valueOf(board[i][j]);
				
					if(j==C-1) {
						if(s.length()>1)
							list.add(s);
						s = "";
					}
				}
			}
		}
		
		//세로
		for(int i=0;i<C;i++) {
			String s = "";
			for(int j=0;j<R;j++) {
				if(board[j][i]=='#') {
					if(s.length()>1)
						list.add(s);
					s = "";
				}else {
					s += String.valueOf(board[j][i]);
				
					if(j==R-1) {
						if(s.length()>1)
							list.add(s);
						s = "";
					}
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(list.get(0));
	}
}
