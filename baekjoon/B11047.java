import java.util.Scanner;

public class B11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] list = new int[n];
		
		for(int i=0;i<n;i++) {
			list[i] = sc.nextInt();
		}
		
		int cnt=0;
		
		for(int i=n-1;i>=0;i--) {
			if(k/list[i]!=0) {
				cnt+=k/list[i];
				k-=(list[i]*(k/list[i]));	//k%list[i]
			}
			
			if(k==0)
				break;
		}
		System.out.println(cnt);
	}

}
