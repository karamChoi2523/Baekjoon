import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		
		boolean[] fixedList = new boolean[n+1];
		int[] dp = new int[n+1];
		
		for(int i=0;i<m;i++) {
			int a = Integer.valueOf(br.readLine());
			fixedList[a] = true;
		}
		
		dp[1] = 1;
		
		if(n>1) {
			if(!fixedList[2]&&!fixedList[1])
				dp[2] = 2;
			else
				dp[2] =1;
		}
				
		for(int i=3;i<n+1;i++) {
			if(!fixedList[i] && !fixedList[i-1]) {
				dp[i] = dp[i-1]+dp[i-2];
			}else
				dp[i] = dp[i-1];
		}
		System.out.println(dp[n]);
	}

}
