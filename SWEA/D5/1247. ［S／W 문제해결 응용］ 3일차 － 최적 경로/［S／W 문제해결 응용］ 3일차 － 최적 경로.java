import java.io.*;
import java.util.*;


public class Solution {
	static int N;
	static Point company;
	static Point home;
	static int min = Integer.MAX_VALUE;
	static List<Point> customers;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		//int T = 10;
		for(int tc=1;tc<=T;tc++) {
			initialize(br);
			
			permutation(0,0,company);

			System.out.printf("#%d %d\n",tc,min);
		}
	}
	static void permutation(int idx, int sum, Point pre) {
		if(idx==N) {
			sum += home.calDist(pre.x, pre.y);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				Point cus = customers.get(i);
				permutation(idx+1, sum+cus.calDist(pre.x, pre.y), cus);
				visited[i] = false;
			}
		}
	}
	private static void initialize(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		company = new Point(x, y);
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		home = new Point(x, y);
		
		customers = new ArrayList<>();
		while(st.hasMoreTokens()) {
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			customers.add(new Point(x, y));
		}
		
		min = Integer.MAX_VALUE;
		visited = new boolean[N];
	}
	static class Point{
		int x, y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int calDist(int x, int y) {
			return Math.abs(this.x-x)+Math.abs(this.y-y);
		}
	}
}
