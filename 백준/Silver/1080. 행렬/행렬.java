import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static int n,m;
	static int[][] boardA, boardB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		boardA = new int[n][m];
		boardB = new int[n][m];
	
		for(int i=0;i<n*2;i++) {
			String str = br.readLine();
			
			if(i<n)
				for(int j=0;j<m;j++)
					boardA[i][j] = (int)(str.charAt(j)-'0');
			else
				for(int j=0;j<m;j++)
					boardB[i%n][j] = (int)(str.charAt(j)-'0');
		}
        
        
		if(n<3 || m<3) {
			if(compareBoard())
				System.out.println(0);
			else
				System.out.println(-1);
			return;
		}

		int answer = 0;
		for(int i=0;i<n-2;i++)
			for(int j=0;j<m-2;j++) {
				if(boardA[i][j] != boardB[i][j]) {
					changeBoard(i, j);
					answer++;
				}
			}
		
		if(compareBoard())
			System.out.println(answer);
		else
			System.out.println(-1);
	}

	private static void changeBoard(int x, int y) {
		for(int i=x;i<x+3;i++)
			for(int j=y;j<y+3;j++)
				boardA[i][j] = boardA[i][j]==0? 1: 0;
	}
	
	private static boolean compareBoard() {
		for(int i=0;i<n;i++)
			if(Arrays.equals(boardA[i], boardB[i])==false)
				return false;
		
		return true;
	}

}
