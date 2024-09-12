import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] list;
	static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		list = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			list[i] = Long.valueOf(st.nextToken());
		
		Arrays.sort(list);
		
		for(int i=0;i<n;i++) {
			binarySearch(0, n-1, i);
		}
		System.out.println(cnt);
	}

	private static void binarySearch(int start, int end, int targetIdx) {
		while(start<end) {
			if(start==targetIdx) {
				start++;
                continue;
			}else if(end==targetIdx) {
				end--;
                continue;
			}
		
			long sum = list[start]+list[end];
			
			if(sum > list[targetIdx]) {
				end--;
			}else if(sum<list[targetIdx])
				start++;
			else{
                cnt++;
                break;
            }
		}
	}

}
