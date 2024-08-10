import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n, m;
	static boolean[] open;
	static ArrayList<int[]> houses, posList;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System .in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		board = new int[n+1][n+1];
		
		houses = new ArrayList<>();
		posList = new ArrayList<>();	//치킨집
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<n+1;j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
				
				if(board[i][j]==1)
					houses.add(new int[] {i, j});
				else if(board[i][j]==2)
					posList.add(new int[] {i, j});
				
			}
		}
		
		//1<= 집 <=2n
		//m<= 치킨집 <=13
		
		//폐업x 치킨집 최대 m개. 치킨 거리의 최솟값.

		open = new boolean[posList.size()];
		
		//폐업
		//m개를 pick
		//가장 최솟값을 갖는 경우를 구한다
		//백트래킹
		dfs(0,0);
		System.out.println(answer);
	}
	private static void dfs(int start, int cnt) {
		if(cnt == m) {
			int sum = 0;
			
			for(int[] house : houses) {
				int min = Integer.MAX_VALUE;
				
				for(int i=0;i<posList.size();i++)
					if(open[i]) {
						int temp = Math.abs(house[0]-posList.get(i)[0])+Math.abs(house[1]-posList.get(i)[1]);
						min = Math.min(min, temp);
					}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		//백트래킹 - m개 pick
		for(int i=start;i<posList.size();i++) {
			open[i] = true;
			dfs(i+1, cnt+1);
			open[i] = false;
		}
	}	
}
