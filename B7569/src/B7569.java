import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato{
	int x;
	int y;
	int z;
	
	public Tomato(int z, int x, int y) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
}

public class B7569 {
	static int[][][] box;
	static ArrayList<Tomato> list = new ArrayList<>();
	static int h, n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
	
		box = new int[h][n][m];
		
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(bf.readLine());
				
				for(int k=0;k<m;k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k]==1)
						list.add(new Tomato(i,j,k));				}
			}
		}
		
		int res = bfs()-1;
		LOOP: for(int i=0;i<h;i++)
			for(int j=0;j<n;j++)
				for(int k=0;k<m;k++)
					if(box[i][j][k]==0) {
						res = -1;
						break LOOP;
					}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				System.out.print(box[0][i][j]+" ");
			System.out.println();
		}
		
		System.out.println(res);
	}

	private static int bfs() {
		int x=0,y=0,z=0;
		
		int[] dh = {-1,1,0,0,0,0};
		int[] dc = {0,0,-1,1,0,0};
		int[] dr = {0,0,0,0,-1,1};
		
		Queue<Tomato> q = new LinkedList<>();
		
		for(int i=0;i<list.size();i++)
			q.offer(list.get(i));
		
		while(!q.isEmpty()) {
			Tomato tomato = q.poll();
			x = tomato.getX();	// 2 2 / 1 1
			y = tomato.getY();
			z = tomato.getZ();
			
			for(int i=0;i<6;i++) {
				int dx = x+dr[i];	//2 1 0
				int dy = y+dc[i];
				int dz = z+dh[i];
				
				if(dx>=0 && dy>=0 && dz>=0 && dx<n && dy<m && dz<h)
					if(box[dz][dx][dy]==0) {
						q.offer(new Tomato(dz, dx, dy));
						box[dz][dx][dy]=box[z][x][y]+1;
					}
			}
		}
		return box[z][x][y];
	}

}
