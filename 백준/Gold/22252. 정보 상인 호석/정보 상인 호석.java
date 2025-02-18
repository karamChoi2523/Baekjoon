import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Q = Integer.parseInt(br.readLine());
		Map<String, ArrayList<Integer>> gorilla = new HashMap<>();
		long answer = 0;
		
		while(Q-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			if(num==1) {
				String name = st.nextToken();
				int k = Integer.parseInt(st.nextToken());
				ArrayList<Integer> costs = gorilla.get(name)==null? new ArrayList<>():gorilla.get(name);
				
				for(int i=0;i<k;i++)
					costs.add(Integer.parseInt(st.nextToken()));
				
				Collections.sort(costs);
				gorilla.put(name, costs);
			}else {
				String name = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				
				ArrayList<Integer> costs = gorilla.get(name);
				
				if(costs==null)
					continue;
				
				if(costs.size()<=b) {
					for(int cost : costs) {
						answer += cost;
					}
					gorilla.put(name, null);
				}else {
					while(b-->0) {
						answer += costs.get(costs.size()-1);
						costs.remove(costs.size()-1);
					}
					gorilla.put(name, costs);
				}
			}
		}
		
		System.out.println(answer);
	}
}
