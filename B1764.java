import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		TreeSet<String> larger = new TreeSet<>();
		TreeSet<String> result = new TreeSet<>();

		int big = n>m? n: m;
		int small = big==n? m:n;
		
		for(int i=0;i<big;i++)
			larger.add(bf.readLine());
		
		for(int i=0;i<small;i++) {
			String s = bf.readLine();
			if(larger.contains(s))
				result.add(s);
		}
		System.out.println(result.size());
		for(String e : result)
			System.out.println(e);
			
	}

}
