import java.io.*;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.valueOf(st.nextToken());
		int S = Integer.valueOf(st.nextToken());	//시작
		int M = Integer.valueOf(st.nextToken());	//최대
	
		int[] V = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		boolean[][] dp = new boolean[N+1][M+1];
		dp[0][S] = true;
		
		for(int i=1;i<N+1;i++) {
			V[i] = Integer.valueOf(st.nextToken());
			
			for(int j=0;j<M+1;j++)
				if(dp[i-1][j]) {
					int plus = j+V[i];
					int minus = j-V[i];
					
					if(plus<=M) dp[i][plus] = true;
					if(minus>=0)dp[i][minus] = true;
				}
		}
		
		int answer = -1;
		for(int i=M;i>=0;i--) {
			if(dp[N][i]) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
