import java.io.*;

public class Main {
	static String s, t;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s= br.readLine();
		t = br.readLine();
		
		while(s.length() < t.length()) {
			if(t.charAt(t.length()-1) =='A')
				t = t.substring(0, t.length()-1);
			else {
				t = t.substring(0, t.length()-1);
				StringBuffer sb = new StringBuffer();
				
				t = sb.append(t).reverse().toString();
			}
		}
		
		if(s.equals(t))
			System.out.println(1);
		else
			System.out.println(0);
	}

}
