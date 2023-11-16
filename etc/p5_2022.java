import java.util.ArrayList;

//레벨순회
public class p5_2022 {
	static ArrayList<Integer>[] childs;
	static int[] Info;
	static int maxSheepCnt = 0;
	
	static class Solution {
	    public int solution(int[] info, int[][] edges) {
	    	Info = info;

	    	//연결 만들기
	    	childs = new ArrayList[info.length];
	    	for (int[] e : edges) {
	    		int parent = e[0];
	    		int child = e[1];
	    		if (childs[parent] == null) {
	    			childs[parent] = new ArrayList<>();
	    		}
	    		childs[parent].add(child);
	    	}
	    	
	    	ArrayList<Integer> list = new ArrayList<>();
	    	list.add(0);
	    	dfs(0, 0, 0, list);
	        
	    	return maxSheepCnt;
	    }
	    private static void dfs(int idx, int sheepCnt, int wolfCnt, ArrayList<Integer> nextPos) {
	    	// 늑대/양 수, 양의 최대값 최신화
	    	if (Info[idx] == 0) sheepCnt++;
	    	else wolfCnt++;
	     
	    	if (wolfCnt >= sheepCnt) return;	//모든 양 죽음
	    	maxSheepCnt = Math.max(sheepCnt, maxSheepCnt);	//양 최대값 갱신
	     
	    	// 다음 탐색 위치 갱신
	    	ArrayList<Integer> list = new ArrayList<>();
	    	list.addAll(nextPos);
	    	// 다음 탐색 목록중 현재 위치제외
	    	list.remove(Integer.valueOf(idx));
	    	if (childs[idx] != null) {
	    		for (int child : childs[idx]) {
	    			list.add(child);
	    		}
	    	}
	    	
	    	// 갈 수 있는 모든 Node Dfs
	    	for (int next : list) {
	    		dfs(next, sheepCnt, wolfCnt, list);
	    	}
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
