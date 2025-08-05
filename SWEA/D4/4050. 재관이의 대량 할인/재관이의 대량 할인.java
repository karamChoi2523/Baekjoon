import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] clothes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			clothes = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int total = 0;
			for(int i=0;i<N;i++) {
				clothes[i] = Integer.parseInt(st.nextToken());
				total += clothes[i];
			}
			Arrays.sort(clothes);
			int cnt=0;
			int discount=0;
			for(int i=N-1;i>=0;i--) {
				cnt++;
				if(cnt==3) {
					cnt=0;
					discount+=clothes[i];
				}
			}
			System.out.printf("#%d %d\n",tc, total-discount);
		}
		
	}
}