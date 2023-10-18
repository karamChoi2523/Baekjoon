import java.util.*;

public class p5 {
	static class Solution {
	    public int[] parent = new int[2501];
	    public String[] value = new String[2501];

	    //UNION-FIND 알고리즘
	    public int find(int a) {	//root를 찾는다
	        if (parent[a] == a)
	            return a;
	        else
	            return parent[a] = find(parent[a]);
	    }

	    public void union(int a, int b) {	//root가 같지 않으면 통합
	        a = find(a);
	        b = find(b);
	        if (a != b)
	            parent[b] = a;
	    }

	    //좌표를 번호로 변환
	    public int convertNum(int x, int y) {
	        int result = 50 * (x - 1);
	        return result + y;
	    }

	    public String[] solution(String[] commands) {
	        //초기화
	        for (int i = 1; i <= 2500; i++) {
	            parent[i] = i;
	            value[i] = "";
	        }

	        //명령어 실행
	        List<String> result = new ArrayList<>();
	        for (int ind = 0; ind < commands.length; ind++) {
	            String line = commands[ind];
	            StringTokenizer st = new StringTokenizer(line);
	            String command = st.nextToken();

	            if ("UPDATE".equals(command)) {
	                //UPDATE value1 value2
	                if (st.countTokens() == 2) {
	                    String before = st.nextToken();
	                    String after = st.nextToken();
	                    for (int i = 1; i <= 2500; i++) {
	                        if (before.equals(value[i]))
	                            value[i] = after;
	                    }
	                }
	                //UPDATE x y value
	                else {
	                    int x = Integer.parseInt(st.nextToken());
	                    int y = Integer.parseInt(st.nextToken());
	                    String after = st.nextToken();
	                    int num = convertNum(x, y);
	                    value[find(num)] = after;
	                }
	            } else if ("MERGE".equals(command)) {
	                int x1 = Integer.parseInt(st.nextToken());
	                int y1 = Integer.parseInt(st.nextToken());
	                int x2 = Integer.parseInt(st.nextToken());
	                int y2 = Integer.parseInt(st.nextToken());
	                int n1 = convertNum(x1, y1);
	                int n2 = convertNum(x2, y2);
	                int root1 = find(n1);
	                int root2 = find(n2);
	                //0. 같은 그룹이면 무시
	                if (root1 == root2) continue;
	                //1. 값을 가진쪽으로 병합
	                String rootString = value[root1].isBlank() ? value[root2] : value[root1];
	                value[root1] = "";
	                value[root2] = "";
	                union(root1, root2);
	                value[root1] = rootString;
	            } else if ("UNMERGE".equals(command)) {
	                int x = Integer.parseInt(st.nextToken());
	                int y = Integer.parseInt(st.nextToken());
	                int num = convertNum(x, y);
	                int root = find(num);
	                String rootString = value[root];
	                value[root] = "";
	                value[num] = rootString;
	                List<Integer> deleteList = new ArrayList<>();
	                for (int i = 1; i <= 2500; i++) {
	                    if (find(i) == root)
	                        deleteList.add(i);
	                }
	                for (Integer t : deleteList)
	                    parent[t] = t;
	            } else if ("PRINT".equals(command)) {
	                int x = Integer.parseInt(st.nextToken());
	                int y = Integer.parseInt(st.nextToken());
	                int num = convertNum(x, y);
	                int root = find(num);
	                if (value[root].isBlank())
	                    result.add("EMPTY");
	                else
	                    result.add(value[root]);
	            }
	        }
	        return result.toArray(new String[0]);
	    }

	}
	/*
	static class Solution {
	    public String[] solution(String[] commands) {
	        String[] answer = {};
	        ArrayList<String> list = new ArrayList<>();
	        int index=0;
	        String[][] table = new String[50][50];
	        String[][] backup = new String[50][50];
	        
	        for(int i=0;i<50;i++)
	        	for(int j=0;j<50;j++) {
	        		table[i][j] = null;
	        		backup[i][j]=null;
	        	}
	        
	        for(int i=0;i<commands.length;i++) {
	        	String[] str = commands[i].split(" ");
	        	switch(str[0]) {
	        	case "UPDATE":
	        		if(str.length == 4) {
	        			int r = Integer.parseInt(str[1])-1;
		        		int c = Integer.parseInt(str[2])-1;
		        		table[r][c] = str[3];
		        		backup[r][c] = table[r][c];
	        		}
	        		else if(str.length == 3) {
	        			for(int j=0;j<50;j++)
	        				for(int k=0;k<50;k++)
	        					if(table[j][k] == str[1]) {
	        						table[j][k] = str[2];
	        						backup[j][k] = table[j][k];
	        					}
	        		}
	        		break;
	        	case "MERGE":
	        		int r1 = Integer.parseInt(str[1])-1;
	        		int c1 = Integer.parseInt(str[2])-1;
	        		int r2 = Integer.parseInt(str[3])-1;
	        		int c2 = Integer.parseInt(str[4])-1;
	        		
	        		if(r1==r2 && c1==c2) break;	//같은 위치의 셀이면 무시...?
	        		
	        		if(table[r1][c1]==null)
	        			table[r1][c1] = table[r2][c2];
	        		else 
		        		table[r2][c2] = table[r1][c1];
	        		
	        		break;
	        	case "UNMERGE":
	        		int a = Integer.parseInt(str[1])-1;
	        		int b = Integer.parseInt(str[2])-1;
	        		String find = table[a][b];
	        		for(int j=0;j<50;j++)
	        			for(int k=0;k<50;k++) {
	        				if(find.equals(table[j][k])) {
	        					table[j][k] = "EMPTY";
	        				}
	        			}
	        		
	        		
	        		break;
	        	case "PRINT":
	        		int r = Integer.parseInt(str[1])-1;
	        		int c = Integer.parseInt(str[2])-1;
	        		if(table[r][c]!=null) {
	        			list.add(table[r][c]);
	        			index++;
	        			//answer[index++] = table[r][c];
	        			//System.out.println(answer[index-1]);
	        		}else {
	        			list.add("EMPTY");
	        			index++;
	        			//answer[index++] = "EMPTY";
	        			//System.out.println(answer[index-1]);
	        		}
	        		break;
	        	default: break;
	        	}
	        	
	        }
	        answer = new String[index];
	        for(int i=0;i<index;i++) {
	        	answer[i] = list.get(i);
	        	System.out.println(answer[i]);
	        }
	        return answer;
	    }
	    
	}
*/
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
		s.solution(commands);
	}

}
