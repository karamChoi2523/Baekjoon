import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//그리디 알고리즘 - 활동 선택 문제
public class Main {
	static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		
		board = new int[n][2];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			board[i][0]=Integer.valueOf(st.nextToken());
			board[i][1]=Integer.valueOf(st.nextToken());	
		}
		//종료시간 빨라야 다른 회의 시작
		Arrays.sort(board, new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];	//시작 시간 빠른 순
				return o1[1] - o2[1];
			}
			
		});
		
		int cnt = 1;
		Meeting pre = list.get(0);
		
		for(int i=1;i<n;i++) {
			Meeting curr = list.get(i);
			if(curr.start >= pre.end) {
				pre = curr;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
