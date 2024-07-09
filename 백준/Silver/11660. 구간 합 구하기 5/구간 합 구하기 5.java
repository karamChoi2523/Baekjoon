import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		d = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1;j<n+1;j++)
				d[i][j] = d[i][j-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			//x1, y1, x2, y2
			int x1 = Integer.valueOf(st.nextToken());
			int y1 = Integer.valueOf(st.nextToken());
			int x2 = Integer.valueOf(st.nextToken());
			int y2 = Integer.valueOf(st.nextToken());
			
			dp(x1, y1, x2, y2);
		}
		
		System.out.println(sb.toString());	
	}

	private static void dp(int sx, int sy, int ex, int ey) {
		int answer = 0;
		
		for (int i=sx; i<ex+1; i++) {
            answer += (d[i][ey] - d[i][sy-1]);
        }
		
		sb.append(answer+"\n");
	}

}
