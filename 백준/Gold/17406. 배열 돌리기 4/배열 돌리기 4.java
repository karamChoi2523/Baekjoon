import java.io.*;
import java.util.*;

public class Main {
	static class Pos{
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
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
	static void pick(int depth) {
		if(depth==K) {
			int[][] copy = new int[N][M];
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					copy[i][j] = board[i][j];
			for(int[] e : select) {
				//안쪽도 같이 돈다
				int r = e[0], c = e[1], s=e[2];
				int len = ((r+s)-(r-s))/2;	//2
				for(int i=0;i<len;i++)
					copy = rotate(copy, e[0], e[1], e[2], i);
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
	static int[][] rotate(int[][] copy, int r, int c, int s, int size) {
		int rowS = r-s-1+size;
		int rowE = r+s-1-size;
		int colS = c-s-1+size;
		int colE = c+s-1-size;
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Pos> posList = new ArrayList<>();
		//시계 방향
		for(int i=colS;i<colE;i++) {
			list.add(copy[rowS][i]);
			posList.add(new Pos(rowS, i));
		}
		for(int i=rowS;i<rowE;i++) {
			list.add(copy[i][colE]);
			posList.add(new Pos(i, colE));
		}
		for(int i=colE;i>=colS;i--) {
			list.add(copy[rowE][i]);
			posList.add(new Pos(rowE, i));
		}
		for(int i=rowE-1;i>rowS;i--) {
			list.add(copy[i][colS]);
			posList.add(new Pos(i, colS));
		}
		
		for(int i=1;i<posList.size();i++) {
			Pos curr = posList.get(i);
			
			copy[curr.x][curr.y] = list.get(i-1);
		}
		
		Pos start = posList.get(0);
		copy[start.x][start.y] = list.get(list.size()-1);
		
		return copy;
	}
	static int findA(int[][] copy) {
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++)
			min = Math.min(min, Arrays.stream(copy[i]).sum());
		
		return min;
	}
}
