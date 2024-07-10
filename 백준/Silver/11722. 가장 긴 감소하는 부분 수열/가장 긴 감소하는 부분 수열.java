import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int[] list = new int[n];
		int[] d = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n ;i++) {
			list[i] = Integer.valueOf(st.nextToken());
			d[i] = 1;
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<i;j++)
				if(list[j]>list[i])
					d[i] = Math.max(d[i], d[j]+1);
		
		int max = 0;
		for(int e : d)
			max = Math.max(e, max);
		
		System.out.println(max);
	}

}
