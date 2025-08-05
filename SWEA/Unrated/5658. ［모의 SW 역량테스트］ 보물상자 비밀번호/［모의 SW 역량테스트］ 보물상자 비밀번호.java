import java.util.*;
import java.io.*;

public class Solution {
	static int N, K;
	static char[] nums;
	static Set<String> hexaSet;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			nums = br.readLine().toCharArray();
			
			hexaSet = new HashSet<>();
			for(int i=0;i<nums.length;i++)
				makeHexaSet(i);

			ArrayList<String> hexaList = new ArrayList<>();
			Iterator itr = hexaSet.iterator();
			while(itr.hasNext()) {
				hexaList.add((String) itr.next());
			}
			hexaList.sort(Comparator.comparingInt(s->Integer.parseInt(s,16)*-1));
			
			int answer = Integer.parseInt(hexaList.get(K-1), 16);
			
			System.out.printf("#%d %d\n",tc,answer);
		}
	}
	static void makeHexaSet(int start) {
		int size = nums.length/4;
		for(int i=start;i<start+nums.length;i+=size) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<size;j++) {
				sb.append(nums[(i+j)%nums.length]);
			}
			hexaSet.add(sb.toString());
		}
	}
}