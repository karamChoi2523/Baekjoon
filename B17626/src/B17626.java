import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B17626 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		int dp[] = new int[50001];
		dp[0] = 0;
		
		for(int i=1;i<n+1;i++) {
			dp[i] = dp[i-1]+1;
			
			for(int j=1;j*j<=i;j++)
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
		}
		
		bw.write(String.valueOf(dp[n]));
		
		bw.close();
		bf.close();
	}

}
