import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int i=0;i<N;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<M;j++)
				board[i][j] = temp[j]-'0';
		}
		
		System.out.println(bfs());
	}
	static int min = Integer.MAX_VALUE;
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,0,1});	//x,y,did,len
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int step=0;step<size;step++) {
				int[] curr = q.poll();
				int cx = curr[0];
				int cy = curr[1];
				int did = curr[2];
				int len = curr[3];
				
				if(cx==N-1 && cy==M-1) {
					return len;
				}
				
				for(int d=0;d<4;d++) {
					int nx = cx+dx[d];
					int ny = cy+dy[d];
					
					if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
					//도착 확인을 여기에서 하면 큐에 못 들어가는 경우를 답으로 반환할 수도 있어서 cx cy에 대해 체크해야 함!!!
					if(visited[nx][ny][did]) continue;
					
					if(board[nx][ny]==1 && did==0) {
						q.add(new int[] {nx, ny, 1, len+1});
						visited[nx][ny][1] = true;
					} else if(board[nx][ny]==0) {
						q.add(new int[] {nx, ny, did, len+1});
						visited[nx][ny][did] = true;
					}
				}
			}
		}
		return -1;
	}
}