import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Person implements Comparable<Person> {
		int score1;
		int score2;
		
		public Person(int s1, int s2) {
			score1 = s1;
			score2 = s2;
		}

		@Override
		public int compareTo(Person o) {
			return this.score1 - o.score1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int test=0;test<t;test++) {
			int n = Integer.valueOf(br.readLine());
			
			ArrayList<Person> list = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int s1 = Integer.valueOf(st.nextToken());
				int s2 = Integer.valueOf(st.nextToken());
				
				list.add(new Person(s1, s2));
			}
			
			Collections.sort(list);
			
			int cnt=1;
			int min = list.get(0).score2;
			
			for(int i=1;i<n;i++) {
				Person curr = list.get(i);
				
				if(curr.score2 < min) {
					cnt++;
					min = curr.score2;
				}
			}
			
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
