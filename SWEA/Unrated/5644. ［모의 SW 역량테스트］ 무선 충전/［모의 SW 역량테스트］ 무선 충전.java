import java.io.*;
import java.util.*;

public class Solution {
	static class BC implements Comparable<BC>{
		int x, y;
		int coverage;
		int performance;
		
		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			coverage = c;
			performance = p;
		}
		
		@Override
		public int compareTo(BC o) {
			return o.performance-this.performance;
		}
	}
	static int M, A;
	static int[][] board;
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
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			board = new int[11][11];
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
			
				bcList.add(new BC(x,y,c,p));
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
	static class State{
		int index;
		int p;
		
		public State(int i, int p) {
			index = i;
			this.p = p;
		}
	}
	static void calCoverage() {
		ArrayList<State> ca = new ArrayList<>();
		ArrayList<State> cb = new ArrayList<>();
		
		for(int i=0;i<bcList.size();i++) {
			BC bc = bcList.get(i);
			if(isInCoverage(bc,ax, ay))
				ca.add(new State(i, bc.performance));
			if(isInCoverage(bc, bx, by))
				cb.add(new State(i,bc.performance));
		}
		
		int cmax = 0;
		for(int i=0;i<ca.size();i++) {
			State pa = ca.get(i);
			for(int j=0;j<cb.size();j++) {
				State pb = cb.get(j);
				
				if(pa.index==pb.index) {
					cmax = Math.max(cmax, pa.p);
				}else
					cmax = Math.max(cmax, pa.p+pb.p);
			}
		}
		if(ca.size()>0) cmax = Math.max(cmax, ca.get(0).p);
		if(cb.size()>0) cmax = Math.max(cmax, cb.get(0).p);
		
		max += cmax;
	}
	static void move(int time) {
		ax += dx[aList[time]];
		ay += dy[aList[time]];
		bx += dx[bList[time]];
		by += dy[bList[time]];
	}
	static boolean isInCoverage(BC bc, int x, int y) {
		return Math.abs(bc.x-x)+Math.abs(bc.y-y)<=bc.coverage;
	}
}
