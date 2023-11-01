import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B11727 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Integer col = Integer.parseInt(bf.readLine());
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		int[] memo = new int[1001];
		memo[1]=1;
		memo[2]=3;
		memo[3]=5;
		
		for(int i=4;i<=col;i++) {
			memo[i] = (2*memo[i-2]+memo[i-1])%10007;
		}
		bw.write(String.valueOf(memo[col]));
		bw.flush();
		bw.close();
	}

}
