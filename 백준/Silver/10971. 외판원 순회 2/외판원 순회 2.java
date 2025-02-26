import java.io.*;
import java.util.*;

public class Main {
	static long ans = Long.MAX_VALUE;
	static int N;
	static int[][] W;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());
		visited = new boolean[N];
		W = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				W[i][j] = Integer.valueOf(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			visited[i] = true;
			solution(1, i, i, 0);
			visited[i] = false;
		}
		
		System.out.println(ans);
	}
	private static void solution(int depth, int start, int preNode, long cost) {
		if(depth==N) {
			if(W[preNode][start]==0) return;
			ans = Math.min(cost+W[preNode][start], ans);
            return;
		}
		
		for(int i=0;i<N;i++) {
			if(i!=start && W[preNode][i]!=0 && !visited[i]) {
				visited[i] = true;
				solution(depth+1, start, i, cost+W[preNode][i]);
				visited[i] = false;
			}
		}
	}
}
