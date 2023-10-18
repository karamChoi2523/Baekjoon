import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940 {
	
	static int[] dr = new int[]{-1,1,0,0};
	static int[] dc = new int[] {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	
		int[][] list = new int[n][m];
		int[][] res = new int[n][m];
		boolean[][] visited = new boolean[list.length][list[0].length];
		
		int x=0, y=0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0;j<m;j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if(list[i][j]==2) {
					x = i;
					y= j;
				}
			}
		}
		
		bfs(x, y, visited, list, res);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j] && list[i][j]==1)
					sb.append(-1+" ");
				else
					sb.append(res[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y, boolean[][] visited, int[][] list, int[][] res) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			
			for(int i=0;i<4;i++) {
				int dx = current[0]+dr[i];
				int dy = current[1]+dc[i];
				
				if(dx>=0 && dy>=0 && dx<list.length && dy<list[0].length)
					if(list[dx][dy]==1 && !visited[dx][dy]){
						res[dx][dy] = res[current[0]][current[1]]+1;
						visited[dx][dy]=true;
						q.add(new int[] {dx, dy});
					}
			}
		}
	}

}
