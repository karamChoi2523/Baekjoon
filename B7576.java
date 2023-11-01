import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
	static int[][] box;
	static ArrayList<int[]> list = new ArrayList<>();
	static int h, n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
	
		box = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0;j<m;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if(box[i][j]==1)
					list.add(new int[] {i, j});
			}
		}
		
		int res = bfs()-1;
		LOOP: for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					if(box[i][j]==0) {
						res = -1;
						break LOOP;
					}
		
		System.out.println(res);
	}

	private static int bfs() {
		int x=0,y=0;
		int[] dc = {-1,1,0,0};
		int[] dr = {0,0,-1,1};
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<list.size();i++)
			q.offer(list.get(i));
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			x = current[0];
			y = current[1];
			
			for(int i=0;i<4;i++) {
				int dx = x+dr[i];
				int dy = y+dc[i];
				
				if(dx>=0 && dy>=0 && dx<n && dy<m)
					if(box[dx][dy]==0) {
						q.offer(new int[] {dx, dy});
						box[dx][dy]=box[x][y]+1;
					}
			}
		}
		return box[x][y];
	}

}
