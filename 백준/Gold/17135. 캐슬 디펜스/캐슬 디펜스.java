import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static int N,M,D;
	static boolean[] visited;
	static int max = 0;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<M;j++)
				board[i][j] = Integer.parseInt(temp[j]);
		}
		if(checkBoard(board)) {
			System.out.println(0);
			return;
		}

		//궁수 배치 - 모든 경우의 수... pick
		visited = new boolean[M];
		pick(0,0);

		System.out.println(max);
	}
	static void playGame(int[] arrowPos) {
		int[][] copyBoard = new int[N][M];

		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				copyBoard[i][j] = board[i][j];
		//공격
		answer = 0;
		while(!checkBoard(copyBoard)) {
			copyBoard = attack(copyBoard, arrowPos);
			//이동 + 졌나?/이겼나?
			move(copyBoard);
		}
		max = Math.max(max, answer);
	}
	private static int[][] attack(int[][] copyBoard, int[] arrowPos) {
		//각 궁수와 가장 가까운 적 확인. 이 중 가장 왼쪽..
		//궁수A와의 거리가 D이하이면서 가장 가까운 적 list... 이중 가장 왼쪽 애 ArrayList<int[]>

		boolean[][] check = new boolean[N][M];	//동시공격. 같은 적 공격 가능
		for(int i=0;i<3;i++) {	//궁수
			int[] target = kill(copyBoard, arrowPos[i]);

			if(target != null)
				check[target[0]][target[1]] = true;
		}

		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(check[i][j]) {
					copyBoard[i][j]=0;
					answer++;
				}

		return copyBoard;
	}
	private static int[] kill(int[][] copyBoard, int arrow) {
		int minDist = D;
		int minRow = N, minCol = M;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (copyBoard[i][j] == 1) {
					int d = calDist(N, arrow, i, j);
					if (d < minDist) {
						minDist = d;
						minRow = i;
						minCol = j;
					} else if (d == minDist && j < minCol) {
						minRow = i;
						minCol = j;
					}
				}

		return minRow != N ? new int[]{minRow, minCol} : null;
	}

	static void pick(int idx, int picked) {
		if(picked==3) {
			int[] arrowPos = new int[3];
			int index = 0;
			for(int i=0;i<M;i++)
				if(visited[i])
					arrowPos[index++] = i;

			playGame(arrowPos);
			return;
		}

		for(int i=idx;i<M;i++) {
			if(!visited[i]) {
				visited[i] = true;
				pick(i+1, picked+1);
				visited[i] = false;
			}
		}
	}

	static int calDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}

	static boolean checkBoard(int[][] copyBoard) {
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(copyBoard[i][j]==1)
					return false;

		return true;
	}
	static void move(int[][] copyBoard) {
		for(int i=N-1;i>0;i--)
			copyBoard[i] = Arrays.copyOf(copyBoard[i - 1], M);

		Arrays.fill(copyBoard[0],0);
	}
}
