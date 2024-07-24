import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Person implements Comparable<Person> {
		int rank1;	//서류 순위
		int rank2;	//면접 순위
		
		public Person(int rank1, int rank2) {
			this.rank1 = rank1;
			this.rank2 = rank2;
		}

		@Override
		public int compareTo(Person o) {
			return this.rank1 - o.rank1;
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
			int pre = list.get(0).rank2;	//서류 점수 가장 높은 사람의 면접 순위
			
			for(int i=1;i<n;i++) {
				Person curr = list.get(i);
				
				//이전 합격자보다 면접 시험 못 본 사람 탈락
				if(curr.rank2 < pre) {	//이전 사람보다 면접 순위가 높으면
					cnt++;
					pre = curr.rank2;
				}
			}
			
			sb.append(cnt+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
