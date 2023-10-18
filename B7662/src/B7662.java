import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int idx=0;idx<t;idx++) {
			int k = Integer.parseInt(bf.readLine());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			Map<Integer, Integer> map = new HashMap<>();
			
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				String comm = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if(comm.equals("I")) {
					map.put(n, map.getOrDefault(n, 0)+1);
					
					minHeap.add(n);
					maxHeap.add(n);
				}else if(comm.equals("D")) {					if(map.size()==0)
					if(map.size()==0)
						continue;
					PriorityQueue<Integer> pq = n==1? maxHeap : minHeap;
					removeMap(pq, map);
				}
			}
			if(map.size()==0)
				System.out.println("EMPTY");
			else {
				int n = removeMap(maxHeap, map);
				System.out.println(n+" "+(map.size()>0? removeMap(minHeap, map):n));
			}
		}
	}

	private static int removeMap(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
		int num;
		
		while(true) {
			num = pq.poll();
			
			int cnt = map.getOrDefault(num, 0);
			
			if(cnt==0) continue;
			if(cnt==1)
				map.remove(num);
			else
				map.put(num, cnt-1);
			
			break;
		}
		return num;
	}

}
