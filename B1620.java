import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());	//도감 속 포켓몬
		int m = Integer.parseInt(st.nextToken());	//맞춰야 할 문제 개수
		HashMap<Integer, String> hMapN = new HashMap<>();
		HashMap<String, Integer> hMapE = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			hMapN.put(i+1, s);
			hMapE.put(s,i+1);
		}
		
		for(int i=0;i<m;i++) {
			String s = bf.readLine();
			if(isInteger(s)) {
				System.out.println(hMapN.get(Integer.valueOf(s)));
			}else {
				System.out.println(hMapE.get(s));
			}
		}
	}

	private static boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

}
