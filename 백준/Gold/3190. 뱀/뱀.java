import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	static int[][] board;
	static int n, k, l;
	static ArrayList<int[]> snake = new ArrayList<>();
	static HashMap<Integer, String> hMap = new HashMap<>();
	static int[] dx = new int[] {0,1,0,-1};
	static int[] dy = new int[] {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());
		int k = Integer.valueOf(br.readLine());
		
		board = new int[n][n];
		
		for(int i=0;i<k;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken())-1;
			int b = Integer.valueOf(st.nextToken())-1;
			
			board[a][b] = 1;
		}
		
		int l = Integer.valueOf(br.readLine());
		for(int i=0;i<l;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			String b = st.nextToken();
			
			hMap.put(a, b);
		}
		
		int cx=0, cy=0;
		int cnt = 0;
		int dir = 0;
		snake.add(new int[] {0,0});
		
		while(true) {
			cnt++;
			
			int nx = cx+dx[dir];
			int ny = cy+dy[dir];
			
			if(checkWall(nx, ny))
				break;
			
			if(board[nx][ny]==1)
				board[nx][ny] = 0;
			else
				snake.remove(0);
			
			snake.add(new int[] {nx, ny});
			
			if(hMap.containsKey(cnt))
				dir = changeDir(dir, hMap.get(cnt));
			
			cx = nx;
			cy = ny;
		}
		
		
		System.out.println(cnt);
	}
	private static boolean checkWall(int nx, int ny) {
		//벽, 몸뚱이 확인
		if(nx>=0 && nx<n && ny>=0 && ny<n)
			for(int i=0;i<snake.size();i++) {
				if(snake.get(i)[0]==nx && snake.get(i)[1]==ny)
					return true;
			}
		else
			return true;
		
		return false;
	}
	//방향 전환
	private static int changeDir(int curr, String dir) {
		if(dir.equals("D")) {
			curr++;
			if(curr>3)
				curr = 0;			
		}else {
			curr--;
			if(curr < 0)
				curr = 3;
		}
		return curr;
	}
	
}
