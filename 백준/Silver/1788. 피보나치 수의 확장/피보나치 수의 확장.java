import java.io.*;

public class Main {
	static int mod = (int)1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		long[] dp = new long[1000005];	//양수
		long[] dp2 = new long[1000005];	//음수
		
		dp[0] = 0;
		dp[1] = 1;
		dp2[0] = 0;
		dp2[1] = 1;
		dp2[2] = -1;
		
		long res;
		
		if(n<0) {
			int na = Math.abs(n);
			for(int i=0;i<na;i++)
				dp2[i+2] = dp2[i]%mod-dp2[i+1]%mod;
			res = dp2[na]%mod;
		}else {
			for(int i=2;i<=n;i++)
				dp[i] = dp[i-1]%mod+dp[i-2]%mod;
			res = dp[n]%mod;
		}
		
		if(res<0)
			System.out.println(-1);
		else if(res==0)
			System.out.println(0);
		else
			System.out.println(1);
		
		System.out.println(Math.abs(res));
	}

}
