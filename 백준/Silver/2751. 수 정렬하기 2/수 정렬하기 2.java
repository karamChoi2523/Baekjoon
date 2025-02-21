import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> tSet = new TreeSet<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++)
			tSet.add(Integer.parseInt(br.readLine()));
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Integer> itr = tSet.iterator();
		
		while(itr.hasNext()) {
			sb.append(itr.next()+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
