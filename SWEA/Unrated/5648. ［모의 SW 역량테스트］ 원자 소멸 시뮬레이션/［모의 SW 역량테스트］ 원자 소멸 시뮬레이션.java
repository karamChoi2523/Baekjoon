import java.io.*;
import java.util.*;

public class Solution {
	static int N;	//원자의 개수
	static ArrayList<Atom> atoms;
	static final int INF = (int)1e9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			initialize(br);

			int res = makeBoomPair();
			System.out.printf("#%d %d\n",tc, res);
		}
	}
	private static int makeBoomPair() {
		//좌표 기준 정렬
		Collections.sort(atoms);

		ArrayList<Pair> boomList = new ArrayList<>();

		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++) {
				Atom a = atoms.get(i);
				Atom b = atoms.get(j);

				//수직선에서 만날 때(같은 x좌표)
				if(a.x==b.x && a.dir==0 && b.dir==1)	//행렬이 아니라 좌표평면임
					boomList.add(new Pair(i,j,Math.abs(a.y-b.y)/2));
				//수평선에서 만날 때(같은 y좌표)
				if(a.y==b.y && a.dir==3 && b.dir==2)
					boomList.add(new Pair(i,j,Math.abs(a.x-b.x)/2));
				// / 대각선 라인에 있는 대상들이 만날때
				if(a.x-a.y==b.x-b.y)
					if((a.dir==3 && b.dir==1)||(a.dir==0 && b.dir==2))
						boomList.add(new Pair(i,j,Math.abs(a.x-b.x)));
				//  \ 대각선 라인에 있는 대상들이 만날때 
				if(a.x+a.y==b.x+b.y)
					if((a.dir==1 && b.dir==2)||(a.dir==3 && b.dir==0))
						boomList.add(new Pair(i,j,Math.abs(a.x-b.x)));
			}
		return getTotalEnergy(boomList);
	}
	private static int getTotalEnergy(ArrayList<Pair> boomList) {
		Collections.sort(boomList);

		int[] boomTimes = new int[N];
		Arrays.fill(boomTimes, INF);

		int sum = 0;

		for(Pair p:boomList) {
			if(boomTimes[p.x]<p.time || boomTimes[p.y]<p.time) continue;

			if(boomTimes[p.x]==INF) {
				boomTimes[p.x] = p.time;
				sum += atoms.get(p.x).k;
			}

			if(boomTimes[p.y]==INF) {
				boomTimes[p.y]=p.time;
				sum += atoms.get(p.y).k;
			}
		}
		return sum;
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		atoms = new ArrayList<>();

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			//나누었을 때 실수 사용하지 않도록 2배로 좌표 키우기
			int x = Integer.parseInt(st.nextToken())*2;
			int y = Integer.parseInt(st.nextToken())*2;
			int dir = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			atoms.add(new Atom(x,y,dir,k));
		}
	}
	static class Atom implements Comparable<Atom>{
		int x, y, dir, k;

		public Atom(int x, int y, int dir, int k) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.k = k;
		}
		@Override
		public int compareTo(Atom o) {
			//x좌표 작은 순, 같다면 y좌표가 빠른 순
			//			if(this.x==o.x)
			//				return this.y-o.y;
			//			return this.x-o.x;
			//음수 좌표가 있으므로 뺄셈을 사용하면 안 좋음!!!!!!!
			return this.x<o.x?-1: (this.x!=o.x? Integer.compare(this.x, o.x):Integer.compare(this.y,o.y));
		}
	}
	static class Pair implements Comparable<Pair>{
		int x, y, time;

		public Pair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.time, o.time);
		}
	}
}
