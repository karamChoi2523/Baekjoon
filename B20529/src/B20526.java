import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20526 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		
		for(int idx=0;idx<t;idx++) {
			int n = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			if(n>32) {
				System.out.println("0");
				continue;
			}
			String[] s = new String[n];
			for(int i=0;i<n;i++)
				s[i] = st.nextToken();
			
			int min = 13;
			
			LOOP : for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++)
					for(int k=j+1;k<n;k++) {
						int sum=0;
						
						for(int l=0;l<4;l++) {
							if(s[i].charAt(l)!=s[j].charAt(l))
								sum += 1;
							if(s[i].charAt(l)!=s[k].charAt(l))
								sum += 1;
							if(s[j].charAt(l)!=s[k].charAt(l))
								sum += 1;
							
						}
						min = Math.min(min, sum);
						if(min == 0)
							break LOOP;
					}
			System.out.println(min);
		}
	}
}
