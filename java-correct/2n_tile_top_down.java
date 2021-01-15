class Solution {    
    int[] d = new int[60001];
    public int solution(int n) {
        return dp(n);
    }
    public int dp(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        if(d[n] != 0) return d[n];
        d[n] = (dp(n-1)+dp(n-2))%1000000007;
        return d[n];
    }
}