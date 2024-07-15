import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int min = Integer.MAX_VALUE;
    static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 Integer n = Integer.parseInt(bf.readLine());
		 dp=new int[n+1];
        
       
        dp[1]=0;
        if(n>1)dp[2]=1;
        if(n>2)dp[3]=1;
        
        for(int i=4;i<n+1;i++){
            dp[i] = dp[i-1]+1;
            if(i%3==0)
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            if(i%2==0)
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
        
       
         
        System.out.println(dp[n]);
        
		
	}
	
	
}