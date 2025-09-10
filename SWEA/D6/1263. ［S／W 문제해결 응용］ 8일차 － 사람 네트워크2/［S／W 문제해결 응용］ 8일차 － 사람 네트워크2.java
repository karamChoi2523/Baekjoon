import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		//int T = 10;
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[][] graph = new int[n][n];
			for(int i=0;i<n;i++) {
				Arrays.fill(graph[i], (int)1e9);
				graph[i][i] = 0;
			}
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp==1)
						graph[i][j] = 1;
				}
			
			for(int k=0;k<n;k++)
				for(int i=0;i<n;i++)
					for(int j=0;j<n;j++)
						if(graph[i][j]>graph[i][k]+graph[k][j])
							graph[i][j] = graph[i][k]+graph[k][j];
			
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				int sum = 0;
				for(int j=0;j<n;j++)
					sum += graph[i][j];
				min = Math.min(min, sum);
			}
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}
}
