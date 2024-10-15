import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[][] adj = new int[n+1][n+1];	//점수
		boolean[][] visited = new boolean[n+1][n+1];
		
		for(int i=0;i<n+1;i++) {
			Arrays.fill(adj[i], 100);
			adj[i][i] = 1;
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			if(a==-1 && b==-1) break;
			
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		
		for(int k=1;k<n+1;k++)
			for(int i=1;i<n+1;i++)
				for(int j=1;j<n+1;j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
				}

		int[] result = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			int max = -1;

			for(int j=1;j<n+1;j++)
				max = Math.max(max, adj[i][j]);
			for(int j=1;j<n+1;j++)
				max = Math.max(max, adj[j][i]);
			
			result[i] = max;
		}
		
		int score=Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1;i<n+1;i++) {
			if(result[i]<score) {
				list = new ArrayList<>();
				score = result[i];
				list.add(i);
			}else if(result[i]==score) {
				list.add(i);
			}
		}
		
		System.out.println(score+" "+list.size());
		
		//Collections.sort(list);
		for(int e : list)
			System.out.print(e+" ");
	}
}
