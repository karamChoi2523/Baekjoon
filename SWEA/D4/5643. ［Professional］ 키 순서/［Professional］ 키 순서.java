import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			int[][] graph = new int[N+1][N+1];
			for(int i=1;i<N+1;i++) {
				Arrays.fill(graph[i],(int)1e9);
				graph[i][i] = 0;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a][b] = 1;
			}
			
			for(int k=1;k<N+1;k++)
				for(int i=1;i<N+1;i++) {
					if(k==i) continue;
					for(int j=1;j<N+1;j++) {
						if(i==j || j==k) continue;
						if(graph[i][j] > graph[i][k] + graph[k][j])
							graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			
			int answer = 0;
			int[] count = new int[N+1];
			for(int i=1;i<N+1;i++)
				for(int j=1;j<N+1;j++) {
					if (i == j) continue; 
					if(graph[i][j]!=(int)1e9)
						count[i]++;
					
					if(graph[j][i]!=(int)1e9)
						count[i]++;
				}
			
			for(int i=1;i<N+1;i++)
				if(count[i]==N-1)
					answer++;
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
