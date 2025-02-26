import java.io.*;
import java.util.*;

public class Main {
	static long ansTime = Integer.MAX_VALUE;
	static int ansHeight = -1;
	static int[][] board;
	static int N,M;
	static long B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		B = Integer.valueOf(st.nextToken());
		
		board = new int[N][M];
		
		int minH=Integer.MAX_VALUE, maxH=-1;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<M;j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
				minH = Math.min(minH, board[i][j]);
				maxH = Math.max(maxH, board[i][j]);
			}
		}
		
		for(int i=minH;i<=maxH;i++) {
			solution(i);
		}
		
		System.out.println(ansTime+" "+ansHeight);
	}
	private static void solution(int target) {
		long time = 0;
		long block = B;
		boolean check = true;
		
		LOOP:for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				int temp = Math.abs(board[i][j]-target);
				
				if(board[i][j]>target) {
					time+=temp*2;
					block+=temp;
				}else if(board[i][j]<target) {
					time+=temp;
					block-=temp;
				}
				
				
				if(time>ansTime){
					check = false;
					break LOOP;
				}
			}
		
		if(block<0)
			check = false;
		
		if(check) {
			if(ansTime >= time) {
				ansTime = time;
				ansHeight = Math.max(target, ansHeight);
			}
		}		
	}
}
