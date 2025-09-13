import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			int[] res = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int idx = 0;
			for(int i=0;i<N;i++) {
				int index = Arrays.binarySearch(res, 0, idx, arr[i]);
				index = index<0?index*-1-1:index;
				
				res[index] = arr[i];
				if(index==idx)
					idx++;
			}
			System.out.printf("#%d %d\n", tc, idx);
		}
	}
}
