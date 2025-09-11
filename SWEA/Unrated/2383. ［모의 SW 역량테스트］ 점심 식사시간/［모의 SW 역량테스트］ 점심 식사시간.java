import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static ArrayList<Pos> person;
	static ArrayList<Stairs> stairs;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			person = new ArrayList<>();
			stairs = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int temp = Integer.parseInt(st.nextToken());
					
					if(temp==0) continue;
					if(temp==1)
						person.add(new Pos(i,j));
					else
						stairs.add(new Stairs(i,j,temp));
				}
			}
			
			//각 사람이 어느 계단을 이용할지에 대해 완탐
			
			min = Integer.MAX_VALUE;
			int[] select = new int[person.size()];
			pickStairs(0, select);
			
			System.out.printf("#%d %d\n",tc, min);
		}
	}
	private static void pickStairs(int idx, int[] select) {
		if(idx==select.length) {
			//System.out.println(Arrays.toString(select));
			PriorityQueue<Arrived> pq = new PriorityQueue<>();
			for(int i=0;i<person.size();i++) {
				Pos p = person.get(i);
				pq.add(new Arrived(p.x, p.y, i, stairs.get(select[i])));
			}
			for (Stairs s : stairs) {
			    s.remain = new ArrayList<>();
			}
			int res = sol(pq);
			min = Math.min(min, res);
			return;
		}
		
		for(int i=0;i<stairs.size();i++) {
			select[idx] = i;
			pickStairs(idx+1, select);
		}
	}
	private static int sol(PriorityQueue<Arrived> pq) {
		int time = 0;
		
		while(!pq.isEmpty()) {
			Arrived curr = pq.poll();
			if(time < curr.time)
				time = curr.time;
			
			ArrayList<Integer> remain = curr.s.remain;
			for(int i=remain.size()-1;i>=0;i--)
				if(remain.get(i)<=time)
					remain.remove(i);
			
			if(remain.size()<3)
				remain.add(time+curr.s.k);
			else pq.add(new Arrived(time+1, curr.s));
		}
		int last = time;
		for (Stairs s : stairs) {
		    if (!s.remain.isEmpty()) {
		        last = Math.max(last, s.remain.get(s.remain.size()-1));
		    }
		}
		return last;
	}
	static class Arrived implements Comparable<Arrived>{
		int time;
		int num;
		Stairs s;
		
		public Arrived(int x, int y, int num, Stairs s) {
			time = calMoving(x, y, s.x, s.y);
			this.s = s;
			this.num = num;
		}
		public Arrived(int time, Stairs s) {
			this.time = time;
			this.s = s;
		}
		
		public int calMoving(int px, int py, int sx, int sy) {
			return Math.abs(px-sx)+Math.abs(py-sy)+1;
		}
		
		@Override
		public int compareTo(Arrived o) {
			return this.time-o.time;
		}
	}
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Stairs{
		int x, y, k;
		ArrayList<Integer> remain;

		public Stairs(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
			remain = new ArrayList<>();
		}
	}
}
