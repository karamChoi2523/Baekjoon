import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		long m = Integer.parseInt(bf.readLine());
		
		int bitSet = 0;
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			String c = st.nextToken();
			int x=0;
			if(!c.equals("all") && !c.equals("empty"))
				x = Integer.parseInt(st.nextToken());
						
			switch(c) {
			case "add":
				bitSet |= (1<<(x-1));
				break;
			case "remove":
				bitSet = bitSet & ~(1<<(x-1));
				break;
			case "check":
				sb.append((bitSet & (1<<(x-1))) != 0 ? "1\n":"0\n");
				break;
			case "toggle":
				bitSet ^= (1<<(x-1));
				break;
			case "all":
				bitSet|= (~0);
				break;
			case "empty":
				bitSet &= 0;
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		bf.close();
	}

}
