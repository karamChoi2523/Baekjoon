import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
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
			for(int j=0;j<M;j++) {
				board[i][j] = temp[j]-'0';
			}
		}
		
		int sum = 0;
		boolean changed = true;
		while(changed) {
			changed = false;
			
			for(int h=1;h<9;h++) {
				boolean[][] visited = new boolean[N][M];
				
				for(int i=1;i<N-1;i++)
					for(int j=1;j<M-1;j++) {
						if(board[i][j] == h && !visited[i][j]) {
							ArrayList<int[]> checkList = new ArrayList<>();
							dfs(i,j,visited, board[i][j],checkList);
							
							int minH = checkCovered(checkList);
							
							if(minH > h) {
								sum += checkList.size() * (minH - h);
								for(int[] pos : checkList) {
									board[pos[0]][pos[1]] = minH;
								}
								changed = true;
							}
						}
					}
			}
		}
		System.out.println(sum);
	}
	static int checkCovered(ArrayList<int[]> checkList) {
		int minH = Integer.MAX_VALUE;
		
		for(int[] pos : checkList) {
			int x = pos[0];
			int y = pos[1];
			int curr = board[x][y];
			
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=M) return -1;	//가장자리에 있다는 의미니까....
				if(board[nx][ny] < curr) return -1;	//더 낮은 게 있으면... 물이 흘러가버림
				if(board[nx][ny]>curr)
					minH = Math.min(minH, board[nx][ny]);
			}
		}
		return minH==Integer.MAX_VALUE?-1:minH;
	}
	static void dfs(int x, int y, boolean[][] visited, int target, ArrayList<int[]> checkList) {
		visited[x][y] = true;
		checkList.add(new int[] {x,y});
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;
			if(board[nx][ny] == target)
				dfs(nx, ny, visited, target, checkList);
		}
		
	}
}