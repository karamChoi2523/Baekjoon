class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int cnt = 0, sum=0;
        
        while(!s.equals("1")){
            int num = 0;

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!='0')
                    num++;
            }
            sum+=s.length()-num;
            s = binary(num);
            cnt++;
        }
        
        answer = new int[]{cnt, sum};
        return answer;
    }
    static private String binary(int n){
        String ans = "";
        
        while(n>0){
            ans+=String.valueOf(n%2);
            n/=2;
        }
        return ans;
    }
}