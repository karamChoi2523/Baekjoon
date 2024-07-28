import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[] list = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			list[i] = Integer.valueOf(st.nextToken());
		
		Arrays.sort(list);
		
		if(list[0] >=0)
			System.out.println(list[0]+" "+list[1]);
		else if(list[n-1] <=0)
			System.out.println(list[n-2]+" "+list[n-1]);
		else {
			int min = Integer.MAX_VALUE;
			int start = 0;
			int end = n-1;
			
			int first=-1, second=-1;
			
			while(start < end) {
				int sum = list[start] + list[end];
				
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					
					first = list[start];
					second = list[end];
					
					if(sum==0)
						break;
				}
				
				if(sum < 0)
					start++;
				else
					end--;
			}
			
			System.out.println(first+" "+second);
		}
	}

}
