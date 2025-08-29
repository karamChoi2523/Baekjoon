import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		rotateOp();
		print();
	}
	static void rotateOp() {
		int step = Math.min(N, M);
		
		for(int i=0;i<step/2;i++) {
			int top = i;
			int left = i;
			int bottom = N-1-i;
			int right = M-1-i;
			
			ArrayList<int[]> pos = new ArrayList<>();
			for(int y=left;y<=right;y++)
				pos.add(new int[] {top, y});
			for(int x=top+1;x<=bottom;x++)
				pos.add(new int[] {x,right});
			for(int y=right-1;y>=left;y--)
				pos.add(new int[] {bottom,y});
			for(int x=bottom-1;x>top;x--)
				pos.add(new int[] {x, left});
			
			int L = pos.size();
			int k = R% L;
			if(k==0) continue;
			
			int[] val = new int[L];
			for(int j=0;j<L;j++) {
				int[] p = pos.get(j);
				val[j] = board[p[0]][p[1]];
			}
			for(int j=0;j<L;j++) {
				int idx = (j-k);
				if(idx<0) idx+=L;
				int[] p = pos.get(idx);
				board[p[0]][p[1]] = val[j];
			}			
		}
	}
	static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				sb.append(board[i][j]+" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
