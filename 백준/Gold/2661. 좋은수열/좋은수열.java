import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		dfs(0, "");
		
		System.out.println(min);
	}
	static boolean isSolved = false;
	static void dfs(int idx, String s) {
		if(idx==N) {
			if(check(s)) {
					min = s;
					isSolved = true;
			}
			return;
		}
		
		if(s.length()==0) {
			dfs(idx+1, s+"1");
			if(isSolved) return;
			dfs(idx+1, s+"2");
			if(isSolved) return;
			dfs(idx+1, s+"3");
			if(isSolved) return;
		}else {
			if(!check(s)) return;
			if(s.charAt(s.length()-1)=='1') {
				dfs(idx+1, s+"2");
				if(isSolved) return;
				dfs(idx+1, s+"3");
				if(isSolved) return;
			}else if(s.charAt(s.length()-1)=='2') {
				dfs(idx+1, s+"1");
				if(isSolved) return;
				dfs(idx+1, s+"3");
				if(isSolved) return;
			}else {
				dfs(idx+1, s+"1");
				if(isSolved) return;
				dfs(idx+1, s+"2");
				if(isSolved) return;
			}
		}		
	}
	static boolean check(String s) {
		for(int len=1;len<=s.length()/2;len++)
			if(!check2(s, len)) return false;
		
		return true;
	}
	static boolean check2(String s, int len) {
		String a = s.substring(s.length()-len);
		String b = s.substring(s.length()-len*2, s.length()-len);
		
		if(a.equals(b)) return false;
		return true;
	}
}
