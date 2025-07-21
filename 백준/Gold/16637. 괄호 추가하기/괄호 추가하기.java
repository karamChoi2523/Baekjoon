import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> numList = new ArrayList<>();
	static ArrayList<Character> opList = new ArrayList<>();
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>='0' && arr[i]<='9')
				numList.add(arr[i]-'0');
			else
				opList.add(arr[i]);
		}
		
		dfs(numList.get(0), 0);
		
		System.out.println(answer);
	}
	static void dfs(int curr, int depth) {
		if(depth>=opList.size()) {
			answer = Math.max(answer, curr);
			return;
		}
		
		int res = operate(curr, numList.get(depth+1), opList.get(depth));
		dfs(res, depth+1);
		
		if(depth+1<opList.size()) {
			res = operate(numList.get(depth+1), numList.get(depth+2), opList.get(depth+1));
			dfs(operate(curr, res, opList.get(depth)), depth+2);
		}
	}
	
	static int operate(int a, int b, char c) {
		if(c=='-') return a-b;
		else if(c=='+') return a+b;
		else return a*b;
	}
}