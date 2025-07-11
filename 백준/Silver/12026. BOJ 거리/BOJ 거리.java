import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int[] dp = new int[n];
		Arrays.fill(dp, (int)1e9);
		dp[0] = 0;
		
		for(int i=1;i<s.length();i++) {
			for(int j=0;j<i;j++) {
				if(dp[j]!=(int)1e9) {
					if((s.charAt(i)=='O' && s.charAt(j)=='B')
							||(s.charAt(i)=='J' && s.charAt(j)=='O')
							||(s.charAt(i)=='B' && s.charAt(j)=='J'))
						dp[i] = Math.min(dp[i], dp[j]+(j-i)*(j-i));
				}
			}
		}
		System.out.println(dp[n-1]==(int)1e9?-1:dp[n-1]);
	}

}