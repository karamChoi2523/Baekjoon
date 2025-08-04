import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		char[] crr = br.readLine().toCharArray();
		for(int i=0;i<N;i++) {
			if(i%2==0) nums.add(crr[i]-'0');
			else op.add(crr[i]);
		}

		combination(0, nums.get(0));

		System.out.println(max);
	}
	static void combination(int idx, int curr) {
		if(idx==op.size()) {
			max = Math.max(max, curr);
			return;
		}

		int res = cal(curr, nums.get(idx+1), op.get(idx));
		combination(idx+1, res);

		if(idx+2<nums.size()) {
			res = cal(nums.get(idx+1), nums.get(idx+2), op.get(idx+1));
			int res2 = cal(curr, res, op.get(idx));
			combination(idx+2, res2);
		}
	}
	static int cal(int a, int b, char op) {
		if(op=='-') return a-b;
		if(op=='+') return a+b;

		return a*b;
	}
}