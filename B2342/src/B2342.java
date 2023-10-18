import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;

public class B2342 {
	static ArrayList<Integer> input;
	//dp[i][j][k] : 왼발(j), 오른발(k) - i번째 스텝일때 최댓값
	static int[][][] dp; // i <= 100000
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		input = new ArrayList<Integer>();
		while(true) {
			int in = Integer.parseInt(st.nextToken());
			
			if (in==0)
				break;
			
			input.add(in);
		}

		N = input.size();
		dp = new int[N+1][5][5];
		
		int ans = DDR(0, 0, 0);
		bw.write(ans + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static int DDR(int step, int left, int right) {
		if (step == N)
			return 0;

		if (dp[step][left][right]!=0) {
			return dp[step][left][right];
		}

		int leftScore = score(left, input.get(step)) + DDR(step + 1, input.get(step), right); 
		int rightScore = score(right, input.get(step)) + DDR(step + 1, left, input.get(step)); 
		
		return dp[step][left][right] = Math.min(leftScore, rightScore);
	}

    static int score(int from, int to){
    	if(from==to)	//현위치
    		return 1;
        if(from==0)	//가운데
        	return 2;
        if(Math.abs(from-to) ==2)	//반대편
        	return 4;
        
        return 3;
    }
}
