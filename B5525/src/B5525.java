import java.util.Scanner;

public class B5525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		
		int cnt=0;
		int res=0;
		
		for(int i=1;i<m-1;) {
			if(s.charAt(i)=='O' && s.charAt(i+1)=='I') {
				cnt++;
				if(cnt==n) {
					if(s.charAt(i-(cnt*2-1))=='I')
						res++;
					cnt--;
				}
				i+=2;
			}else {
				cnt=0;
				i++;
			}
		}
		
		System.out.println(res);
	}

}
