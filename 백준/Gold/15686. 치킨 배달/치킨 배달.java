import java.io.*;
import java.util.*;

public class Main {
	static class Chicken{
		int x, y;
		
		public Chicken(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static int[][] board;
	static ArrayList<Chicken> chickens = new ArrayList<>();
	static int[] select;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		select = new int[M];
		board = new int[N+1][N+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1;j<N+1;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==2) {
					chickens.add(new Chicken(i, j));
				}
			}
		}
		
		if(chickens.size()>M)
			combination(0,0);
		else {
			Arrays.fill(select, -1);
			for(int i=0;i<chickens.size();i++)
				select[i] = i;
			min = cal();
		}
		System.out.println(min);
	}
	static int cal() {
		int total = 0;
		for(int i=1;i<N+1;i++)
			for(int j=1;j<N+1;j++) {
				if(board[i][j]==1) {
					int minD = Integer.MAX_VALUE;
					for(int k=0;k<M;k++) {
						if(select[k]==-1) break;
						minD = Math.min(minD, calDist(chickens.get(select[k]),i,j));
					}
					total+=minD;
				}
			}
		
		return total;
	}
	static void combination(int idx, int k) {
		if(k==M) {
			//System.out.println(Arrays.toString(select));
			min = Math.min(min, cal());
			return;
		}
		
		if(idx==chickens.size()) return;
		
		select[k] = idx;
		combination(idx+1, k+1);
		combination(idx+1, k);
	}
	
	static int calDist(Chicken p, int r2, int c2) {
		return Math.abs(p.x-r2)+Math.abs(p.y-c2);
	}
}