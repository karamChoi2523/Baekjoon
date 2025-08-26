import java.io.*;
import java.util.*;

public class Solution {
	static int N, X;
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {			
			initialize(br);
			
			int cnt = 0;
			for(int i=0;i<N;i++) {
				if(checkRow(i)) cnt++;
				if(checkCol(i)) cnt++;
			}

			System.out.printf("#%d %s\n",tc,cnt);
		}
	}
	static boolean checkRow(int idx) {
		boolean[] visited = new boolean[N];
		int h = board[idx][0];
		for(int i=0;i<N;i++) {
			if(board[idx][i]==h) continue;
			
			if(Math.abs(board[idx][i]-h)==1) {
				if(board[idx][i]<h) {
					if(i+X>N) return false;
					
					int nextH = board[idx][i];
					boolean isPossible = true;
					boolean[] temp = visited.clone();
					for(int j=i;j<i+X;j++) {
						if(visited[j]) return false;
						if(board[idx][j]!=nextH) {
							isPossible = false;
							break;
						}
						temp[j] = true;
					}
					if(isPossible) {
						h -= 1;
						visited = temp.clone();
					}
					else return false;
				}else {
					if(i-X<0) return false;
					boolean isPossible = true;
					boolean[] temp = visited.clone();
					for(int j=i-1;j>=i-X;j--) {
						if(visited[j]) return false;
						if(board[idx][j]!=h) {
							isPossible = false;
							break;
						}
						temp[j] = true;
					}
					if(isPossible) {
						h += 1;
						visited = temp.clone();
					}
					else return false;
				}
			}else return false;
		}
		return true;
	}
	static boolean checkCol(int idx) {
		boolean[] visited = new boolean[N];
		int h = board[0][idx];
		for(int i=0;i<N;i++) {
			if(board[i][idx]==h) continue;
			
			if(Math.abs(board[i][idx]-h)==1) {
				if(board[i][idx]<h) {
					if(i+X>N) return false;
					
					int nextH = board[i][idx];
					boolean isPossible = true;
					boolean[] temp = visited.clone();
					for(int j=i;j<i+X;j++) {
						if(visited[j]) return false;
						if(board[j][idx]!=nextH) {
							isPossible = false;
							break;
						}
						temp[j] = true;
					}
					if(isPossible) {
						h -= 1;
						visited = temp.clone();
					}
					else return false;
				}else {
					if(i-X<0) return false;
					boolean isPossible = true;
					boolean[] temp = visited.clone();
					for(int j=i-1;j>=i-X;j--) {
						if(visited[j]) return false;
						if(board[j][idx]!=h) {
							isPossible = false;
							break;
						}
						temp[j] = true;
					}
					if(isPossible) {
						h += 1;
						visited = temp.clone();
					}
					else return false;
				}
			}else return false;
		}
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
	}
}
