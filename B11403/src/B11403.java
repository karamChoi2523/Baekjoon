import java.util.Scanner;

//플로이드 와샬 알고리즘(모든 정점에서 모든 정점으로의 최단거리)
// x->y vs x->n->y
//거쳐가는 정점 n 기준

//이 문제는 경로의 유무를 판단하므로 있으면 1로 변환
public class B11403 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] list = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				list[i][j] = sc.nextInt();
		}
		
		for(int idx=0;idx<n;idx++) {
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(list[i][idx]==1 && list[idx][j]==1)	//i->idx->j 경로가 있는지
						list[i][j]=1;
		}
		
		for(int[] e : list) {
			for(int ele : e)
				System.out.print(ele+" ");
			System.out.println();
		}
	}

}
