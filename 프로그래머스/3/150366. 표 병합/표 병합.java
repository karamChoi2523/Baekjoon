import java.util.*;

class Solution {
    static class Pos{
		int r, c;
		
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		@Override
		public boolean equals(Object obj) {
			Pos p = (Pos)obj;
			return this.r==p.r && this.c==p.c;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(r,c);
		}
	}
	static String[][] board;
    public String[] solution(String[] commands) {
        String[] answer = {};
        
        ArrayList<String> res = new ArrayList<>();
        
        board = new String[51][51];
        ArrayList<Set<Pos>> posSetList = new ArrayList<>();
        
        for(int k=0;k<commands.length;k++) {
        	String[] command = commands[k].split(" ");
        
        	if(command[0].equals("UPDATE")) {
        		int len = command.length;
        		
        		if(len==4) {
        			int r = Integer.parseInt(command[1]);
        			int c = Integer.parseInt(command[2]);
        			
        			update(new Pos(r,c), command[3], posSetList);
        		}else {
        			String val1 = command[1];
        			String val2 = command[2];
        			
        			//ArrayList<Pos> posList = new ArrayList<>();
        			for(int i=1;i<51;i++)
        				for(int j=1;j<51;j++)
        					if(board[i][j]!=null && board[i][j].equals(val1))	//병합된 곳은 어차피 같은 값
        						board[i][j] = val2;
        			/*			posList.add(new Pos(i, j));
        			
        			for(Pos p : posList) {
            			update(p, val2, posSetList);
        			}*/
        		}        		
        	}else if(command[0].equals("MERGE")){
    			int r1 = Integer.parseInt(command[1]);
    			int c1 = Integer.parseInt(command[2]);
    			int r2 = Integer.parseInt(command[3]);
    			int c2 = Integer.parseInt(command[4]);
        		
    			//같은 위치인지 판별
    			boolean check = isSamePos(r1, c1, r2, c2, posSetList);
    			if(check) continue;
    			
    			Pos pa = null;
    			Pos pb = null;
    			if(board[r1][c1]==null && board[r2][c2]!=null) {
    				update(new Pos(r1, c1), board[r2][c2], posSetList);
    				pa = new Pos(r2, c2);
    				pb = new Pos(r1, c1);
    			}else {
    				update(new Pos(r2, c2), board[r1][c1], posSetList);
    				pb = new Pos(r2, c2);
    				pa = new Pos(r1, c1);
    			}
    			//병합
    			int pickA = -1;
    			int pickB = -1;
    			Set<Pos> setA = null;
    			Set<Pos> setB = null;
    			for(int i=0;i<posSetList.size();i++) {
    				Set<Pos> posSet = posSetList.get(i);
    				if(posSet.contains(pa)) {
    					pickA = i;
    					setA = posSet;
    				}
    				
    				if(posSet.contains(pb)) {
    					pickB = i;
    					setB = posSet;
    				}
    				
    				if(pickA!=-1 && pickB!=-1) break;
    			}
    			
    			if(pickA==-1 && pickB==-1) {
    				Set<Pos> posSet = new HashSet<>();
    				posSet.add(pa);
    				posSet.add(pb);
    				posSetList.add(posSet);
    			}else if(pickA==-1) setB.add(pa);
    			else if(pickB==-1) setA.add(pb);
    			else {
    				//setA랑 setB 병합 - setA를 없애고 모든 원소를 setB에 넣는다
    				posSetList.remove(pickA);
    				for(Pos p : setA) {
    					setB.add(p);
    				}
    			}
        	}else if(command[0].equals("UNMERGE")){
    			int r = Integer.parseInt(command[1]);
    			int c = Integer.parseInt(command[2]);
    			
    			String val = board[r][c];
    			
                int idx = -1;
        		for(int i=0;i<posSetList.size();i++) {
                    Set<Pos> posSet = posSetList.get(i);
        			if(posSet.contains(new Pos(r,c))) {
        				idx = i;
                        for(Pos p : posSet) {
        					board[p.r][p.c] = null;
        				}
                        break;
        			}
        		}
                if(idx!=-1) posSetList.remove(idx);
        		
        		board[r][c] = val;
        	}else {
    			int r = Integer.parseInt(command[1]);
    			int c = Integer.parseInt(command[2]);
        		res.add(board[r][c]==null?"EMPTY":board[r][c]);
        	}
        }
        
        answer = new String[res.size()];
        for(int i=0;i<res.size();i++)
        	answer[i] = res.get(i);
        
        return answer;
    }
	private static boolean isSamePos(int r1, int c1, int r2, int c2, ArrayList<Set<Pos>> posSetList) {
		Pos pa = new Pos(r1, c1);
		Pos pb = new Pos(r2, c2);
		
		if(r1==r2 && c1==c2) return true;
		
		for(Set<Pos> posSet : posSetList) {
			if(posSet.contains(pa) && posSet.contains(pb))
				return true;
		}
		return false;
	}
	static void update(Pos p, String val, ArrayList<Set<Pos>> posSetList) {
		boolean checkP = false;
		for(Set<Pos> posSet : posSetList) {
			if(posSet.contains(p)) {
				for(Pos pos : posSet) {
					board[pos.r][pos.c] = val;
				}
				checkP = true;
				break;
			}
		}
		if(!checkP)
			board[p.r][p.c] = val;
	}
}