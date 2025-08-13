import java.io.*;
import java.util.*;

public class Main {
	static int[][] board = new int[9][9];
	static boolean[][] rows = new boolean[9][10];
	static boolean[][] cols = new boolean[9][10];
	static boolean[][] boxes = new boolean[9][10];
	static ArrayList<int[]> posList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		posList = new ArrayList<>();
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				int temp = Integer.parseInt(st.nextToken());
				board[i][j] = temp;
				if(temp==0)
					posList.add(new int[] {i,j});
				else {
					rows[i][temp] = true;
					cols[j][temp] = true;
					boxes[(i/3)*3+j/3][temp] = true;
				}
			}
		}
		dfs(0);
	}
	static void dfs(int idx) {
		if(idx==posList.size()) {
			print();
			System.exit(0);
		}
		
		int[] curr = posList.get(idx);
		int x = curr[0];
		int y = curr[1];
		
		for(int i=1;i<10;i++) {
			if(rows[x][i] || cols[y][i] || boxes[(x/3)*3+y/3][i]) continue;
			
			board[x][y] = i;
			rows[x][i] = cols[y][i] = boxes[(x/3)*3+y/3][i] = true;
			dfs(idx+1);
			rows[x][i] = cols[y][i] = boxes[(x/3)*3+y/3][i] = false;
			board[x][y] = 0;
		}
		
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
