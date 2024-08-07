import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int w = Integer.valueOf(st.nextToken());
		int l = Integer.valueOf(st.nextToken());
		
		Queue<Integer> bridge = new LinkedList<>();
		for(int i=0;i<w;i++)
			bridge.add(0);
		
		int sum = 0;
		int time = 0;
		
		st = new StringTokenizer(br.readLine());
		int truck = Integer.valueOf(st.nextToken());
		
		while(true) {
			time++;
			
			sum -= bridge.poll();
			
			if(sum+truck <= l) {
				bridge.add(truck);
				sum += truck;
				if(--n==0)
					break;
				
				truck = Integer.valueOf(st.nextToken());
			}else {
				bridge.add(0);
			}
		}
		time += bridge.size();
		System.out.println(time);
	}
	
}
