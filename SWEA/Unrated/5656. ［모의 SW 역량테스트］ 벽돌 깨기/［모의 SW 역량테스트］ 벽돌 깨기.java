import java.io.*;
import java.util.*;

public class Solution {
	static int N, W, H;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {			
			initialize(br);
			
			select = new int[N];
			pick(0);
			System.out.printf("#%d %d\n",tc,min);
		}
	}
	static int[][] deepCopy(){
		int[][] copy = new int[H][W];
		
		for(int i=0;i<H;i++)
			System.arraycopy(board[i], 0, copy[i], 0, W);
	
		return copy;
	}
	//중복 순열
	static int[] select;
	static void pick(int idx) {
		if(idx==N) {
			int[][] temp = deepCopy();
			for(int i=0;i<select.length;i++)
				temp = bfs(select[i], temp);
			min = Math.min(min, countBrick(temp));
			//System.out.println(Arrays.toString(select));
			return;
		}
		
		for(int i=0;i<W;i++) {
			select[idx] = i;
			pick(idx+1);
		}
	}
	static int[][] bfs(int start, int[][] copy) {
		Queue<int[]> q = new LinkedList<>();
		int startR = -1;
		for(int i=0;i<H;i++)
			if(copy[i][start]!=0) {
				startR = i;
				break;
			}
		
		if(startR==-1) return copy;
		
		q.add(new int[] {startR, start, copy[startR][start]});
		while(!q.isEmpty()) {
			int size = q.size();

			int[] curr = q.poll();
			//공격
			for(int d=0;d<4;d++) {
				
				for(int i=1;i<curr[2];i++) {
					int nx = curr[0]+dx[d]*i;
					int ny = curr[1]+dy[d]*i;
					
					if(!checkNext(nx, ny)) break;
					if(copy[nx][ny]!=0) {
						q.add(new int[] {nx, ny, copy[nx][ny]});
						copy[nx][ny] = 0;
					}
				}
			}
			copy[curr[0]][curr[1]] = 0;
		}
		//벽돌 내려옴,,
		for(int i=0;i<W;i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int j=H-1;j>=0;j--)
				if(copy[j][i]!=0) {
					list.add(copy[j][i]);
					copy[j][i] = 0;
				}
			int idx = 0;
			for(int j=H-1;j>=0;j--) {
				if(idx>=list.size()) break;
				copy[j][i] = list.get(idx++);
			}
		}
		return copy;
	}
	static boolean checkNext(int x, int y) {
		if(x<0 || x>=H || y<0 || y>=W) return false;
		return true;
	}
	private static int countBrick(int[][] copy) {
		int cnt = 0;
		for(int i=0;i<H;i++)
			for(int j=0;j<W;j++)
				if(copy[i][j]!=0) cnt++;
		
		return cnt;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[H][W];
		min = Integer.MAX_VALUE;

		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
	}
}
