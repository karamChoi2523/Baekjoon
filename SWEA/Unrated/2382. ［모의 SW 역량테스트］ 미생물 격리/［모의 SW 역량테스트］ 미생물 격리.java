import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, K;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	static Queue<Cell> cells;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {			
			initialize(br);
			
			while(M-->0)
				sol();
			
			int res = 0;
			while(!cells.isEmpty()) {
				res += cells.poll().cnt;
			}

			System.out.printf("#%d %d\n",tc,res);
		}
	}
	static void sol() {
		HashMap<Pos, ArrayList<Cell>> hMap = new HashMap<>();
		int size = cells.size();
		
		for(int step=0;step<size;step++) {
			Cell cell = cells.poll();
			int nx = cell.x+dx[cell.dir];
			int ny = cell.y+dy[cell.dir];
			
			if(!checkNext(nx, ny)) {
				if(cell.dir==1) cell.dir = 2;
				else if(cell.dir==2) cell.dir = 1;
				else if(cell.dir==3) cell.dir = 4;
				else cell.dir = 3;
				cell.cnt /=2;
				if(cell.cnt==0) continue;
				
				cell.x = nx;
				cell.y = ny;
				cells.add(cell);
			}else {
				cell.x = nx;
				cell.y = ny;
				
				Pos key = new Pos(nx, ny);
				if(!hMap.containsKey(key))
					hMap.put(key, new ArrayList<Cell>());
				hMap.get(key).add(cell);
			}
		}
		
		for(Pos key : hMap.keySet()) {
			ArrayList<Cell> list = hMap.get(key);
			
			if(list.size()==1) {
				cells.add(list.get(0));
			}else {
				int sum = 0;
				int dir = 0;
				int max = -1;
				for(Cell c : list) {
					sum += c.cnt;
					if(c.cnt>max) {
						max = c.cnt;
						dir = c.dir;
					}
				}
				cells.add(new Cell(key.x, key.y, sum, dir));
			}
		}
	}
	static boolean checkNext(int x, int y) {
		if(x<1 || x>=N-1 || y<1 || y>=N-1) return false;
		return true;
	}
	private static void initialize(BufferedReader br) throws IOException {		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cells = new ArrayDeque<>();
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			cells.add(new Cell(x,y,cnt,dir));
		}
		
	}
	static class Pos{
		int x, y;
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			Pos p = (Pos)obj;
			return this.x==p.x && this.y==p.y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x,y);
		}
	}
	static class Cell{
		int x, y, cnt, dir;
		
		Cell(int x, int y, int cnt, int dir){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
