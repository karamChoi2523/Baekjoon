import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] circles;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		circles = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				circles[i][j] = Integer.parseInt(st.nextToken());
		}

		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if(d==0) rotate(x, k);
			else rotate2(x, k);

			int cnt = 0;
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(circles[i][j]!=0)
						cnt += erase(i,j,circles[i][j]);

			if(cnt==0) {
				int[] arr = calAvg();
				double avg = (double) arr[0]/(N*M-arr[1]);

				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++) {
						if(circles[i][j]==0) continue;
						if(circles[i][j]>avg) circles[i][j]--;
						else if(circles[i][j]<avg) circles[i][j]++;
					}
			}
		}

		System.out.println(calAvg()[0]);
	}

	static int[] calAvg() {
		int sum = 0;
		int zero = 0;

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sum += circles[i][j];
				if(circles[i][j]==0) zero++;
			}
		}
		return new int[] {sum, zero};
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int erase(int x, int y, int target) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();

			for(int d=0;d<4;d++) {
				int nx = curr[0]+dx[d];
				int ny = curr[1]+dy[d];

				if(nx<0 || nx>=N) continue;

				if(ny<0) ny = M-1;
				else if(ny==M) ny = 0;

				if(circles[nx][ny]==target) {
					cnt++;
					circles[nx][ny] = 0;
					q.add(new int[] {nx, ny});
				}
			}
		}

		if(cnt==0)
			circles[x][y] = target;

		return cnt;
	}
	public static void rotate(int x, int k) {
		for(int i=1;i<=N;i++) {
			if(i%x == 0) {
				int[] temp = new int[M];					
				for(int j=0;j<M;j++)
					temp[(j + k) % M] = circles[i-1][j];
				
				for(int j=0;j<M;j++)
					circles[i-1][j] = temp[j];
			}
		}
	}
	static void rotate2(int x, int k) {
		for(int i=1;i<=N;i++) {
			if(i%x == 0) {
				int[] temp = new int[M];
				
				for(int j=0;j<M;j++) {
					int idx = (j-k < 0)?(M + (j-k)):(j-k);
					temp[idx] = circles[i-1][j];
				}
				
				for(int j=0;j<M;j++)
					circles[i-1][j] = temp[j];
			}
		}
	}
}
