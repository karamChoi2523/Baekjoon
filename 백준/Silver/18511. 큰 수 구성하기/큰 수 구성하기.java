import java.io.*;
import java.util.*;

public class Main {
	static int N,K;
	static ArrayList<Integer> kList;
	static int result=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		kList = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<K;i++) {
			int t = Integer.parseInt(st.nextToken());
			kList.add(t);
		}
		
		solution(new StringBuilder(), 0);
		
		System.out.println(result);
	}

	private static void solution(StringBuilder sb, int level) {
		if(level>0) {
			int a = Integer.parseInt(sb.toString());
			if(a>N) return;
			else
				result = Math.max(result, a);
		}
		for(int i=0;i<K;i++) {
			sb.append(kList.get(i));
			solution(sb, level+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
