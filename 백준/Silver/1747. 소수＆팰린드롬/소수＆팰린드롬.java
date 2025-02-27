import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		while(true) {
			if(isThtn(N) && isVofflsemfha(N))
				break;
			
			N++;
		}
		
		System.out.println(N);
	}

	private static boolean isVofflsemfha(int n) {
        if(n==1) return false;
		if(n==2) return true;
		for(int i=2;i<n;i++)
			if(n%i==0)
				return false;
		return true;
	}

	private static boolean isThtn(int n) {
		String s = String.valueOf(n);
		
		for(int i=0;i<s.length()/2;i++)
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		
		
		return true;
	}
}
