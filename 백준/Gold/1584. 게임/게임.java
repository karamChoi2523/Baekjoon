import java.io.*;
import java.util.*;


public class Main {	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n,m;
    private static final int INF = 250001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] adj = new int[501][501];
		
		n = Integer.valueOf(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//위험구역
			int x1 = Integer.valueOf(st.nextToken());
			int y1 = Integer.valueOf(st.nextToken());
			int x2 = Integer.valueOf(st.nextToken());
			int y2 = Integer.valueOf(st.nextToken());
			
			int xs = x1<x2?x1:x2;
	        int xe = x1<x2?x2:x1;
	        int ys = y1<y2?y1:y2;
	        int ye = y1<y2?y2:y1;
	        
			for(int j=xs;j<=xe;j++)
				for(int k=ys;k<=ye;k++)
					adj[j][k] = 1;
		}
		
		m = Integer.valueOf(br.readLine());
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//위험구역
			int x1 = Integer.valueOf(st.nextToken());
			int y1 = Integer.valueOf(st.nextToken());
			int x2 = Integer.valueOf(st.nextToken());
			int y2 = Integer.valueOf(st.nextToken());
			
			int xs = x1<x2?x1:x2;
	        int xe = x1<x2?x2:x1;
	        int ys = y1<y2?y1:y2;
	        int ye = y1<y2?y2:y1;
	        
			for(int j=xs;j<=xe;j++)
				for(int k=ys;k<=ye;k++)
					adj[j][k] = 2;
		}
		
		int[][] dist = dijkstra(adj);
		
		System.out.println(dist[500][500]==INF?-1:dist[500][500]);
	}
	private static int[][] dijkstra(int[][] adj) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.addLast(new int[] {0,0,0});
		
		int[][] dist = new int[501][501];
		
		for(int[] row : dist)
			Arrays.fill(row, INF);
		dist[0][0] = 0;
		
		while(!dq.isEmpty()) {
			int[] curr = dq.pollFirst();
			
			int x = curr[0];
			int y = curr[1];
			int cost = curr[2];
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && nx<501 && ny>=0 && ny<501) {
                    if(adj[nx][ny]==2)
						continue;
					if(dist[nx][ny]<= cost+adj[nx][ny])
						continue;
					
					dist[nx][ny] = cost+adj[nx][ny];
					
					if(adj[nx][ny]==0)
						dq.addFirst(new int[] {nx, ny, cost});
					else
						dq.addLast(new int[] {nx,ny,cost+1});
				}
			}
		}
		
		return dist;
	}
}
