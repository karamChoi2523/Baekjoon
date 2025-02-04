import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> U, sumList;
	static int n, maxD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());
		U = new ArrayList<>();
		sumList = new ArrayList<>();
		
		for(int i=0;i<n;i++)
			U.add(Integer.valueOf(br.readLine()));
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				sumList.add(U.get(i)+U.get(j));
		
		Collections.sort(U);
		Collections.sort(sumList);
		
		//x+y = k-z
		for(int i=n-1;i>=0;i--)
			for(int j=n-1;j>=0;j--) {
				int minus = U.get(i)-U.get(j);
				
				//sumList에서 minus를 찾는다
				if(Collections.binarySearch(sumList, minus)>=0) {
					System.out.println(U.get(i));
					return;
				}
			}
	}
}
