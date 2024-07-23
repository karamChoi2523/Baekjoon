import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end)
				return this.start - o.start;
			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		ArrayList<Meeting> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			list.add(new Meeting(a, b));
		}
		Collections.sort(list);
		
		int cnt = 1;
		Meeting pre = list.get(0);
		
		for(int i=1;i<n;i++) {
			Meeting curr = list.get(i);
			if(curr.start >= pre.end) {
				pre = curr;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
