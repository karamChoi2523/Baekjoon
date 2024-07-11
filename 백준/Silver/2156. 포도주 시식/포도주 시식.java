import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n  = Integer.valueOf(br.readLine());
		
		int[] list = new int[n+1];
		int[] d = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			list[i] = Integer.valueOf(br.readLine());
		}
		d[1] = list[1];
		
		if(n>1)
			d[2] = list[1]+list[2];
		
		for(int i=3;i<n+1;i++) {
			d[i] = Math.max(d[i-1], Math.max(d[i-2]+list[i], d[i-3]+list[i-1]+list[i]));
		}
		
		System.out.println(d[n]);
	}

}
