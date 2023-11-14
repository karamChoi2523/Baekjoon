import java.util.Scanner;
//그리디 알고리즘
public class B1541 {
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String[] arr = str.split("-");
		
		//for(String a : arr)
		//	System.out.println(a);
		
		if(str.charAt(0)=='-')
			ans-=solution(arr[0]);
		else
			ans+=solution(arr[0]);
		
		for(int i=1;i<arr.length;i++) {
			ans -= solution(arr[i]);
		}
		
		System.out.println(ans);
	}
	public static int solution(String test) {
		int res=0;
		
		if(test.contains("+")) {
			String[] arr = test.split("\\+");
			for(int i=0;i<arr.length;i++)
				res += Integer.valueOf(arr[i]);
			return res;
		} else return Integer.valueOf(test);
	}

}
