import java.util.*;
import java.io.*;

public class Solution {
	static class Pos{
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Pos> posList;
	static int[] select;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Pos company = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Pos home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			posList = new ArrayList<>();
			for(int i=0;i<N;i++) {
				Pos customer = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				posList.add(customer);
			}
			
			select = new int[N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			permutation(0, N, company, home);
			
			System.out.printf("#%d %d\n",tc, min);
		}
	}
	static void permutation(int idx, int len, Pos company, Pos home) {
		if(idx==len) {
			int dist = 0;
			Pos pre = company;
			for(int i=0;i<len;i++) {
				Pos curr = posList.get(select[i]);
				dist += Math.abs(pre.x-curr.x)+Math.abs(pre.y-curr.y);
				pre = curr;
			}
			Pos curr = home;
			dist += Math.abs(pre.x-curr.x)+Math.abs(pre.y-curr.y);
			
			min = Math.min(min, dist);
			return;
		}
		
		for(int i=0;i<len;i++) {
			if(!visited[i]) {
				visited[i] = true;
				select[idx] = i;
				permutation(idx+1, len, company, home);
				visited[i] = false;
			}
		}
	}
}