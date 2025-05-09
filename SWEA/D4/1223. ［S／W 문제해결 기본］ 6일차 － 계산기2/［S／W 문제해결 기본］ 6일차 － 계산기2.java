import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int len = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<Integer> stack = new Stack<>();
			
			for(int i=0;i<s.length();i++) {
				int temp = (int)(s.charAt(i)-'0');
				
				if(temp>=0 && temp<=9) {
					stack.add(temp);
				}else {
					if(s.charAt(i)=='*') {
						int e = stack.pop();
						stack.add(e*(int)(s.charAt(i+1)-'0'));
						i++;
					}
				}
			}
			
			int answer=0;
			while(!stack.isEmpty())
				answer += stack.pop();
			
			
			System.out.printf("#%d %d\n",t, answer);
		}
		br.close();
	}
}
