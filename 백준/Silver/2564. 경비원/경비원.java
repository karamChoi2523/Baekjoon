import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static public class Store{
		int dir, dist;
		
		public Store(int dir, int dist) {
			this.dir = dir;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());

		int k = Integer.valueOf(br.readLine());
		
		ArrayList<Store> stores = new ArrayList<>();
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			stores.add(new Store(a,b));
		}
		st = new StringTokenizer(br.readLine());
		int dDir = Integer.valueOf(st.nextToken());
		int dDist = Integer.valueOf(st.nextToken());;
		
		int sum = 0;
		for(Store store : stores) {
			if(store.dir == dDir) {
				sum += Math.abs(dDist-store.dist);
			}else {
				if(dDir + store.dir == 3 || dDir+store.dir == 7) {	//마주볼 때
					if(dDir == 3 || dDir == 4) {
						int a = dDist + store.dist;
						int b = n*2-(dDist+store.dist);;
						
						sum += m + Math.min(a, b);
					}else if(dDir == 1 || dDir == 2) {
						int a = dDist + store.dist;
						int b = m*2-(dDist+store.dist);;
						
						sum += n + Math.min(a, b);
					}
				}else {	//붙어있는 변일 때
					if(dDir==3) {
						if(store.dir == 1)
							sum += (dDist+store.dist);
						else if(store.dir == 2)
							sum += (n-dDist+store.dist);
					}else if(dDir == 1) {
						if(store.dir == 3) {
							sum += (dDist+store.dist);
						}else if(store.dir == 4) {
							sum += (m-dDist+store.dist);
						}
					}else if(dDir == 4) {
						if(store.dir == 1)
							sum += (dDist+m-store.dist);
						else if(store.dir == 2)
							sum += (n-dDist+m-store.dist);
					}else if(dDir == 2) {
						if(store.dir == 3) {
							sum += (dDist + n-store.dist);
						}else if(store.dir == 4) {
							sum += (m-dDist+n-store.dist);
						}
					}
				}
				
			}
		}
		
		System.out.println(sum);
	}

}
