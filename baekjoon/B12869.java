import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//????
public class B12869 {
	static int n;
	static int[][] calc = { {9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
	static int[][][] dp = new int[61][61][61];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        
        for(int i=0;i<61;i++){
            for(int j=0;j<61;j++)
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
        }
        
        Integer[] scv = new Integer[3];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        for(int i=0;i<n;i++)
            scv[i] = Integer.parseInt(st.nextToken());
        for(int i=n;i<3;i++)
            scv[i] = 0;

        bw.write(search(scv.clone(),0) + "");
        bw.flush();
        bw.close();
        bf.close();
	}

	private static int search(Integer[] scv, int cnt) {
		boolean check = false;
		
		for(int i=0;i<n;i++)
			if(scv[i]!=0) {
				check=true;
				break;
			}
		
		if(!check)
			return cnt;
		else {
			Arrays.sort(scv, Collections.reverseOrder());
			
			if(dp[scv[0]][scv[1]][scv[2]]!=Integer.MAX_VALUE)
				return dp[scv[0]][scv[1]][scv[2]];
			
			for(int i=0;i<6;i++){
				Integer[] temp = new Integer[3];
				temp[0] = Math.max(scv[0]-calc[i][0], 0);
				temp[1] = Math.max(scv[1]-calc[i][1], 0);
				temp[2] = Math.max(scv[2]-calc[i][2], 0);
				
				dp[scv[0]][scv[1]][scv[2]] = Math.min(dp[scv[0]][scv[1]][scv[2]], search(temp, cnt+1));
			}
		}
		return dp[scv[0]][scv[1]][scv[2]];
	}

}
