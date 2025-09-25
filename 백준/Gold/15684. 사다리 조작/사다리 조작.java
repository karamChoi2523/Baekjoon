import java.util.*;
import java.io.*;

public class Main {
	static int N, M, H;
	static boolean[][] visited;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		visited = new boolean[H+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visited[a][b] = true;
		}
		min = Integer.MAX_VALUE;

		dfs(1,0);
		
		System.out.println(min>3?-1:min);
	}
	static void dfs(int idx, int cnt) {
		if(cnt>=min) return;
		if(check()) {
			min = Math.min(min, cnt);
			return;
		}
		
		if(cnt==3) return;
		
		for(int i=idx;i<=H;i++) {
			for(int j=1;j<N;j++) {
				if(visited[i][j]) continue;
				if(j>1 && visited[i][j-1]) continue;
				if(j<N-1 && visited[i][j+1]) continue;
				
				visited[i][j] = true;
				dfs(i, cnt+1);
				visited[i][j] = false;
			}
		}
	}
	private static boolean check() {
		for(int i=1;i<=N;i++) {
			int curr = i;
			
			for(int h=1;h<=H;h++) {
				if(visited[h][curr]) curr++;
				else if(curr>1 && visited[h][curr-1]) curr--;
			}
			if(curr != i) return false;
		}
		return true;
	}
}
