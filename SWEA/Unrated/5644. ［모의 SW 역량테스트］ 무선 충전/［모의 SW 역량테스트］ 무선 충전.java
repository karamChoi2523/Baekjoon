import java.io.*;
import java.util.*;

public class Solution {
	static class BC implements Comparable<BC>{
		int x, y;
		int coverage;
		int performance;
		int index;
		
		public BC(int idx, int x, int y, int c, int p) {
			index = idx;
			this.x = x;
			this.y = y;
			coverage = c;
			performance = p;
		}
		
		@Override
		public int compareTo(BC o) {
			return o.performance-this.performance;
		}
		
		public boolean isInCoverage(int x, int y) {
			return Math.abs(this.x-x)+Math.abs(this.y-y)<=this.coverage;
		}
	}
	static int[] aList;
	static int[] bList;
	static ArrayList<BC> bcList;
	static int ax,ay,bx,by;
	static int[] dx = {0,0,1,0,-1};	//열
	static int[] dy = {0,-1,0,1,0};	//행
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			aList = new int[M+1];
			bList = new int[M+1];
			bcList = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for(int i=1;i<M+1;i++)
				aList[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for(int i=1;i<M+1;i++)
				bList[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
			
				bcList.add(new BC(i,x,y,c,p));
			}
			
			Collections.sort(bcList);
			
			ax = 1;
			ay = 1;
			bx = 10;
			by = 10;
			max = 0;
			for(int time=0;time<M+1;time++) {
				move(time);
				calCoverage();
			}
			
			System.out.printf("#%d %d\n",tc,max);
		}
	}
	static void calCoverage() {
		ArrayList<BC> bcA = new ArrayList<>();
		ArrayList<BC> bcB = new ArrayList<>();
		
		for(int i=0;i<bcList.size();i++) {
			BC bc = bcList.get(i);
			if(bc.isInCoverage(ax, ay))
				bcA.add(bc);
			if(bc.isInCoverage(bx, by))
				bcB.add(bc);
		}
		
		int cmax = 0;
		for(int i=0;i<bcA.size();i++) {
			BC a = bcA.get(i);
			for(int j=0;j<bcB.size();j++) {
				BC b = bcB.get(j);
				
				if(a.index==b.index) {
					cmax = Math.max(cmax, a.performance);
				}else
					cmax = Math.max(cmax, a.performance+b.performance);
			}
		}
		if(bcA.size()>0) cmax = Math.max(cmax, bcA.get(0).performance);
		if(bcB.size()>0) cmax = Math.max(cmax, bcB.get(0).performance);
		
		max += cmax;
	}
	static void move(int time) {
		ax += dx[aList[time]];
		ay += dy[aList[time]];
		bx += dx[bList[time]];
		by += dy[bList[time]];
	}
}