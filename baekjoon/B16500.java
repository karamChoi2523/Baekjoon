import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class B16500 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		int n = sc.nextInt();
		sc.nextLine();
		
		Set<String> aList = new HashSet<>();
		int[] dp = new int[101];
		
		for(int i=0;i<n;i++)
			aList.add(sc.nextLine());
		
		for(int i=s.length()-1;i>=0;i--) {
			for(int j=i+1;j<s.length();j++)
				if(dp[j]==1 && aList.contains(s.substring(i, j)))
					dp[i]=1;
			if(aList.contains(s.substring(i)))
					dp[i]=1;
		}
		
		System.out.println(dp[0]);
	}

}
