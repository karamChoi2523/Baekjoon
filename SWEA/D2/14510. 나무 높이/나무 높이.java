import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			int max = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			
			int even = 0;
			int odd = 0;
			for(int i=0;i<N;i++) {
				int diff = max-tree[i];
				
				if(diff==0) continue;
				
				even += diff/2;
				odd += diff%2;
			}
			
			int min = Math.min(even, odd);
			
			int day = min*2;
			
			even -= min;
			odd -= min;
			
			if(odd>0)
				day += odd*2-1;
			if(even>0)
				day += even+1+(even-1)/3;			
			
			System.out.printf("#%d %d\n", tc, day);
		}
	}
}
