import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] list;
	static long[] ans = new long[2];
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		list = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			list[i] = Long.valueOf(st.nextToken());
		
		Arrays.sort(list);
		
		if(list[0]>=0)
			System.out.println(list[0]+" "+list[1]);
		else if(list[n-1]<=0)
			System.out.println(list[n-2]+" "+list[n-1]);
		else {
			binarySearch(0, n-1);
			Arrays.sort(ans);
			
			System.out.println(ans[0]+" "+ans[1]);
		}
		
	}

	private static void binarySearch(int start, int end) {
		while(start<end) {
			long total = list[start]+list[end];
			
			if(total == 0) {
				min = total;
				ans[0] = list[start];
				ans[1] = list[end];
				
				break;
			}else if(Math.abs(total) > Math.abs(min)) {
                long a;
				long b;
				
				a = list[start+1]+list[end];
				b = list[start]+list[end-1];
				
				if(Math.abs(a) < Math.abs(b))
					start++;
				else
					end--;
			}else {
				min = total;
				ans[0] = list[start];
				ans[1] = list[end];
				
				start++;
			}
		}
		
	}

}
