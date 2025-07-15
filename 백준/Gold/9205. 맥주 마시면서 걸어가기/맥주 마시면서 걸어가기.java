import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.add(new int[] {x, y});
			}
			
			bfs(list);
		}
		System.out.println(sb.toString());
	}

	private static void bfs(ArrayList<int[]> list) {
		int[] start = list.get(0);
		int[] end = list.get(list.size()-1);
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start[0], start[1], 20});
		
		boolean[] visited = new boolean[list.size()];
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cx = curr[0];
			int cy = curr[1];
			int beer = curr[2];
			
			if(cx==end[0]&&cy==end[1]) {
				sb.append("happy\n");
				return;
			}
			
			for(int i=1;i<list.size();i++) {
				int nx = list.get(i)[0];
				int ny = list.get(i)[1];
				int cost = Math.abs(cx-nx)+Math.abs(cy-ny);
				
				int need = cost%50==0?cost/50:cost/50+1;
				if(!visited[i] && need<=beer) {
					visited[i] = true;
					q.add(new int[] {nx, ny, 20});
				}
			}
		}
		sb.append("sad\n");
		return;
	}
}