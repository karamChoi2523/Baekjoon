import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine().trim());

			String origin = "";
			for(int i=0;i<N;i++)
				origin+=br.readLine().trim();
			
			char[] origins = origin.toCharArray();
			
			int f=0, b=N-1;
			StringBuilder sb = new StringBuilder();
			while(f<=b) {
				if(origin.charAt(f)<origin.charAt(b))
					sb.append(origins[f++]);
				else if(origin.charAt(f)>origin.charAt(b))
					sb.append(origins[b--]);
				else {
					int front = f+1;
					int behind = b-1;
					
					while(front<=behind && origin.charAt(front)==origin.charAt(behind)) {
						front++;
						behind--;
					}
					if(origins[front]<origins[behind])
						sb.append(origins[f++]);
					else
						sb.append(origins[b--]);
				}
			}

			System.out.printf("#%d %s\n",tc,sb.toString());
		}
	}
}
