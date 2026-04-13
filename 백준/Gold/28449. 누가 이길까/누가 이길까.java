import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static int[] t1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		t1 = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int index = Integer.parseInt(st.nextToken());
			t1[index]++;
		}
		for(int i=1;i<100001;i++)
			t1[i] += t1[i-1];
		
		long win = 0, draw=0, lose=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int index = Integer.parseInt(st.nextToken());
			win += N-t1[index];
			lose += t1[index-1];
			draw += t1[index]-t1[index-1];
		}
		
		//t1 승리 횟수, t2 승리 횟수, 무승부 횟수
		System.out.println(win+" "+lose+" "+draw);
	}
}
