import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11724 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n =Integer.parseInt(st.nextToken());	//정점
		int m = Integer.parseInt(st.nextToken());	//간선
		
		int[][] arr = new int[n][n];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			
			int u =Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			
			arr[u][v] = arr[v][u] = 1;
		}
		//플로이드 워셜 알고리즘 i->idx->j
		for(int idx=0;idx<n;idx++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(arr[i][idx]==1 && arr[idx][j]==1)
						arr[i][j]=1;
		
		int cnt=0;
		
		ArrayList<LinkedList<Integer>> list= new ArrayList<>();
		ArrayList<Integer> skipList = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(new LinkedList<>());
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1 && !skipList.contains(j)) {
					list.get(i).add(j);
					skipList.add(j);
				}
			}
			//System.out.println(list.get(i));
		}
		
		int check=0;
		for(int i=0;i<n;i++)
			if(list.get(i).size()!=0) {
				check+=list.get(i).size();
				cnt++;
			}
		cnt += n-check;
		
		bw.write(String.valueOf(cnt));
		
		bw.close();
		bf.close();
	}

}
