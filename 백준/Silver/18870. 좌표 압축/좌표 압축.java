import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		int[] list = new int[n];
		int[] sorted = new int[n];
		HashMap<Integer, Integer> hMap = new HashMap<>();	//수, 순위
		
		for(int i=0;i<n;i++)
			list[i] = sorted[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(sorted);
		
		int rank=0;
		
		for(int i=0;i<n;i++)
			if(!hMap.containsKey(sorted[i]))
				hMap.put(sorted[i], rank++);
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(hMap.get(list[i])).append(' ');
		}
		
		System.out.println(sb);
	}

}
