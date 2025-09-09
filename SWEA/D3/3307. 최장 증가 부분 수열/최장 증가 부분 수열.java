import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			initialize(br);
			
			int[] res = new int[N];
			
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
	static void initialize(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
	}
}
