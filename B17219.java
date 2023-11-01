import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B17219 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hMap = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			
			String address = st.nextToken();
			String pw = st.nextToken();
			
			hMap.put(address, pw);
		}
		
		for(int i=0;i<m;i++) {
			String find = bf.readLine();
			
			sb.append(hMap.get(find)).append('\n');
		}
		
		System.out.println(sb);
	}

}
