import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dust{
	int x, y, w;
	
	public Dust(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}

public class B17144 {
	static int[] dr = new int[] {-1,1,0,0};
	static int[] dc = new int[] {0,0,-1,1};
	static int cleaner = -1;
	static Queue<Dust> dusts;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
	
		map = new int[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(cleaner==-1 && map[i][j]==-1)
					cleaner = i;
			}
		}
		
		for(int i=0;i<t;i++) {
			checkDust();
			
			bfs();
			
			operate();
		}
		
		int res = 0;
		
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				if(map[i][j]!=-1)
					res += map[i][j];
		System.out.println(res);
	}

	private static void checkDust() {
		dusts = new LinkedList<>();
		
		for(int i=0;i<map.length;i++)
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j]==-1 || map[i][j]==0)
					continue;
				dusts.add(new Dust(i,j,map[i][j]));
			}
	}
	
	private static void bfs() {
		while(!dusts.isEmpty()) {
			Dust curr = dusts.poll();
			
			if(curr.w<5)
				continue;
			
			int sAmount = curr.w/5;
			int cnt=0;
			
			for(int i=0;i<4;i++) {
				int dx = curr.x+dr[i];
				int dy = curr.y+dc[i];
				
				if(dx>=0 && dy>=0 && dx<map.length && dy<map[0].length)
					if(map[dx][dy]!=-1) {
						map[dx][dy] += sAmount;
						cnt++;
					}
			}
			map[curr.x][curr.y] -= (sAmount*cnt);
		}
	}
	
	private static void operate() {
		int top = cleaner;
		int down = cleaner + 1;
		int R = map.length;
		int C = map[0].length;
		
		// 위쪽 공기청정기의 바람은 반시계방향 순환,
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--) 
            map[i][0] = map[i-1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) 
            map[0][i] = map[0][i+1];
        // 위로 당기기
        for (int i = 0; i < top; i++) 
            map[i][C - 1] = map[i + 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
            map[top][i] = map[top][i-1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[top][1] = 0;
        
        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
        // 위로 당기기
        for (int i = down + 1; i < R - 1; i++) 
            map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) 
            map[R - 1][i] = map[R - 1][i + 1]; 
        // 아래로 당기기
        for (int i = R - 1; i > down; i--) 
            map[i][C - 1] = map[i - 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
            map[down][i] = map[down][i - 1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[down][1] = 0;
	}
}
