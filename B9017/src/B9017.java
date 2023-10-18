import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B9017 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			int[] inputArr= new int[n];
			int[] countArr = new int[201];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n ; j++) {
				inputArr[j] = Integer.parseInt(st.nextToken());
				countArr[inputArr[j]]++;
			}
			
			ArrayList<Integer>[] list = new ArrayList[201];
			for (int j = 1; j < 201; j++) {
				list[j] = new ArrayList<Integer>();
			}
            
			int score=1;
			for (int j = 0; j < n ; j++) {
				if(countArr[inputArr[j]]<6) continue;
				list[inputArr[j]].add(score++);
			}

			int min = Integer.MAX_VALUE;
			int idx = 1;
			for (int j = 1; j < 201; j++) {
				if (list[j].size() >= 6) {
					int sum = 0;
					for (int k=0;k<4;k++) {
						sum += list[j].get(k);
					}
					if (min > sum) {
						min = sum;
						idx = j;
					} else if (min == sum) {
						if (list[idx].get(list[idx].size() - 2) > list[j].get(list[j].size() - 2)) {
							idx = j;
						}
					}
				}
			}

			System.out.println(idx);

		}

	}

}