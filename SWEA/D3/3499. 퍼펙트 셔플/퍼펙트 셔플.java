import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] arr = new String[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
				arr[i] = st.nextToken();
			
            System.out.printf("#%d ",tc);
            
			int i=0;
			int j = N%2==0?N/2:N/2+1;
			for(;i<N/2;i++) {
				System.out.print(arr[i]+" "+arr[j++]+" ");
			}
			if(N%2!=0)
				System.out.print(arr[i]);
			System.out.println();
		}
	}
}
