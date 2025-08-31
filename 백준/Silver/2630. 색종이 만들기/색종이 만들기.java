import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] board;
	static int white;
	static int blue;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		initialize(br);
		
		sol(0,0,N);

		System.out.println(white);
		System.out.println(blue);
	}
	static int[] dx = {0,1,0,1};
	static int[] dy = {0,0,1,1};
	static void sol(int x, int y, int size) {
		for(int d=0;d<4;d++) {
			int nx = x+dx[d]*size;
			int ny = y+dy[d]*size;
			
			if(nx+size>N || ny+size>N) continue;
			if(!check(nx, ny, size)) {
				sol(nx, ny, size/2);
			}else {
				for(int i=nx;i<nx+size;i++)
					for(int j=ny;j<ny+size;j++)
						visited[i][j] = true;
			}
		}
	}
	static boolean check(int x, int y, int size) {
		int target = board[x][y];
		
		for(int i=x;i<x+size;i++)
			for(int j=y;j<y+size;j++)
				if(board[i][j]!=target || visited[i][j]) return false;
		
		if(target==0) white++;
		else blue++;
		
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
	}
}
