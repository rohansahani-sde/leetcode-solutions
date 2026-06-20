class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        return fun( nums, target);
    }
    private int fun(int[] arr, int k) {
        if (k == 0) return 1;
        if (k < 0) return 0;
        if(dp[k] != -1) return dp[k];
        int count = 0;
        for (int x : arr) {
            count += fun(arr, k - x);
        }
        return dp[k] =count;
    }
}