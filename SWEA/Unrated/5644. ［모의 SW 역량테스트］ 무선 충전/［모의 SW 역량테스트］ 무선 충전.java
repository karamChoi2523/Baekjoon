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
	static int max = 0;
	static int[][] board;
	static int M, A;
	static int[] aList;
	static int[] bList;
	static ArrayList<BC> bcList;
	
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};
	
	static int ax = 1, ay = 1;
	static int bx = 10, by = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			board = new int[11][11];
			max = 0;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //총 이동 시간
			A = Integer.parseInt(st.nextToken()); //BC 개수
			
			aList= new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<M+1;i++)
				aList[i] = Integer.parseInt(st.nextToken());

			bList= new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<M+1;i++)
				bList[i] = Integer.parseInt(st.nextToken());
			
			bcList = new ArrayList<>();
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
						
			for(int time=0;time<M+1;time++) {
				move(time);
				coverage();
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
	static void coverage() {
		ArrayList<State> sa = new ArrayList<>();
		ArrayList<State> sb = new ArrayList<>();
		
		
		for(int i=0;i<bcList.size();i++) {
			BC bc = bcList.get(i);
			if(isInCoverage(bc, ax, ay))
				sa.add(new State(i, bc.performance));
			if(isInCoverage(bc, bx, by))
				sb.add(new State(i, bc.performance));
		}
		//1. 반반 먹기
		//2. a만 먹기
		//3. b만 먹기
		
		int cmax = 0;
		
		if(sa.size()>0 && sb.size()>0)
			for(int i=0;i<sa.size();i++) {
				State ca = sa.get(i);
				for(int j=0;j<sb.size();j++) {
					State cb = sb.get(j);
					
					if(ca.index==cb.index)
						cmax = Math.max(ca.p, cmax);
					else
						cmax = Math.max(ca.p+cb.p, cmax);
				}
			}
		for(int i=0;i<sa.size();i++)
			cmax = Math.max(cmax, sa.get(i).p);
		
		for(int i=0;i<sb.size();i++)
			cmax = Math.max(cmax, sb.get(i).p);
		max+=cmax;
	}
	static void move(int time) {
		int dir = aList[time];
		ax+=dx[dir];
		ay+=dy[dir];
		dir = bList[time];
		bx+=dx[dir];
		by+=dy[dir];
	}
	static boolean isInCoverage(BC bc, int x, int y) {
		return (Math.abs(bc.x-x)+Math.abs(bc.y-y)) <= bc.coverage;
	}
}
