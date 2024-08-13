import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long[] cards;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());

		cards = new long[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			cards[i] = Long.valueOf(st.nextToken());
		
		for(int i=0;i<m;i++) {
			Arrays.sort(cards);
			long sum = cards[0]+cards[1];
			cards[0] = sum;
			cards[1] = sum;
		}
		
		long answer = 0;
		for(int i=0;i<n;i++)
			answer += cards[i];
		
		System.out.println(answer);
	}

}
