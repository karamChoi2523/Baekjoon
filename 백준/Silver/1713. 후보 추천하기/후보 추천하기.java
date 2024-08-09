import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student>{
		int num;
		int cnt;
		int time;
		
		public Student(int num, int cnt, int time) {
			this.num = num;
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(Student o) {
            if(this.cnt == o.cnt)
                return this.time - o.time;
			return this.cnt - o.cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());
		int total = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Student> answer = new ArrayList<>();
		//HashMap<Integer, Student> answer = new HashMap<>();
		
		for(int i=0;i<total;i++) {
			int num = Integer.valueOf(st.nextToken());
			
			//있는지 확인
			int j=0;
			for(;j<answer.size();j++)
				if(answer.get(j).num == num) {
					Student s = answer.get(j);
					s.cnt++;
					answer.set(j, s);
					break;
				}
			if(j==answer.size()) {	//없으면
				if(answer.size()<n) {
					answer.add(new Student(num, 1, i));
				}else {
					Collections.sort(answer);
					Student target = answer.get(0);
					
					answer.remove(target);
					answer.add(new Student(num, 1, i));
				}
			}			
		}
		
		Collections.sort(answer, (o1,o2)->o1.num-o2.num);
		
		for(Student stu : answer) {
			System.out.print(stu.num+" ");
		}
	}

}
