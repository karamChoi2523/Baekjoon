class Solution {
    static private int sol(int begin, int end, int w){
        int ans = (end-begin+1)/(w*2+1);
        if((end-begin+1)%(w*2+1) > 0)
            ans++;
        
        return ans;
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int begin = 1;
        
        for(int i=0;i<stations.length;i++){
            if(begin < stations[i]-w)
                answer+=sol(begin, stations[i]-w-1, w);
            begin = stations[i]+w+1;
        }
        
        if(stations[stations.length-1]+w<n)
            answer+=sol(stations[stations.length-1]+w+1, n, w);

        return answer;
    }
}