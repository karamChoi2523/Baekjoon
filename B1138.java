import java.util.ArrayList;
import java.util.Scanner;

public class B1138 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] list = new int[n];
		for(int i=0;i<n;i++)
			list[i] = sc.nextInt();
		
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=n;i>0;i--)
			res.add(list[i-1], i);
		
		for(int i=0;i<n;i++)
			System.out.print(res.get(i)+" ");
	}

}
