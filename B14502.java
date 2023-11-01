import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14502 {
	static int n, m;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	static int[][] input;
	
	static int maxSize=0;	//최댓값
	
	public static class Point{
		//좌표 저장
		int x, y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) {
		//안전 영역 크기의 최댓값 -> dfs
		//2의 상하좌우에 0이 있으면 바이러스 퍼짐
		//벽을 3개 세운다. -> 각 경우 testcase. 이걸 dfs돌려서 벽 세우고 bfs로 바이러스 뿌리고 안전영역 크기 알아냄. 그 중 최대
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		input = new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				input[i][j] = sc.nextInt();
		
		//벽
		dfs(0);
		
		System.out.println(maxSize);
		
	}
	
	//벽 만들기
	public static void dfs(int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++) {
				if(input[i][j]==0) {
					input[i][j]=1;
					dfs(cnt+1);
					input[i][j] = 0;
				}
			}
	}
	//바이러스 퍼짐
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		//최초에 바이러스가 있는 곳의 좌표를 q에 저장
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(input[i][j]==2)
					q.add(new Point(i,j));
		
		int[][] test = new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				test[i][j] = input[i][j];
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0;i<4;i++) {
				int dx = p.x+dr[i];
				int dy = p.y+dc[i];
				
				if(dx>=0 && dx<n && dy>=0 && dy<m && test[dx][dy]==0) {
					test[dx][dy]=2;
					q.add(new Point(dx, dy));
				}
			}
		}
		
		//res확인
		solution(test);
	}
	public static void solution(int[][] tc) {
		int res=0;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(tc[i][j]==0)
					res++;
		
		maxSize = maxSize > res? maxSize : res;
		return;
	}
}
