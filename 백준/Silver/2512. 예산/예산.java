import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.valueOf(st.nextToken());
            max = Math.max(max, arr[i]);
		}
		long m = Integer.valueOf(br.readLine());
		
		int answer = binarySearch(arr, m, 0, max);
		
		System.out.println(answer);
	}

	private static int binarySearch(int[] arr, long target, int start, int end) {
		while(start <= end) {
    		int mid = (start+end)/2;	//상한선
	    	
		    long total = 0;
		    for(int i=0;i<arr.length;i++)
			    total += arr[i]>mid?mid:arr[i];
            
			if(total <= target)
			    start = mid+1;
			else if(total > target)
				end = mid-1;
		}
		
		return end;
	}

}
