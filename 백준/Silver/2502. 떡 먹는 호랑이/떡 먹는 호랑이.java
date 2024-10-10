import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] arr = br.readLine().split(" ");

		int D = Integer.valueOf(arr[0]);
		int K = Integer.valueOf(arr[1]);
		int[] dp = new int[D+1];
		
		for(int i=1;i<=K/2;i++) {
			for(int j=i+1;j<K;j++) {
				dp[1] = i;
				dp[2] = j;
				
				for(int k=3;k<D+1;k++)
					dp[k] = dp[k-1]+dp[k-2];
				if(dp[D]==K) {
					System.out.println(dp[1]);
					System.out.println(dp[2]);
					return;
				}
			}
		}
	}
}
