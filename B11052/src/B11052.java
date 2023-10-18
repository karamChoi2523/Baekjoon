import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		int[] price = new int[10001];
		int[] result = new int[10001];
		
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);

		for(int i=1;i<=n;i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=i;j++)
				result[i] = Math.max(result[i], result[i-j]+price[j]);
		
		bw.write(String.valueOf(result[n]));
		bw.flush();
		bw.close();
	}
	
}
