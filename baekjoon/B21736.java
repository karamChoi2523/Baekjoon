import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B21736 {
	static int[] dr = new int[] {-1,1,0,0};
	static int[] dc = new int[] {0,0,-1,1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		char[][] map = new char[n][m];
		int x=0,y=0;
		
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			
			for(int j=0;j<s.length();j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='I') {
					x=i;
					y=j;
				}
			}
		}
		
		bfs(map, x, y);
	}

	private static void bfs(char[][] map, int x, int y) {
		int cnt=0;
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] pre = q.poll();
			
			for(int i=0;i<4;i++) {
				int dx = pre[0]+dr[i];
				int dy = pre[1]+dc[i];
				
				if(dx>=0 && dy>=0 && dx<map.length && dy<map[0].length && !visited[dx][dy]) {
					if(map[dx][dy]=='X')
						continue;
					if(map[dx][dy]=='P')
						cnt++;
					visited[dx][dy]=true;
					q.add(new int[] {dx, dy});
				}
			}
			
		}
		
		if(cnt == 0)
			System.out.println("TT");
		else
			System.out.println(cnt);
	}
	
	
}
