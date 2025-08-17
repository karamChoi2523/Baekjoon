import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] height;
	static int maxH;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			
			maxH = -1;
			for(int i=0;i<N;i++) {
				height[i] = Integer.parseInt(st.nextToken());
				if(maxH < height[i])
					maxH = height[i];
			}
			
			int even = 0, odd = 0;
			for(int i=0;i<N;i++) {
				int diff = maxH-height[i];
				
				if(diff==0) continue;
				
				even += diff/2;
				odd+=diff%2;
			}
			if(even>odd)
				while(Math.abs(even-odd)>1) {
					even--;
					odd+=2;
				}
			
			int day = 0;
			if(odd>even)
				day = odd*2 -1;
			else if(even>odd)
				day = even*2;
			else
				day = odd+even;
			System.out.printf("#%d %d\n", tc, day);
		}
	}
}
