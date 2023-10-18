import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1753 {
	static ArrayList<Edge> eList[];
	static int[] wList;
	
	public static class Edge implements Comparable<Edge>{
		int v, w;	//끝점, 가중치
		
		public Edge() {}
		public Edge(int x, int y) {
			v = x;
			w = y;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;	//최단경로
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int k = sc.nextInt();
		
		eList = new ArrayList[v+1];
		
		for(int i=1;i<eList.length;i++)
			eList[i] = new ArrayList<Edge>();
		
		for(int j=0;j<e;j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
				
			eList[a].add(new Edge(b, c));
		}
		
		wList = new int[v+1];
		Arrays.fill(wList, Integer.MAX_VALUE);
		wList[k] = 0;
		
		dijkstra(k);
		
		for(int i=1;i<wList.length;i++) {
			if(wList[i]== Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(wList[i]);
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();	//최솟값 기준으로 들어가는 q
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge pick = pq.poll();
			
			for(Edge ie : eList[pick.v]) {
				if(wList[ie.v] > pick.w + ie.w) {
					wList[ie.v] = pick.w + ie.w;
					pq.add(new Edge(ie.v, wList[ie.v]));
				}
			}			
		}
		
	}
}
