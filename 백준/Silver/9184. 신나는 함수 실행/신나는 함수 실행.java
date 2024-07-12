import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp = new int[21][21][21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			
			if(a==-1 && b==-1 && c==-1)
				break;
			
			int result=w(a,b,c);

			sb.append("w(" + a + ", " + b + ", " + c + ") = "+result+"\n");
		}
		System.out.println(sb.toString());
	}

	private static int w(int a, int b, int c) {
		if(a>=0 && a<=20)
			if(b>=0 && b<=20)
				if(c>=0 && c<=20)
					if(dp[a][b][c]!=0)
						return dp[a][b][c];
					
		if(a<=0 || b<=0 ||c<=0) {
			return 1;
		}
		
		if(a>20 || b>20 || c>20)
			return dp[20][20][20] = w(20,20,20);
		
		if(a<b && b<c)
			return dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		
		return dp[a][b][c] = w(a-1,b,c)+w(a-1, b-1, c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
	}

}
