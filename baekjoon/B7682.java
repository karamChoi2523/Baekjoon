import java.util.Scanner;

public class B7682 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s= sc.nextLine();
		while(!s.equals("end")) {
			System.out.println(solution(s));
			
			s= sc.nextLine();
		}
	}

	private static String solution(String s) {
		char[][] board = new char[3][3];
		
		int xCnt=0;
		int oCnt=0;
		
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				board[i][j]=s.charAt(i*3+j);
				
				if(board[i][j]=='O')
					oCnt++;
				else if(board[i][j]=='X')
					xCnt++;
			}
		
		if(oCnt+xCnt==9 && xCnt-oCnt==1) {
			if(check('X', board) && check('O', board))
				return "invalid";
			else if(check('O', board))
				return "invalid";
			else
				return "valid";
		}else {
			if(check('X', board) && check('O', board))
				return "invalid";
			else if(check('X', board)&&xCnt-oCnt==1)
				return "valid";
			else if(check('O', board)&&xCnt==oCnt)
				return "valid";
			else
				return "invalid";
		}
	}

	private static boolean check(char c, char[][] board) {
		for(int i=0;i<3;i++) {
			int cnt=0;
			for(int j=0;j<3;j++)
				if(board[i][j]==c)
					cnt++;
			if(cnt==3)
				return true;
		}
		
		for(int i=0;i<3;i++) {
			int cnt=0;
			for(int j=0;j<3;j++)
				if(board[j][i]==c)
					cnt++;
			if(cnt==3)
				return true;
		}
		
		if(board[0][0]==c && board[1][1]==c &&board[2][2]==c)
			return true;
		if(board[0][2]==c &&board[1][1]==c&&board[2][0]==c)
			return true;
		return false;
	}

}
