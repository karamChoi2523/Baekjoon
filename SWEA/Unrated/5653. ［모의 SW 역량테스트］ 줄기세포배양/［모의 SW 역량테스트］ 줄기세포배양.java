import java.util.*;
import java.io.*;

public class Solution {
	static int N,M,K;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Cell[] cell;
	static boolean[][] visited;
	static int count;
	
	static class Cell{
		int x, y;
		int time;
		int life;
		Cell next;
		
		public Cell(int x, int y, int life, Cell next) {
			this.x = x;
			this.y = y;
			this.life = life<<1;
			this.next = next;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			count = 0;
			cell = new Cell[11];
			visited = new boolean[N+2*K][M+2*K];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp!=0) {
						cell[temp] = new Cell(i+K, j+K, temp, cell[temp]);
						visited[i+K][j+K] = true;
						count++;
					}
				}
			}
			
			while(K-->0) {
				for(int life=10;life>=1;life--) {
					Cell curr= cell[life];
					while(curr!=null) {
						if(curr.life==0)
							break;
						curr.life--;
						if(curr.life == life-1) {
							for(int d=0;d<4;d++) {
								int nx = curr.x+dx[d];
								int ny = curr.y+dy[d];
								
								if(visited[nx][ny]) continue;
								visited[nx][ny] = true;
								cell[life] = new Cell(nx, ny, life, cell[life]);
								count++;
							}
						}
						if(curr.life==0)
							count--;
						
						curr = curr.next;
					}
				}
			}
			System.out.printf("#%d %d\n",tc,count);
		}
	}
}