import java.io.*;
import java.util.*;

public class Main {
	static int m, n;
	static ArrayList<String> first;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		first = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			first.add(br.readLine());
		}

		Collections.sort(first);

		for (int i = 0; i < m; i++) {
			String s = br.readLine();

			if(binarySearch(s))
				cnt++;
		}
		System.out.println(cnt);
	}
	
	private static boolean binarySearch(String target) {
		int start = 0, end = n-1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			String s = first.get(mid);
			
			if(s.startsWith(target)) {
				return true;
			}
			
			if(s.compareTo(target)<0) {
				start = mid+1;
			}else
				end = mid-1;
		}
		
		return false;
	}

}
