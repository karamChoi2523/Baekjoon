import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		String[] list = new String[n];
		
		for(int i=0;i<n;i++)
			list[i] = br.readLine();
		
		Arrays.sort(list);
	
		int cnt=0;
		for(int i=0;i<n;i++) {
			boolean check = false;
			for(int j=i+1;j<n;j++) {
				if(list[j].startsWith(list[i])) {
					check = true;
					break;
				}
			}
			
			if(check)
				continue;
			cnt++;
		}
		System.out.println(cnt);
	}
}
