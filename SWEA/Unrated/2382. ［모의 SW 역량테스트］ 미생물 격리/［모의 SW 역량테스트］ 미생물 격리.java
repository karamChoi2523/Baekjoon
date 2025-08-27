import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, K;
	static Queue<Cell> q;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	//1 2 3 4
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {			
			initialize(br);

			bfs();
			
			int total = 0;
			while(!q.isEmpty()) {
				total += q.poll().cnt;
			}

			System.out.printf("#%d %d\n",tc,total);
		}
	}
	static void bfs() {
		while(M-->0) {
			int size = q.size();
			HashMap<Pos, ArrayList<Cell>> hMap = new HashMap<>();
			for(int step=0;step<size;step++) {
				Cell cell = q.poll();
				
				int nx = cell.x+dx[cell.d];
				int ny = cell.y+dy[cell.d];
				
				if(!checkBoard(nx, ny)) {
					cell.cnt/=2;
					if(cell.cnt==0) continue;
					if(cell.d==1) cell.d = 2;
					else if(cell.d==2) cell.d = 1;
					else if(cell.d==3) cell.d = 4;
					else cell.d = 3;
				}
				
				if(hMap.containsKey(new Pos(nx, ny)))
					hMap.get(new Pos(nx, ny)).add(new Cell(nx, ny, cell.cnt, cell.d));
				else {
					ArrayList<Cell> temp = new ArrayList<>();
					temp.add(new Cell(nx, ny, cell.cnt, cell.d));
					hMap.put(new Pos(nx, ny), temp);
				}
			}
			
			for(Pos p : hMap.keySet()) {
				ArrayList<Cell> curr = hMap.get(p);
				if(curr.size()==1) {
					q.add(curr.get(0));
				}else {
					int max = -1;
					int dIdx = -1;
					int cnt = 0;
					for(Cell cell : curr) {
						cnt += cell.cnt;
						if(max < cell.cnt) {
							max = cell.cnt;
							dIdx = cell.d;
						}
					}
					q.add(new Cell(p.x, p.y, cnt, dIdx));
				}
			}
		}
	}
	static boolean checkBoard(int x, int y) {
		if(x>0 && x<N-1 && y>0 && y<N-1) return true;
		return false;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			q.add(new Cell(x,y,cnt,d));
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
			Pos p = (Pos) obj;
			return this.x==p.x && this.y == p.y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
	static class Cell{
		int x, y, cnt, d;

		Cell(int x, int y, int cnt, int d){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.d = d;
		}
	}
}
