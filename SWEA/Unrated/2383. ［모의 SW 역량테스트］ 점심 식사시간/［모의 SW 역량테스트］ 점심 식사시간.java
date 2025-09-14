import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] select;
	static ArrayList<Person> pList;
	static int cnt;
	static int[][] stairs;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<>();
			stairs = new int[2][];
			for(int i=0, k=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int temp = Integer.parseInt(st.nextToken());
					
					if(temp==0) continue;
					if(temp==1) pList.add(new Person(i,j,0));
					else stairs[k++] = new int[] {i,j,temp};
				}
			}
			
			res = Integer.MAX_VALUE;
			cnt = pList.size();
			select = new int[cnt];
			subset(0);
			
			System.out.printf("#%d %d\n",tc, res);
		}
	}
	private static void subset(int idx) {
		if(idx == cnt) {
			run();
			return;
		}
		
		select[idx] = 1;
		subset(idx+1);
		
		select[idx] = 0;
		subset(idx+1);
	}
	private static void run() {
		ArrayList<Person> listA = new ArrayList<>();
		ArrayList<Person> listB = new ArrayList<>();
		
		for(int i=0;i<cnt;i++) {
			Person p = pList.get(i);
			int no = select[i];
			
			p.time = p.calTime(stairs[no][0], stairs[no][1]);
			
			if(no==0)
				listA.add(p);
			else
				listB.add(p);
		}

		int timeA = goDown(listA, stairs[0][2]);
		int timeB = goDown(listB, stairs[1][2]);
		
		res = Math.min(res, Math.max(timeA, timeB));
	}
	private static int goDown(ArrayList<Person> list, int k) {
		if(list.size()==0) return 0;
		
		Collections.sort(list);
		
		int size = list.size()+3;
		int[] D = new int[size];
		
		for(int i=3;i<size;i++) {
			Person p = list.get(i-3);
			if(D[i-3] <= p.time+1)
				D[i] = p.time+1+k;
			else
				D[i] = D[i-3]+k;
		}
		
		return D[size-1];
	}
	static class Person implements Comparable<Person>{
		int x, y, time;

		public Person(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
		public int calTime(int x, int y) {
			return Math.abs(this.x-x)+Math.abs(this.y-y);
		}

		@Override
		public int compareTo(Person o) {
			return this.time - o.time;
		}
	}
}
