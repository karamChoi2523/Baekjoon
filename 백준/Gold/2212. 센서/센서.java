import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());	//센서
		int k = Integer.valueOf(br.readLine());	//집중국
		
		if(k >= n) {
			System.out.println(0);
			return;
		}
		
		//각 집중국의 수신 가능 영역의 길의 합 최소화
		int[] list = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			list[i] = Integer.valueOf(st.nextToken());
		
		Arrays.sort(list);
		
		int[] diff = new int[n-1];
		
		for(int i=0;i<n-1;i++) {
			diff[i] = list[i+1]-list[i];
		}
		
		Arrays.sort(diff);
		
		int answer = 0;
		for(int i=0;i<diff.length-(k-1);i++)
			answer += diff[i];
		
		System.out.println(answer);
	}

}
