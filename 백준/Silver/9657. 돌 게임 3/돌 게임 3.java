import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		String[] dp = new String[n+6];
        dp[0] = "SK";
		dp[1] = "SK";
		dp[2] = "CY";
		dp[3] = "SK";	
		dp[4] = "SK";
		
		for(int i=5;i<n+1;i++) {
			String[] checked = new String[3];
			checked[0] = dp[i-1];
			checked[1] = dp[i-3];
			checked[2] = dp[i-4];
			
			boolean check = false;
			for(String e : checked) {
				if(e.equals("CY")){
					check = true;
                    break;
                }
			}
			
			if(check)
				dp[i] = "SK";
			else
				dp[i] = "CY";
		}
		
		System.out.println(dp[n]);
	}

}
