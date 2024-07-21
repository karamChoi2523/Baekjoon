import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int[] list;
	static int x;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		while(true) {
			String s = br.readLine();
			if(s == null)
				break;
			
			x = Integer.valueOf(s)*10000000;
			n = Integer.valueOf(br.readLine());
					
			list = new int[n];
			for(int i=0;i<n;i++) {
				list[i] = Integer.valueOf(br.readLine());
			}
			Arrays.sort(list);
			
			
			binarySearch(0, n-1);
		}
	}

	private static void binarySearch(int start, int end) {
		boolean check = false;
		while(start < end) {
			int total = list[start] + list[end];
			
			if(total == x) {
				System.out.println("yes "+list[start]+" "+list[end]);
				check = true;
				break;
			}else if(total > x)
				end--;
			else
				start++;
		}
		
		if(!check)
			System.out.println("danger");
	}

}
