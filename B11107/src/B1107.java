import java.util.ArrayList;
import java.util.Scanner;

public class B1107 {
	static ArrayList<Integer> list;
	static int cnt;
	static int n;
	
	static void solution(int a, String num) {
		for(int i=0;i<10;i++) {
			if(!list.contains(i)) {
				String newNum = num+String.valueOf(i);
				int count = Math.abs(n-Integer.parseInt(newNum))+newNum.length();
				cnt = cnt>count? count:cnt;
				if(a<6)
					solution(a+1, newNum);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		list = new ArrayList<>();
		
		for(int i=0;i<m;i++)
			list.add(sc.nextInt());
		
		if(n==100)
			System.out.println(0);
		else {
			cnt = Math.abs(100-n);	//100에서 이동
			solution(0, "");
			System.out.println(cnt);
		}
	}

}
