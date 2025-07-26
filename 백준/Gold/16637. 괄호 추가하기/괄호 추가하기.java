import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> numList = new ArrayList<>();
	static ArrayList<Character> opList = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(i%2==0)
				numList.add(arr[i]-'0');
			else
				opList.add(arr[i]);
		}
		
		dfs(0,numList.get(0));
		
		System.out.println(max);
	}
	static void dfs(int step, int curr) {
		if(step==opList.size()) {
			max = Math.max(max, curr);
			return;
		}
		//괄호x
		int res = cal(curr,numList.get(step+1),opList.get(step));
		dfs(step+1, res);
		
		if(step+2<numList.size()) {
			res = cal(numList.get(step+1),numList.get(step+2),opList.get(step+1));
			curr = cal(curr, res, opList.get(step));
			dfs(step+2, curr);
		}
	}
	
	static int cal(int a, int b, char op) {
		if(op=='+')
			return a+b;
		else if(op=='-')
			return a-b;
		
		return a*b;
	}
}
