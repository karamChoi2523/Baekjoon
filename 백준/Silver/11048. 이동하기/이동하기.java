import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map;
	static int[][] record;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n =Integer.valueOf(st.nextToken());
		m =Integer.valueOf(st.nextToken());
		
		map = new int[n][m];
		record = new int[n][m];

		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				map[i][j] =Integer.valueOf(st.nextToken());
		}
	
		solution();
		
		System.out.println(record[n-1][m-1]);
	}

	private static void solution() {
		record[0][0] = map[0][0];
		
		for(int i=1;i<m;i++)
			record[0][i] = record[0][i-1] + map[0][i];
		
		for(int i=1;i<n;i++)
			record[i][0] = record[i-1][0]+map[i][0];
		
		for(int i=1;i<n;i++)
			for(int j=1;j<m;j++)
				record[i][j] = Math.max(record[i-1][j], record[i][j-1])+map[i][j];
		
	}

}
