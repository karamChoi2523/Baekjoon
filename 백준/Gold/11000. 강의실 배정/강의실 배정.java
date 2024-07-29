import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Room implements Comparable<Room> {
		int start, end;
		
		public Room(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Room o) {
			if(this.start == o.start)
				return this.end - o.end;
			return this.start-o.start;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		ArrayList<Room> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			list.add(new Room(a, b));
		}
		
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(list.get(0).end);
		
		for(int i=1;i<n;i++) {
			Room curr = list.get(i);
			
			if(pq.peek() <= curr.start)
				pq.poll();
			
			pq.offer(curr.end);
		}
		
		System.out.println(pq.size());
	}

}
