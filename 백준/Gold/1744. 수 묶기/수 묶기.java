import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		ArrayList<Integer> aList = new ArrayList<>();	//양수
		ArrayList<Integer> bList = new ArrayList<>();	//음수, 0
		
		for(int i=0;i<n;i++) {
			int a = Integer.valueOf(br.readLine());
			if(a<=0)
				bList.add(a);
			else
				aList.add(a);
		}
		Collections.sort(aList);
		Collections.sort(bList);
		
		int sum=0;
		
		if(aList.size()%2!=0)
			sum+=aList.get(0);
		
		for(int i=aList.size()-1;i>0;i-=2) {
			int a = aList.get(i);
			int b = aList.get(i-1);
			
			sum += Math.max(a*b, a+b);
		}
		if(bList.size()%2!=0)
			sum+=bList.get(bList.size()-1);
		
		for(int i=0;i<bList.size()-1;i+=2) {
			int a = bList.get(i);
			int b = bList.get(i+1);
			sum += a*b;
		}
		
		System.out.println(sum);
	}

}
