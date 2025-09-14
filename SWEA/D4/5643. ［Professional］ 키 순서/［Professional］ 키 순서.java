import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			int[][] adj = new int[N+1][N+1];
			for(int i=1;i<N+1;i++)
				Arrays.fill(adj[i], (int)1e9);

			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1;
			}

			for(int k=1;k<N+1;k++)
				for(int i=1;i<N+1;i++)
					for(int j=1;j<N+1;j++)
						adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);

			int answer = 0;
			for(int i=1;i<N+1;i++) {
				int cnt = 0;
				for(int j=1;j<N+1;j++) {
					if(i==j) continue;
					if(adj[i][j]!=(int)1e9||adj[j][i]!=(int)1e9)
						cnt++;
				}
				if(cnt==N-1)
					answer++;
			}
			System.out.printf("#%d %d\n",tc, answer);
		}
	}
}
