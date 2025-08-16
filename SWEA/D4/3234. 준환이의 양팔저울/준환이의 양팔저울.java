import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static int[] arr;
    static int right=0, left=0;
    static int cnt = 0;
    //오<=왼, 조합 -> factorial
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
            	arr[i] = Integer.parseInt(st.nextToken());
            
            visited = new boolean[N];
            select = new int[N];
            cnt = 0;
            permutation(0);
            System.out.printf("#%d %d\n",test_case,cnt);
		}
	}
    static void sol(int idx){
    	if(idx==N){
            cnt++;
        	return;
        }
        
        if(right+select[idx]<=left){
        	right += select[idx];
            sol(idx+1);
            right -= select[idx];
        }
        
        left+=select[idx];
        sol(idx+1);
        left -= select[idx];
    }
    static boolean[] visited;
    static int[] select;
    static void permutation(int idx){
    	if(idx==N){
            //System.out.println(Arrays.toString(select));
            sol(0);
        	return;
        }
        
        for(int i=0;i<N;i++){
        	if(!visited[i]){
            	visited[i] = true;
                select[idx] = arr[i];
                permutation(idx+1);
                visited[i] = false;
            }
        }
    }
}