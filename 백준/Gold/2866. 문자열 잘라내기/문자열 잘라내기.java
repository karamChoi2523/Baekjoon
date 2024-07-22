import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static String[][] board;
	static int r,c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		
		board = new String[r][c];
		
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			
			for(int j=0;j<c;j++)
				board[i][j] = String.valueOf(s.charAt(j));
		}
		
		int answer = binarySearch(0, r-1);
		
		System.out.println(answer);
	}

	private static int binarySearch(int start, int end) {
		while(start <= end) {
			int mid = (start+end)/2;
			
			Set<String> set = new HashSet<>();
			boolean check = true;
			
			for(int i=0;i<c;i++) {
				String s = "";
				for(int j=mid+1;j<r;j++) {
					s+=board[j][i];
				}
				if(set.contains(s)) {
					check = false;
					break;
				}
				set.add(s);
			}
			
			if(check)
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		return start;
	}

}
