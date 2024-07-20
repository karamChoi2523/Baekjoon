import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		arr = new long[m];
		long max = -1;
		for(int i=0;i<m;i++) {
			arr[i] = Integer.valueOf(br.readLine());
			max = Math.max(max, arr[i]);
		}
		long answer = binarySearch(0, max);
		
		System.out.println(answer);
	}

	private static long binarySearch(long start, long end) {
		while(start <= end) {
			long mid = (start+end)/2;
			if(mid==0)
				return end;
			
			int cnt = 0;	//몇 명?
			for(int i=0;i<m;i++) {
				cnt+=arr[i]/mid;
				
				if(arr[i]%mid!=0)
					cnt++;
			}
			
			if(cnt > n)
				start = mid +1;
			else
				end = mid - 1;
		}
		
		return start;
	}

}
