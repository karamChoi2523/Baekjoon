import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] board;
	static int[][] d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		board = new int[n+1][n+1];
		d = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1;j<n+1;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<n+1;i++)
			for(int j=1;j<n+1;j++)
				d[i][j] = board[i][j]+d[i-1][j]+d[i][j-1]-d[i-1][j-1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			//x1, y1, x2, y2
			int sx = Integer.valueOf(st.nextToken());
			int sy = Integer.valueOf(st.nextToken());
			int ex = Integer.valueOf(st.nextToken());
			int ey = Integer.valueOf(st.nextToken());
			
			int answer = d[ex][ey] - d[ex][sy-1] -d[sx-1][ey] + d[sx-1][sy-1];
			sb.append(answer+"\n");
		}
		
		System.out.println(sb.toString());	
	}
}
