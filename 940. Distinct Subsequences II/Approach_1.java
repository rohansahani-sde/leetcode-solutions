class Solution {
    int MOD = 1000000007;
    int[] pre;
    int[] dp;
    
    public int distinctSubseqII(String s) {
        int n = s.length();
        dp =new int[2001];
        Arrays.fill(dp, -1);
        pre = new int[n+1];
        int[] last = new int[26];
        for(int i=1; i<=n; i++){
            int idx = s.charAt(i-1) - 'a';
            pre[i] = last[idx];
            last[idx] =i;
        }
        return (fun(n) - 1 + MOD) % MOD;
    }
    private int fun(int n){
        if(n ==0) return 1;
        if(dp[n] != -1) return dp[n];

        long total = (fun(n-1) * 2L) % MOD;
        if(pre[n] != 0){
            int duplicate = fun(pre[n] -1);
            total = (total - duplicate + MOD)%MOD;
        }


        return dp[n] = (int)total;
        
    }
}