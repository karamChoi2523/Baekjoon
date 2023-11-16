import java.util.Random;
import java.util.Scanner;

public class HW_dualPivotInsertion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		int[] arr = new int[10000];
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			arr[i] = r.nextInt(513)+1;
		}
		
		System.out.println("정렬 전 : ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		
		quickSort(arr, 0, n-1);
		
		System.out.println("정렬 후 : ");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void quickSort(int[] A, int p, int r) 
	{
		int qA, qB;
		int[] pivots;
		
		if(p<r) {
			pivots = partition(A, p, r);	//qB(g)랑 qA(l) 구함
			qA = pivots[0];
			qB = pivots[1];
			
			quickSort(A, p, qA-1);
			quickSort(A, qA+1, qB-1);
			quickSort(A, qB+1, r);
		}
	}
	
	public static int[] partition(int[] A, int p, int r)
	{
		int l,k,g;
		
		if(A[p] > A[r]) 
			swap(A, p, r);
		
		l = p+1;
		g = r-1;
		k = p+1;
		
		int pv1 = A[p];
		int pv2 = A[r];
		
		while(k<=g) {
			if(A[k] < pv1) {
				swap(A, k ,l);
				l++;
			}else if(A[k] >= pv2) {
				while(A[g] >=pv2 && k < g)
					g--;
				int t = A[k];
				A[k] = A[g];
				A[g]= t;
				g--;
				
				if(A[k] < pv1) {
					t = A[k];
					A[k] = A[l];
					A[l] = t;
					l++;
				}
			}
			k++;		
		}
		l--;
		g++;
		
		int t = A[p];
		A[p] = A[l];
		A[l] = t;
		
		t = A[r];
		A[r] = A[g];
		A[g] = t;
		
		return new int[] {l,g};
	}
	
	static void swap(int[] A, int a, int b)
	{
		int t = A[a];
		A[a] = A[b];
		A[b] = t;
	}
}
