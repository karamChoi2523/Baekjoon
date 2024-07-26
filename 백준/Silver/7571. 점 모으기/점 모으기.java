import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		int[] xList = new int[m];
		int[] yList = new int[m];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			xList[i] = a;
			yList[i] = b;
		}
		
		Arrays.sort(xList);
		Arrays.sort(yList);
		
		int x, y;
		
		if(m%2==1) {
			x = xList[m/2];
			y = yList[m/2];
		}else {
			x = (xList[m/2] + xList[m/2-1])/2;
			y = (yList[m/2] + yList[m/2-1])/2;
		}

		int cnt = 0;
		
		for(int i=0;i<m;i++) {
			cnt += Math.abs(x-xList[i]);
			cnt += Math.abs(y-yList[i]);
		}
		
		System.out.println(cnt);
	}

}
