import java.util.*;

public class B14889 {
	static int n;
	static int arr[][];
	static boolean visited[];	//true�� start��, false�� link��
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		//�Է�
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				arr[i][j] = sc.nextInt();
		//�� ������
		dfs(1,0);
		
		System.out.println(min);
		
		sc.close();
	}
	//�� �� �� ���ϱ�
	public static void diff() {
		int start=0;
		int link=0;
		//[i]�� [j]�� ��� true�̸� start��, ��� false�̸� link��
		for(int i=1;i<n;i++)
			for(int j=i+1;j<=n;j++) {
				if(visited[i] && visited[j]) {
					start += arr[i][j] + arr[j][i];
				}else if(!visited[i] && !visited[j])
					link += arr[i][j] + arr[j][i];
			}
		
		int res = Math.abs(start-link);
		
		if(res==0) {
			System.out.println(res);
			System.exit(0);
		}
		
		min = Math.min(min, res);
	}
	
	public static void dfs(int index, int depth) {
		if(depth == n/2){	//(n/2)�� ����
			diff();
			return;
		}
		
		for(int i=index;i<=n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
}
