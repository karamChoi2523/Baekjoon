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

			if(binarySearch(s, 0, n - 1))
				cnt++;
		}
		System.out.println(cnt);
	}
	
	private static boolean binarySearch(String target, int start, int end) {
		while(start<=end) {
			int mid = (start+end)/2;
			String s = first.get(mid);
			
			if(s.startsWith(target)) {
				return true;
			}
			
			if(s.compareTo(target)<0) {
				if(binarySearch(target, mid+1, end))
					return true;
				else
					return false;
			}else
				if(binarySearch(target, start, mid-1))
					return true;
				else
					return false;
		}
		
		return false;
	}

}
