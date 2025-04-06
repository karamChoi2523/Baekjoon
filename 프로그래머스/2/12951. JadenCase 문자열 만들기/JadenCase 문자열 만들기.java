class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] sArr = s.split(" ");
        for(String t : sArr){
            
            if(t.length()==0) answer+=" ";
            
            else{
                answer+=t.substring(0,1).toUpperCase();
                answer+=t.substring(1,t.length()).toLowerCase()+" ";   
            }
        }
        
        if(s.charAt(s.length()-1)==' ') return answer;

        answer = answer.substring(0,answer.length()-1);
        return answer;
    }
}