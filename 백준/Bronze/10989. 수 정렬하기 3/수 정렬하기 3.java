import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
        
        int[] list = new int[n];
        
        for(int i=0;i<n;i++)
            list[i] = Integer.valueOf(br.readLine());
        
        Arrays.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(int e : list)
            sb.append(e+"\n");
        
        System.out.println(sb.toString());
	}
}
