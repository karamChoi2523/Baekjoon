import java.io.*;
import java.util.*;

public class Main {
	static class Bomb implements Comparable<Bomb>{
		int x, y, time;
		
		public Bomb(int x, int y) {
			this.x = x;
			this.y = y;
			this.time = 3;
		}
		
		@Override
		public int compareTo(Bomb o) {
			return this.time-o.time;
		}
	}
	static int R,C,N;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static char[][][] versionMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		versionMap = new char[3][R][C];
		
		//1초
		for(int i=0;i<R;i++)
			versionMap[0][i] = br.readLine().toCharArray();
		//3초 5초
		for(int i=0;i<2;i++) {
			check(i, i+1);
			make(i+1);
		}
		
		if(N%2==0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++)
					System.out.print('O');
				System.out.println();
			}
		}else {
			if(N==1) {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++)
						System.out.print(versionMap[0][i][j]);
					System.out.println();
				}
			}else if(N%4==3) {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++)
						System.out.print(versionMap[1][i][j]);
					System.out.println();
				}
			}else {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++)
						System.out.print(versionMap[2][i][j]);
					System.out.println();
				}
			}
		}
	}
	static void make(int curr) {
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++) {
				if(versionMap[curr][i][j]=='.') continue;
				versionMap[curr][i][j] = 'O';
			}
	}
	static void check(int pre, int curr) {
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				if(versionMap[pre][i][j]=='O') {
					versionMap[curr][i][j] = '.';
					for(int d=0;d<4;d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						
						if(nx>=0 && nx<R && ny>=0 && ny<C)
							versionMap[curr][nx][ny]='.';
					}
				}
	}
}