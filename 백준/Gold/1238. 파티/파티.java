import java.io.*;
import java.util.*;


public class Main {
	static public class City implements Comparable<City>{
		int end;
		int cost;
		
		public City(int e, int c) {
			end = e;
			cost = c;
		}

		@Override
		public int compareTo(City o) {
			return this.cost-o.cost;
		}
		
		
	}
	
	static int n, m, x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		x = Integer.valueOf(st.nextToken());

		List<List<City>> adj = new ArrayList<>();
		List<List<City>> reversedAdj = new ArrayList<>();
		
		for(int i=0;i<n+1;i++) {
			adj.add(new ArrayList<>());
			reversedAdj.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			int cost = Integer.valueOf(st.nextToken());
			
			adj.get(s).add(new City(e, cost));
			reversedAdj.get(e).add(new City(s, cost));
		}
		
		int[] distX = dijkstra(adj);	//X에서 시작점으로
		int[] dist = dijkstra(reversedAdj);	//시작점에서 X로
		
		int max = -1;
		for(int i=1;i<n+1;i++) {
			max = Math.max(max, dist[i]+distX[i]);
		}
		
		System.out.println(max);
	}
	private static int[] dijkstra(List<List<City>> adj) {
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.offer(new City(x,0));
		
		boolean[] check = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, (int)1e9);
		dist[x] = 0;
		
		while(!pq.isEmpty()) {
			City curr = pq.poll();
			
			int end = curr.end;
			
			if(!check[end]) {
				check[end] = true;
				
				for(City city : adj.get(end)) {
					if(!check[city.end] && dist[city.end] > dist[end]+city.cost) {
						dist[city.end] = dist[end]+city.cost;
						pq.add(new City(city.end, dist[city.end]));
					}
				}
			}
		}
		
		return dist;
	}
}
