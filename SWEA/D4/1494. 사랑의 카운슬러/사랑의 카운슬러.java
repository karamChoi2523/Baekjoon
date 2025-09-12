import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static long min;
	static ArrayList<Stuff> stuffs;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {

			N = Integer.parseInt(br.readLine());
			stuffs = new ArrayList<>();

			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				stuffs.add(new Stuff(x, y));
			}
			
			min = Long.MAX_VALUE;
			visited = new boolean[N];
			pick(0, 0);
			
			System.out.printf("#%d %d\n",tc, min);
		}
	}
	private static void pick(int idx, int cnt) {
		if(cnt==N/2) {
			long dx = 0;
			long dy = 0;
			
			for(int i=0;i<N;i++) {
				Stuff s = stuffs.get(i);
				if(visited[i]) {
					dx += s.x;
					dy += s.y;
				}else {
					dx -= s.x;
					dy -= s.y;
				}
			}
			min = Math.min(min, dx*dx+dy*dy);
			return;
		}
		if(idx==N) return;
		
		visited[idx] = true;
		pick(idx+1, cnt+1);
		
		visited[idx] = false;
		pick(idx+1, cnt);
	}
	static class Stuff{
		int x, y;

		public Stuff(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
