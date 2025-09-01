import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			int maxH = -1;
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(maxH < arr[i])
					maxH = arr[i];
			}
			
			int even = 0;
			int odd = 0;
			for(int i=0;i<N;i++) {
				int diff = maxH - arr[i];
				
				if(diff==0) continue;
				
				even += diff/2;
				odd += diff%2;
			}
			
			int min = Math.min(even, odd);
			even -= min;
			odd -= min;
			
			int day = min*2;
			
			if(odd>0) {
				day += 2*odd-1;
			}
			
			if(even>0){
				day += even+1+(even-1)/3;
			}
			
			System.out.printf("#%d %d\n",tc,day);
		}
	}
}
