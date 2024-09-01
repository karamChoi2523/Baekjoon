import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<n;i++)
			list.add(br.readLine());
		
		ArrayList<String> keys = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String[] str = list.get(i).split(" ");
			
			boolean check = false;
			//단어 첫 글자
			for(int j=0;j<str.length;j++) {
				String curr = String.valueOf(str[j].charAt(0));
				if(!keys.contains(curr.toUpperCase())) {
					check = true;
					keys.add(curr.toUpperCase());
					//j번째 단어의 0번째 인덱스
					int index=0;
					for(int k=0;k<j;k++)
						index += str[k].length()+1;
					
					list.set(i, list.get(i).substring(0, index)+"["+curr+"]"+list.get(i).substring(index+1));
					break;
				}
			}
			
			if(check)
				continue;
			
			String curr = list.get(i);
			for(int j=0;j<curr.length();j++) {
				String s = String.valueOf(curr.charAt(j));
				if(curr.charAt(j)!=' ' && !keys.contains(s.toUpperCase())) {
					keys.add(s.toUpperCase());
					list.set(i, curr.substring(0, j)+"["+String.valueOf(curr.charAt(j))+"]"+curr.substring(j+1));
					break;
				}
			}
					
		}
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		
	}

}
