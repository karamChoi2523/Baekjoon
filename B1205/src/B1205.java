import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int newS = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		if(n==0) {
			System.out.println("1");
			return;
		}
		
		st = new StringTokenizer(bf.readLine());
		int rank=-1;
		int pre = -1;
		int pIdx = -1;
		
		for(int i=1;rank==-1 && i<=n;i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(cur < newS)
				rank = pre==newS? pIdx:i;
			if(pre!=cur) {
				pre = cur;
				pIdx = i;
			}
		}
		
		if (rank == -1 && n+1 <= p)
			rank = newS == pre ? pIdx : n+1;

	        System.out.println(rank <= p ? rank : -1);
	}
}
