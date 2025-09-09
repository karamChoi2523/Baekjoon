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
			res[0] = arr[0];
			for(int i=1;i<N;i++) {
				if(res[idx] < arr[i])
					res[++idx] = arr[i];
				else {
					int index = Arrays.binarySearch(res, 0, idx+1, arr[i]);
					if(index<0) res[index*-1-1] = arr[i];
					else res[index] = arr[i];
				}				
			}
			
			System.out.printf("#%d %d\n", tc, idx+1);
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
