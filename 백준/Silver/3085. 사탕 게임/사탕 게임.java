import java.io.*;
import java.util.*;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());
		
		char[][] board= new char[n][n];
		
		for(int i=0;i<n;i++) {
			String temp = br.readLine();
			
			for(int j=0;j<n;j++)
				board[i][j] = temp.charAt(j);
		}
		
		int max = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j<n-1) {
					swap(board, i, j, i, j+1);
					max = Math.max(max, findMax(board));
					swap(board, i, j, i, j+1);
				}
				
				if(i<n-1) {
					swap(board, i, j, i+1, j);
					max = Math.max(max, findMax(board));
					swap(board, i, j, i+1, j);
				}
			}
		}
		
		System.out.println(max);
	}

	private static int findMax(char[][] board) {
		int max = 0;
		
		for(int i=0;i<n;i++) {
			int row = 1;
			int col = 1;
			
			for(int j=1;j<n;j++) {
				if(board[i][j]==board[i][j-1]) row++;
				else {
					max = Math.max(max, row);
					row = 1;
				}
				
				if(board[j][i]==board[j-1][i]) col++;
				else {
					max = Math.max(max, col);
					col = 1;
				}
			}
			max = Math.max(max, row);
			max = Math.max(max, col);
		}
		return max;
	}

	private static void swap(char[][] board, int i, int j, int i2, int j2) {
		char temp = board[i][j];
		board[i][j] = board[i2][j2];
		board[i2][j2] = temp;
	}
}
