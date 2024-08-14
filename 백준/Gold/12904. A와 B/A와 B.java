import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s= br.readLine();
		String t = br.readLine();
		
		while(s.length() < t.length()) {
			if(t.endsWith("A"))
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
