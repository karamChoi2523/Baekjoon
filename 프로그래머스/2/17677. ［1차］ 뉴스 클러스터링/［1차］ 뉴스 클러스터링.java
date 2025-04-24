import java.util.*;

class Solution {
    static int mod = 65536;
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        ArrayList<String> first = makeArr(str1);
        ArrayList<String> second = makeArr(str2);
        
        if(first.size()==0 && second.size()==0) return mod;
        
        if(first.size() >= second.size()) answer = sol(first, second);
        else answer = sol(second, first);
        
        return answer;
    }
    static private ArrayList<String> makeArr(String s){
        ArrayList<String> res = new ArrayList<>();
        
        for(int i=0;i<s.length()-1;i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            
            if(isAlphabet(a) && isAlphabet(b)){
                res.add(String.valueOf(a)+String.valueOf(b));
            }else if(!isAlphabet(b)) i++;
        }
        
        return res;
    }
    static private boolean isAlphabet(char a){
        if(a>='A' && a<='Z') return true;
        
        return false;
    }
    static private int sol(ArrayList<String> big, ArrayList<String> small){
        System.out.println(big);
        System.out.println(small);
        
        int cnt = 0;
        
        for(String e : small){
            if(big.contains(e)){
                cnt++;
                big.remove(e);
            }
        }
        
        
        return mod*cnt/(small.size()+big.size());
    }
}