import java.io.*;
import java.util.*;

public class Main {
	static int[][] board = new int[9][9];
	static ArrayList<int[]> empty = new ArrayList<>();
	static boolean[][] rows = new boolean[9][10];
	static boolean[][] cols = new boolean[9][10];
	static boolean[][] boxes = new boolean[9][10];
	static boolean solved = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());

			for(int j=0;j<9;j++) {
				int temp = Integer.parseInt(st.nextToken());
				board[i][j] = temp;
				if(temp==0)
					empty.add(new int[] {i,j});
				else {
					rows[i][temp] = true;
					cols[j][temp] = true;
					boxes[calIndex(i,j)][temp] = true;
				}
			}
		}

		dfs(0);
	}
	static void dfs(int idx) {
		if(idx == empty.size()) {
			print();
			solved = true;
			return;
		}

		int x = empty.get(idx)[0];
		int y = empty.get(idx)[1];
		int checkBox = calIndex(x, y);

		for(int i=1;i<10;i++) {
			if(rows[x][i] || cols[y][i] || boxes[checkBox][i]) continue;
			
			board[x][y] = i;
			rows[x][i] = cols[y][i] = boxes[checkBox][i] = true;
			
			dfs(idx+1);
			if(solved) return;
			board[x][y] = 0;
			rows[x][i] = cols[y][i] = boxes[checkBox][i] = false;
		}
	}
	static int calIndex(int x, int y) {
		return (x/3)*3 + y/3;
	}
	static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				sb.append(board[i][j]+" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
