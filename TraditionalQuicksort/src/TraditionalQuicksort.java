import java.util.Random;

public class TraditionalQuicksort {

	public static void main(String[] args) {
		long starttime = System.nanoTime();
		
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		int[] arr = new int[6400000];
		int n = 257;
		
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
		
		long endtime = System.nanoTime();
		long estimatedTime = endtime - starttime;
		
		System.out.println(estimatedTime);
	}
	public static void quickSort(int[] A, int p, int r)
	{
		int q;
		
		if(p<r) {
			q = partition(A, p, r);
			
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
	}
	
	public static int partition(int[] A, int p, int r)
	{
		int i,j;
		
		i=p-1;
		
		for(j=p;j<r;j++) {
			if(A[j] < A[r]) {
				int t = A[j];
				A[j] = A[r];
				A[r] = t;
			}
		}
		i++;
		
		int t = A[i];
		A[i] = A[r];
		A[r] = t;
		
		return i;
	}
}
