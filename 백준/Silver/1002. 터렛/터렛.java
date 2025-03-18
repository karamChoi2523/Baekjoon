import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			System.out.println(solution(x1, y1, r1, x2, y2, r2));
		}	
	}

	private static int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
		int dist_pow = (int)(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
		
		if(x1==x2 && y1==y2 && r1==r2) return -1;
		
		if(dist_pow > Math.pow(r1+r2, 2)) return 0;
		
		if(dist_pow < Math.pow(r1-r2, 2)) return 0;
		
		if(dist_pow == Math.pow(r1-r2, 2)) return 1;
		
		if(dist_pow == Math.pow(r1+r2, 2)) return 1;
		
		return 2;		
	}
}
