import java.io.*;
import java.util.StringTokenizer;

public class B1446 {
	public static void main(String[] args) throws IOException {	//지름길
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//세준이가 운전해야 하는 거리의 최솟값
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());	// 0 < 지름길 개수 <= 12
		int d = Integer.parseInt(st.nextToken());	//고속도로 길이 <= 10000
		int[][] list = new int[n][3];	// 0 <= 시작위치 < 도착 위치, 지름길 길이	<10000
		
		int[] dk = new int[d+1];	//각 지점(거리)에서의 최소 거리 저장
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++)
				if(list[i][0] > list[j][0]) {
					int[] temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
		}
		/*
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++)
				System.out.print(list[i][j]+" ");
			System.out.println();
		}
		*/
		
		
		for(int i=0;i<d+1;i++)
			dk[i] = i;
		
		for(int i=0;i<n;i++) {	
			for(int j=1;j<d+1;j++) {
				if(list[i][1] <=d && (list[i][1]-list[i][0] >= list[i][2])) {
					if(dk[list[i][1]] > dk[list[i][0]]+list[i][2])
						dk[list[i][1]] = dk[list[i][0]]+list[i][2];
				}
				dk[j] = dk[j] > dk[j-1]+1? dk[j-1]+1 : dk[j];
			}
		}
		
		bw.write(String.valueOf(dk[d]));
		bw.flush();
		bw.close();

	}
}
