import java.util.*;

public class B1182 {
	static ArrayList<Integer> list = new ArrayList<>();	//최대 크기 20
	private static int n, s;
	private static int cnt=0;
	
	public static void main(String[] args) {
		//n개의 정수로 이루어진 수열
		//크기가 양수인 부분수열 중 그 수열의 원소 합 = s인 경우의 수
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		//오름차순 정렬
		Collections.sort(list);
		
		dfs(0, 0);
		
		if(s==0)
			cnt -=1;
		System.out.println(cnt);
		
		sc.close();
	}
	//단말 노드에 원소를 모두 더한 것, 둘씩 더한 경우들, 셋씩 더한 경우들...모두 나온다. 그 중 sum이 s인 것만 찾는다.
	public static void dfs(int depth, int sum) {
		if(depth==n) {
			if(sum==s)
				cnt++;
			return;
		}
		dfs(depth+1, list.get(depth)+sum);
		dfs(depth+1, sum);
	}

}
