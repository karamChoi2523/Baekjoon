import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 Integer n = Integer.parseInt(bf.readLine());
		 
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 dfs(n, 0);
		 
		 System.out.println(min);
		 
		 bw.flush();
		 bw.close();
	}
	static void dfs(int x, int cnt) {
		if(cnt>min) return;
        if(x==1 && cnt<min) {
			min = cnt;
			return;
		}
		
		if(x%3==0)
			dfs(x/3, cnt+1);
		if(x%2==0)
			dfs(x/2, cnt+1);
		dfs(x-1, cnt+1);
		
	}
}