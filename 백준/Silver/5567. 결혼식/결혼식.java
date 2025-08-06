import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a][b] = 1;
			board[b][a] = 1;
		}
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		int answer = 0;
		for(int i=2;i<N+1;i++) {
			if(board[1][i]==1 && !visited[i]) {
				q.add(i);
				visited[i] = true;
				answer++;
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=2;i<N+1;i++) {
				if(board[curr][i]==1 && !visited[i]) {
					visited[i] = true;
					answer++;
				}
			}
		}
		
		return answer;
	}
}