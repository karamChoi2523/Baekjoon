import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		ArrayList<Integer> limits = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			limits.add(Integer.valueOf(st.nextToken()));
		
		int m = Integer.valueOf(br.readLine());
		ArrayList<Integer> boxes = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++)
			boxes.add(Integer.valueOf(st.nextToken()));

		Collections.sort(limits, (o1, o2)->o2-o1);
		Collections.sort(boxes, (o1, o2)->o2-o1);
		
		if(limits.get(0) < boxes.get(0)) {
			System.out.println(-1);
			return;
		}
		
		int answer = 0;
		
		while(!boxes.isEmpty()) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<boxes.size();j++)
					if(limits.get(i) >= boxes.get(j)) {
						boxes.remove(j);
						break;
					}
			}
			answer++;
		}
		
		System.out.println(answer);
	}

}
