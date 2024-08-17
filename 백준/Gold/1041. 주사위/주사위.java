import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] dice = new long[6];
		
		for(int i=0;i<6;i++)
			dice[i] = Long.valueOf(st.nextToken());
		
		
		long answer = 0;
		
		if(n==1) {
			Arrays.sort(dice);
			for(int i=0;i<5;i++)
				answer += dice[i];
		}else {
			long[] num = new long[4];
			num[3] = 4;
			num[2] = 8*(n-2)+4;
			num[1] = 5*(n-2)*(n-2) + 4*(n-2);
			
			long min = dice[0];
			//면 1개
			for(int i=1;i<6;i++)
				min = Math.min(min, dice[i]);
			answer += num[1]*min;
			
			//면 2개
			min = Long.MAX_VALUE;
			
			for(int i=0;i<6;i++)
				for(int j=i+1;j<6;j++)
					if(i+j!=5)
						min = Math.min(min, dice[i]+dice[j]);
			answer += num[2]*min;
			
			//면 3개
			long sum = 0;
			for(int i=0;i<3;i++)
				sum += Math.min(dice[i], dice[6-i-1]);
		
			answer += num[3]*sum;
		}
		
		System.out.println(answer);
	}

}
