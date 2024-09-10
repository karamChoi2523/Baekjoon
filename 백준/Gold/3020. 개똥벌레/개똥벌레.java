import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		h = Integer.valueOf(st.nextToken());
		
		int[] down = new int[n/2];
		int[] up = new int[n/2];
		
		for(int i=0;i<n/2;i++) {
			int a = Integer.valueOf(br.readLine());
			int b = Integer.valueOf(br.readLine());
						
			down[i] = a;
			up[i] = b;
		}
		Arrays.sort(up);
		Arrays.sort(down);
		
		int min = n;
		int res = 0;
		
		for(int i=0;i<h;i++) {
			int conflict = binarySearch(0, n/2, i, down) + binarySearch(0, n/2, h-i+1, up);
		
			if(min == conflict) {
				res++;
				continue;
			}
			
			if(min>conflict) {
				min = conflict;
				res = 1;
			}
		}
		
		System.out.println(min+" "+res);
	}

	private static int binarySearch(int start, int end, int h, int[] arr) {
		while(start<end) {
			int mid = (start+end)/2;
			
			if(arr[mid]>=h) {
				end = mid;
			}else
				start = mid+1;
		}
		
		return arr.length-end;
	}

}
