import java.io.*;
import java.util.*;

public class Main {
	static int N, answer = -1;
	static boolean[] visited = new boolean[10];
	static int[] players = new int[10];
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());	//N이닝 동안 게임 진행

		board = new int[N][10];

		for(int i=0;i<N;i++) { //각 선수가 각 이닝에서 얻는 결과
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int j=1;j<10;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		players[4] = 1;
		visited[4] = true;
		
		pick(2);
		System.out.println(answer);
		
	}
	static void pick(int cnt) {
		if(cnt==10) {
			answer = Math.max(answer, playGame());
			return;
		}
		
		for(int i=1;i<10;i++) {
			if(!visited[i]) {
				visited[i] = true;
				players[i] = cnt;
                pick(cnt+1);
				visited[i] = false;
			}
		}
	}
	private static int playGame() {
		int start = 1;
		int score = 0;
		
		for(int i=0;i<N;i++) {
			int[] point = {0,0,0,0,0};
			
			while(point[0]<3) {
				move(point, board[i][players[start]]);
				if(start==9) start = 1;
				else start++;
			}
			score += point[4];
		}
		return score;
	}
	private static void move(int[] point, int size) {
		for(int i=0;i<size;i++) {
			point[4]+=point[3];
			point[3]=point[2];
			point[2]=point[1];
			point[1]=0;
		}
		
		point[size]++;
	}
}
