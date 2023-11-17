import java.util.Scanner;

public class EditorialDist {
	//Levenshtein distance(LD)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		System.out.println(editDist(a,b));
	}

	private static int editDist(String a, String b) {
		int n = a.length();
		int m = b.length();
		
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1;i<n+1;i++)
			dp[i][0] = i;

		for(int i=1;i<n+1;i++)
			dp[0][i] = i;
		
		for(int i=1;i<n+1;i++)
			for(int j=1;j<m+1;j++) {
				if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j] = dp[i - 1][j - 1];
				else	//»ðÀÔ(ÁÂÃø), »èÁ¦(»ó´Ü), ±³Ã¼(ÁÂ»ó´Ü)
					dp[i][j] = Math.min(dp[i][j-1],  Math.min(dp[i - 1][j], dp[i - 1][j - 1]))+1;
			}
		
		return dp[n][m];
	}

}
