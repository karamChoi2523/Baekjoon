import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> numList = new ArrayList<>();
	static ArrayList<Character> opList = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		for(char c : arr) {
			if(c>='0' && c<='9')
				numList.add(c-'0');
			else
				opList.add(c);
		}
		dfs(numList.get(0),0);
		
		System.out.println(max);
	}
	static void dfs(int curr, int depth) {
		if(depth >= opList.size()) {
			max = Math.max(curr, max);
			return;
		}
		
		//괄호x
		int res = cal(curr, numList.get(depth+1), opList.get(depth));
		dfs(res, depth+1);
		
		//괄호o
		if(depth+1<opList.size()) {
			res = cal(numList.get(depth+1), numList.get(depth+2), opList.get(depth+1));
			dfs(cal(curr, res, opList.get(depth)), depth+2);
		}
	}
	static int cal(int a, int b, char c) {
		if(c=='-') return a-b;
		if(c=='+') return a+b;
		return a*b;
	}
}