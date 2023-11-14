import java.util.Scanner;

public class B7568 {
	static class Person{
		int height;
		int weight;
		
		public Person(int h, int w) {
			height = h;
			weight = w;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Person[] list = new Person[n];
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			list[i] = new Person(x, y);
		}
		
		for(int i=0;i<n;i++) {
			int rank=1;
			for(int j=0;j<n;j++) {
				if(list[j].height > list[i].height && list[j].weight>list[i].weight)
					rank++;
			}
			System.out.print(rank+" ");
		}
	}

}
