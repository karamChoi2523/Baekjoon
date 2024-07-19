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
		for(int i=0;i<n;i++) {
			list[i] = Integer.valueOf(st.nextToken());
			total += list[i];
		}
		int answer = binarySearch(0, total);
		System.out.println(answer);
	}

	private static int binarySearch(int start, int end) {
		while(start <= end) {
			int mid = (start+end)/2;	// 블루레이 크기
			
			int cnt=0;
			int sum=0;
			boolean check = false;
			for(int i=0;i<list.length;i++) {
				if(cnt > m)
					break;
				
				sum += list[i];
				if(sum >= mid) {
					i--;
					cnt++;
					sum=0;
					check = true;
				}else
					check = false;
			}
			if(!check)
				cnt++;
			
			if(cnt > m)
				start = mid+1;
			else
				end = mid-1;
			
		}
		
		return end;
	}

}
