import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] boxes = new int[n];
		int[] dp = new int[n];
		
		for(int i=0;i<n;i++){
			boxes[i] = Integer.valueOf(st.nextToken());
            dp[i]=1;
        }
        int max = 0;
        
        for(int i=1;i<n;i++) {
			for(int j=i-1;j>=0;j--) {
				if(boxes[j] < boxes[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}
