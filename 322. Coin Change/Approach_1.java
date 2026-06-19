class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        for( int[] d: dp)Arrays.fill(d, -1);
        int ans= fun(coins, amount, 0);
        return ans ==Integer.MAX_VALUE ? -1 : ans;
    }
    private int fun(int[] arr, int amt, int idx){
        if(amt ==0)return 0;
        if(idx >= arr.length || amt < 0 )return Integer.MAX_VALUE;
        if(dp[idx][amt] != -1) return dp[idx][amt];
        int take = fun(arr, amt-arr[idx], idx);
        if(take != Integer.MAX_VALUE) take++;
        
        int not = fun(arr, amt, idx+1);
        
        return dp[idx][amt] = Math.min(take, not);
    }
}