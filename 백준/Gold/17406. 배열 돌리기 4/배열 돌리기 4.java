import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] board;
	static int[][] order;
	static boolean[] visited;
	static int[][] select;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		order = new int[K][3];
		visited = new boolean[K];
		select = new int[K][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			order[k][0] = a;
			order[k][1] = b;
			order[k][2] = c;
		}
		
		//순서 결정
		pick(0);
		
		System.out.println(answer);
	}
	static int[][] deepCopy() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++)
            System.arraycopy(board[i], 0, copy[i], 0, M);
        return copy;
    }
	static void pick(int depth) {
		if(depth==K) {
			int[][] copy = deepCopy();
			for(int[] e : select) {
				//안쪽도 같이 돈다
				copy = rotate(copy, e[0], e[1], e[2]);
			}
			answer = Math.min(answer, findA(copy));
		}
		
		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				visited[i] = true;
				select[depth] = order[i];
				pick(depth+1);
				visited[i] = false;
			}
		}
		
	}
	static int[][] rotate(int[][] copy, int r, int c, int s) {
		r-=1;
		c-=1;
		
		for(int layer = 1;layer<=s;layer++) {
			int rowS = r - layer;
            int colS = c - layer;
            int rowE = r + layer;
            int colE = c + layer;
            
            int prev = copy[rowS][colS];
            
            for(int j=colS+1;j<=colE;j++) {
            	int temp = copy[rowS][j];
            	copy[rowS][j] = prev;
            	prev = temp;
            }
            
            for(int i=rowS+1;i<=rowE;i++) {
            	int temp = copy[i][colE];
            	copy[i][colE] = prev;
            	prev = temp;
            }
            
            for(int j=colE-1;j>=colS;j--) {
            	int temp = copy[rowE][j];
            	copy[rowE][j] = prev;
            	prev = temp;
            }
            
            for(int i=rowE-1;i>=rowS;i--) {
            	int temp = copy[i][colS];
            	copy[i][colS] = prev;
            	prev = temp;
            }
		}
		
		return copy;
	}
	static int findA(int[][] copy) {
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int j=0;j<M;j++)
				sum+=copy[i][j];
			min = Math.min(min, sum);
		}
		return min;
	}
}
