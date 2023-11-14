import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B10026 {
	static int dr[] = new int[] {-1,1,0,0};
	static int dc[] = new int[] {0,0,-1,1};
	
	static char[][] map;
	static char[][] cMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		map = new char[n][n];
		cMap = new char[n][n];
		
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j);
				cMap[i][j] = s.charAt(j);
				
				if(map[i][j]=='G')
					cMap[i][j] = 'R';
			}
		}
		
		int cntA=0, cntB=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(map[i][j]!='C') {
					bfs(i,j,0);
					cntA++;
				}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(cMap[i][j]!='C') {
					bfs(i,j,1);
					cntB++;
				}
		System.out.println(cntA+" "+cntB);
	}
	private static void bfs(int x, int y, int type) {
		char[][] tMap = new char[map.length][map.length];
		tMap = type==0? map : cMap;
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[tMap.length][tMap.length];
		char check = tMap[x][y];
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		tMap[x][y]='C';
		
		while(!q.isEmpty()) {
			int[] pre = q.poll();
			
			for(int i=0;i<4;i++) {
				int dx = pre[0]+dr[i];
				int dy = pre[1]+dc[i];
				
				if(dx>=0 && dy>=0 && dx<tMap.length && dy<tMap.length)
					if(tMap[dx][dy]==check && !visited[dx][dy]) {
						q.add(new int[] {dx, dy});
						visited[dx][dy] = true;
						tMap[dx][dy]='C';
					}
			}
		}
		
		if(type==0)
			map = tMap;
		else
			cMap = tMap;
	}
}
