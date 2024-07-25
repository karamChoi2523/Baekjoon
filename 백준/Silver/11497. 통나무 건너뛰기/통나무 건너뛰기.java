import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		
		while(t-->0) {
			int n = Integer.valueOf(br.readLine());
			
			int[] list = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
				list[i] = Integer.valueOf(st.nextToken());
			
			Arrays.sort(list);
			
			int[] answer = new int[n];
			
			int idx=0;
			for(int i=0;i<=n/2;i++,idx+=2) {
				if(idx >= n)
					break;
				answer[i] = list[idx];
				if(idx+1 >= n)
					break;
				answer[n-1-i] = list[idx+1];
			}
			
			int max=Math.abs(answer[0]-answer[n-1]);
			
			for(int i=0;i<n-1;i++)
				max = Math.max(max, Math.abs(answer[i]-answer[i+1]));
			
			System.out.println(max);
		}
	}

}
