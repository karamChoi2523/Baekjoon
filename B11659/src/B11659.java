import java.util.Scanner;

public class B11659 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] list = new int[n];
		int[] memo = new int[n];
		
		for(int i=0;i<n;i++) {
			list[i] = sc.nextInt();
			if(i==0)
				memo[0] = list[0];
			else
				memo[i] = memo[i-1]+list[i];
		}
		for(int i=0;i<m;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			int res=0;
			if(start!=1)
				res = memo[end-1]-memo[start-2];
			else
				res = memo[end-1];
			
			System.out.println(res);
		}
	}
}