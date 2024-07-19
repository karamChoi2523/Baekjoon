import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] list;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		list = new int[n];
		
		int total = 0;
		int max = 0;
		for(int i=0;i<n;i++) {
			list[i] = Integer.valueOf(st.nextToken());
			total += list[i];
			max = Math.max(max, list[i]);
		}
		int answer = binarySearch(max, total);
		System.out.println(answer);
	}

	private static int binarySearch(int start, int end) {
		while(start <= end) {
			int mid = (start+end)/2;	// 블루레이 크기
			
			int cnt=1;
			int sum=0;
			
			for(int i=0;i<list.length;i++) {
				if(sum+list[i] > mid) {
					cnt++;
					sum=0;
				}
				sum += list[i];
			}
			
			if(cnt > m)
				start = mid+1;
			else
				end = mid-1;
			
		}
		
		return start;
	}

}
